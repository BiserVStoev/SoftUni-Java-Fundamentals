package game;

import display.Display;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInput implements MouseListener {
    public MouseInput(Display display){
        display.getCanvas().addMouseListener(this);
    }
    private Game game;
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        /*
        * public Rectangle newGame = new Rectangle(Game.getWidth()/2 -70,150,180,100);
           public Rectangle helpGame = new Rectangle(Game.getWidth()/2-70,300,180,100);
            public Rectangle quitGame = new Rectangle(Game.getWidth()/2 -70,450,180,100);
        *
        *
        * */
        int mx = e.getX();
        int my = e.getY();
        if(game.State == Game.STATE.MENU) {
            //Play Button
            if (mx >= Game.getWidth() / 2 - 70 && mx <= Game.getWidth() / 2 + 110) {
                if (my >= 150 && my <= 250) {
                    Game.State = Game.STATE.GAME;
                }
            }
            // Help Button
            if (mx >= Game.getWidth() / 2 - 70 && mx <= Game.getWidth() / 2 + 110) {
                if (my >= 300 && my <= 400) {
                    Game.State = Game.STATE.HELP;

                }
            }
            // Quit Button
            if (mx >= Game.getWidth() / 2 - 70 && mx <= Game.getWidth() / 2 + 110) {
                if (my >= 450 && my <= 550) {
                    System.exit(1);
                }
            }
        }else if(game.State == Game.STATE.HELP) {
            if (mx >= Game.getWidth() / 2 - 120 && mx <= Game.getWidth() / 2 + 100) {
                if (my >= 430 && my <= 500) {
                    Game.State = Game.STATE.MENU;

                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
