package game;

import java.awt.*;

public class Menu {

    public Rectangle newGame = new Rectangle(Game.getWidth()/2 -70,150,180,100);
    public Rectangle helpGame = new Rectangle(Game.getWidth()/2-70,300,180,100);
    public Rectangle quitGame = new Rectangle(Game.getWidth()/2 -70,450,180,100);

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("forte", Font.BOLD, 100);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("Brick Smasher", Game.getWidth() / 2 - 330, 100);

        Font fnt1 = new Font("Gabriola", Font.BOLD, 100);
        g.setColor(Color.CYAN);
        g.setFont(fnt1);
        g.drawString("Play", newGame.x,newGame.y+80);
        g.drawString("Help", helpGame.x,helpGame.y+80);
        g.drawString("Quit", quitGame.x,quitGame.y+80);

    }
}
