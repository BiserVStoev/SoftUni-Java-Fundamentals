package game;

import display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{
    private Display display;

    private  static int width,height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private InputHandler inputHandler;
    private MouseInput mouseInput;
    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage img;

    private static Player player;
    private static Ball ball;
    private static Bricks[][] bricks;

    public static boolean isMovingLeft;
    public static boolean isMovingRight;

    private static boolean hasWon;
    private static boolean hasLost;
    public static boolean paused;

    private static int ballCount;

    private Menu menu;

    public  enum STATE{
        MENU,
        GAME,
        HELP
    };

    public static STATE State = STATE.MENU;

    private int startGame = 0;

    private BufferedImage livesImg = gfx.ImageLoader.loadImage("/Heart.png");

    public Game(String title, int height, int width) {

        this.title = title;
        this.height = height;
        this.width = width;

    }

    private void init(){
        this.display = new Display(this.title, this.width, this.height);
        this.img = gfx.ImageLoader.loadImage("/background.png");

        this.inputHandler = new InputHandler(this.display);
        this.mouseInput = new MouseInput(this.display);

        menu = new Menu();

        this.player = new Player(gfx.ImageLoader.loadImage("/bat2.png"),(this.width - 111) / 2, this.height - 19, 111, 19);
        this.bricks = new Bricks[11][4];
        for (int x = 0; x < bricks.length; x++) {
            for (int y = 0; y < bricks[x].length; y++) {
                int brickWidth = Game.getWidth() / 11;
                int brickHeight = (Game.getHeight() / 5) / 4;
                if (y == 0){
                    this.bricks[x][y] = new Bricks(gfx.ImageLoader.loadImage("/brick_blue.png"), x * brickWidth, y * brickHeight + 50, brickWidth, brickHeight);
                } else if (y == 1){
                    this.bricks[x][y] = new Bricks(gfx.ImageLoader.loadImage("/brick_green.png"), x * brickWidth, y * brickHeight + 50, brickWidth, brickHeight);
                } else if (y == 2) {
                    this.bricks[x][y] = new Bricks(gfx.ImageLoader.loadImage("/brick_red.png"), x * brickWidth, y * brickHeight + 50, brickWidth, brickHeight);
                } else {
                    this.bricks[x][y] = new Bricks(gfx.ImageLoader.loadImage("/brick_silver.png"), x * brickWidth, y * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
        this.ball = new Ball(this, gfx.ImageLoader.loadImage("/ball.png"),player.getBoundingBox(), 5);
        ballCount = 3;
    }

    public int getBalls(){
        return this.ballCount;
    }

    public void missedBall(){
        ballCount -= 1;
        if (ballCount == 0){
            hasLost = true;
        }
    }

    public static boolean isWon(){
        return  hasWon;
    }

    public static boolean isLost(){
        return hasLost;
    }

    public static boolean isPaused(boolean p) {return paused = p;}

    public void checkGame(){
        hasWon = true;

        for (Bricks[] bricks : Game.getBricks()){
            for (Bricks brick: bricks){
                if (!brick.isDestroyed()){
                    hasWon = false;

                }
            }
        }
    }

    private void tick(){
        if(State == STATE.GAME) {
            //update player
            player.tick();
            //update ball
            ball.tick();
        }
    }
    private  void render(){
        this.bs = display.getCanvas().getBufferStrategy();

        if(bs == null){
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }

        this.g = bs.getDrawGraphics();
        g.clearRect(0,0, this.width, this.height);
        g.drawImage(img,0,0,this.width, this.height, null);
        //Start draw
        if(State == STATE.GAME) {
            player.render(g);
            ball.render(g);

            for (Bricks[] brick : bricks) {
                for (Bricks b : brick) {
                    b.render(g);
                }
            }
            if (this.startGame == 0){
                paused = true;
                startGame++;
            }

            for (int i = 0; i < this.ballCount; i++) {
                g.drawImage(this.livesImg, 15 * i, this.height - 40, null);
            }
        }
        else if(State == STATE.MENU){
            menu.render(g);
        }
        else if(State == STATE.HELP){
            g.setColor(Color.gray);
            Font fnt = new Font("Comic Sans MS", Font.BOLD, 50);
            g.setFont(fnt);
            g.drawString("Controls",100,100);
            g.drawImage(gfx.ImageLoader.loadImage("/Controls.png"),12,120,786,120,null);
            g.setColor(Color.gray);
            Font fnt1 = new Font("Comic Sans MS", Font.BOLD, 90);
            g.setFont(fnt1);
            g.drawString("BACK",width/2 -120,500);
        }
        //End
        this.bs.show();

        this.g.dispose();



        checkGame();

        if (hasWon){
            // DRAW END GAME SCREEN
            Sound win = new Sound("res/win.wav");
            win.play();
            this.g = bs.getDrawGraphics();
            g.clearRect(0,0, this.width, this.height);
            g.drawImage(gfx.ImageLoader.loadImage("/win.png"), 0, 0, this.width, this.height, null);
            this.bs.show();
            this.g.dispose();

            //Stop running
            running = false;

        }

        if (hasLost){
            // DRAW END GAME SCREEN
            Sound lose = new Sound("res/lose.wav");
            lose.play();
            this.g = bs.getDrawGraphics();
            g.clearRect(0,0, this.width, this.height);
            g.drawImage(gfx.ImageLoader.loadImage("/GameOver.png"), 0, 0, this.width, this.height, null);
            this.bs.show();
            this.g.dispose();

            //Stop running
            running = false;
        }
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static Bricks[][] getBricks(){
        return bricks;
    }

    @Override
    public void run() {
        this.init();

        int fps = 60;
        double timePerTick = 1_000_000_000.0 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){

            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                if(!paused) {
                    tick();
                    render();
                }
                ticks++;
                delta--;
            }
            if(timer >= 1_000_000_000){

                timer = 0;
                ticks = 0;
            }
        }

        stop();
    }
    public synchronized void start(){
        if(running){
            return;
        }

        running = true;
        this.thread = new Thread(this);

        this.thread.start();
    }
    public synchronized void stop() {
        if(!running){
            return;
        }
        running = false;
        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}


