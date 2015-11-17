package game;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Bricks {
    public Rectangle brickHitBox;

    private BufferedImage brick;

    private boolean isDestroyed = false;

    public Bricks(BufferedImage img, int x, int y, int width, int height){
        this.brick = img;

        this.brickHitBox = new Rectangle(x, y, width, height);
    }

    public boolean collidesWith(Rectangle object){
        return (isDestroyed) ? false : brickHitBox.intersects(object);
    }

    public void destroy(){
        isDestroyed = true;
    }

    public boolean isDestroyed(){
        return isDestroyed;
    }

    public void render(Graphics g){
        if (!isDestroyed){
            g.drawImage(this.brick, this.brickHitBox.x, this.brickHitBox.y, null);
        }
    }
}
