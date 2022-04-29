package frame;

import javax.swing.*;

public class TetrisFrame extends JFrame {
    private final static int WIDTH = 1280;
    private final static int HEIGHT = 720;

    public TetrisFrame() {
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
