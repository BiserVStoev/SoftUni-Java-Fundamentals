package display;


import javax.swing.*;
import java.awt.*;

public class Display extends Canvas {
    private JFrame frame;

    private Canvas canvas;

    private String title;
    private int width,height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }


    private void createDisplay() {

        this.frame = new JFrame(this.title);
        this.frame.setSize(this.width,this.height);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setFocusable(true);

        this.canvas = new Canvas();
        this.canvas.setPreferredSize(new Dimension(width,height));
        this.canvas.setMaximumSize(new Dimension(width,height));
        this.canvas.setMinimumSize(new Dimension(width,height));

        this.frame.add(canvas);
        this.frame.pack();
    }

    public Canvas getCanvas() {return this.canvas; }
}
