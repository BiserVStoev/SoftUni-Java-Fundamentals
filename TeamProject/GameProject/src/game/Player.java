package game;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player {
    private int playerWidth;
    private int playerHeight;
    private static int x, y;

    private Rectangle boundingBox;

    private BufferedImage pad;


    //Constructor
    public Player(BufferedImage img, int x, int y, int width, int height){
        this.playerWidth = width;
        this.playerHeight = height;

        this.x = x;
        this.y = y;

        this.pad = img;

        this.boundingBox = new Rectangle(this.playerWidth, this.playerHeight,x,y);
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public static void setPlayerX(int pX) {
        x = pX;
    }

    public static void setPlayerY(int pY) {
        y = pY;
    }

    //update
    public void tick(){

        //set box bounds
        this.boundingBox.setBounds(this.x, this.y, this.playerWidth, this.playerHeight);

        //move pad
        if (Game.isMovingLeft){
            this.x += -10;
            if (this.x < 0) this.x = 0;
        }else if (Game.isMovingRight){
            this.x += 10;
            if (this.x >  Game.getWidth() - this.playerWidth)
                this.x = Game.getWidth() - this.playerWidth;
        }


    }

    //draw
    public void render(Graphics g){
        g.drawImage(this.pad, this.x, this.y, null);
    }
}
