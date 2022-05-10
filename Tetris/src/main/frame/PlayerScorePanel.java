package frame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PlayerScorePanel extends JPanel {

    private static final int HEIGHT = 100;

    private static final String TITLE_STRING = "Score";
    private static final String FONT_NAME = "CookieRunOTF";
    private static final int TITlE_FONT_SIZE = 20;
    private static final int SCORE_FONT_SIZE = 40;
    private static final int SCORE_PADDING = 5;

    private final JLabel scoreLabel;

    public PlayerScorePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new TitledBorder(new LineBorder(Color.BLACK), TITLE_STRING,
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font(FONT_NAME, Font.PLAIN, TITlE_FONT_SIZE)));

        scoreLabel = new JLabel("0");
        initScoreLabel();
        add(scoreLabel);
        add(Box.createRigidArea(new Dimension(0, SCORE_PADDING)));
    }

    private void initScoreLabel() {
        scoreLabel.setFont(new Font(FONT_NAME, Font.PLAIN, SCORE_FONT_SIZE));
        scoreLabel.setAlignmentX(CENTER_ALIGNMENT);
        setMinimumSize(new Dimension(PlayerStatusPanel.WIDTH, HEIGHT));
        setPreferredSize(new Dimension(PlayerStatusPanel.WIDTH, HEIGHT));
        setMaximumSize(new Dimension(PlayerStatusPanel.WIDTH, HEIGHT));
    }

    public void setScore(int score) {
        scoreLabel.setText(Integer.toString(score));
    }
}
