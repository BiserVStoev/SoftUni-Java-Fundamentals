package game;

import display.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class InputHandler implements KeyListener {

    public InputHandler(Display display){
        display.getCanvas().addKeyListener(this);
    }
    private Game game;
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(game.State == Game.STATE.GAME) {
            if (e.getKeyCode() == KeyEvent.VK_P) {
                if (!Game.paused) {
                    Game.isPaused(true);
                } else {
                    Game.isPaused(false);
                }
            } else if (e.getKeyCode() == KeyEvent.VK_P || e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (Game.paused) {
                    Game.isPaused(false);
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                System.exit(0);
            }

            if (Game.isWon() || Game.isLost()) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) System.exit(0);
            } else if (keyCode == KeyEvent.VK_LEFT) {
                Game.isMovingLeft = true;
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                Game.isMovingRight = true;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT){
            Game.isMovingLeft = false;
        }else if (keyCode == KeyEvent.VK_RIGHT){
            Game.isMovingRight = false;
        }
    }
}