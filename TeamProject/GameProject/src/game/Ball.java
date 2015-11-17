package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ball {
    public Rectangle boundingBox;
    private BufferedImage ballImg;
    private int ballWidth, ballHeight, speed, XPosition, YPosition;
    private Rectangle playerBoundingBox;
    private boolean[] movement;
    private Game instance;

    private Sound brickBreak = new Sound("res/Break-Sound.wav");
    private Sound lostLife = new Sound("res/LifeLost.wav");

    public Ball(Game inst, BufferedImage img, Rectangle playerBoundingBox, int speed){
        this.instance = inst;
        this.ballImg = img;
        this.ballWidth = img.getWidth();
        this.ballHeight = img.getHeight();
        this.playerBoundingBox = playerBoundingBox;
        this.speed = speed;
        //Movement is an array holding information whether ball is moving right and downwards
        this.movement = new boolean[2];
        this.movement[0] = true; this.movement[1] = true;
        this.XPosition = instance.getWidth() / 2;
        this.YPosition = instance.getHeight() - 48;
        this.boundingBox = new Rectangle(this.XPosition,this.YPosition, this.ballWidth, this.ballHeight);
    }

    private void moveLeft() {
        this.XPosition -= this.speed;
    }
    private void moveRight() {
        this.XPosition += this.speed;
    }
    private void moveUp() {
        this.YPosition -= this.speed;
    }
    private void moveDown() {
        this.YPosition += this.speed;
    }

    private void move() {
        //Deciding where to go to
        if(this.movement[0]) {
            moveRight();
        } else {
            moveLeft();
        }
        if(this.movement[1]) {
            moveDown();
        } else {
            moveUp();
        }

        //Checking boundaries of the game
        if(this.XPosition + this.ballWidth > instance.getWidth()) {
            this.movement[0] = false;
        } else if(XPosition <= 0) {
            this.movement[0] = true;
        } else if(YPosition <= 0) {
            this.movement[1] = true;
        } else if(YPosition + ballHeight >= instance.getHeight()) {
            instance.missedBall();
            if (instance.getBalls() > 0){
                this.lostLife.play();
            }
            this.XPosition = instance.getWidth() / 2;
            this.YPosition = instance.getHeight() - 43;
            this.movement[1] = false;
            Player.setPlayerX((instance.getWidth() - 111) / 2);
            Player.setPlayerY(instance.getHeight() - 19);
            instance.isPaused(true);
        }

        if (this.boundingBox.intersects(this.playerBoundingBox)){
            Rectangle leftHalfOfPlayer = new Rectangle((int)this.playerBoundingBox.getWidth() / 2, (int)this.playerBoundingBox.getHeight(),
                    this.playerBoundingBox.x, this.playerBoundingBox.y);
            this.movement[0] = !this.boundingBox.intersects(leftHalfOfPlayer);
            this.movement[1] = false;
        } else {
            // Check if ball collides with brick;
            for (Bricks[] bricks : instance.getBricks()){
                for (Bricks brick: bricks){
                    if (brick.collidesWith(new Rectangle(this.XPosition , this.YPosition , this.ballWidth , this.ballHeight))){
                        Rectangle iRect = brick.brickHitBox.intersection(this.boundingBox);
                        brick.destroy();
                        //Sound brickBreak = new Sound("res/Break-Sound.wav");
                        this.brickBreak.play();
                        // make logic
                        this.movement[1] = true;
                        if ((this.boundingBox.x+(this.boundingBox.width/2))<(iRect.x+(iRect.width/2))) {
                            this.movement[0] = false;
                        }
                        if ((this.boundingBox.x+(this.boundingBox.width/2))>(iRect.x+(iRect.width/2))) {
                            this.movement[0] = true;
                        }
                        if ((this.boundingBox.y+(this.boundingBox.height/2))<(iRect.y+(iRect.height/2))) {
                            this.movement[1] = false;
                        }
                    }
                }
            }

        }

    }

    public void setXPosition(int XPosition) {
        this.XPosition = XPosition;
    }

    public void setYPosition(int YPosition) {
        this.YPosition = YPosition;
    }

    public void tick(){
        this.move();
        this.boundingBox.setBounds(this.XPosition,this.YPosition,this.ballWidth,this.ballHeight);
    }

    public void render(Graphics g){
        g.drawImage(this.ballImg,this.XPosition,this.YPosition,this.ballWidth, this.ballHeight, null);
    }
}
