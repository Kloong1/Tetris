package frame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PlayerComboPanel extends JPanel {
    private static final int HEIGHT = 100;

    private static final String TITLE_STRING = "Combo";
    private static final String FONT_NAME = "CookieRunOTF";
    private static final int TITlE_FONT_SIZE = 20;
    private static final int COMBO_FONT_SIZE = 40;
    private static final int COMBO_PADDING = 5;

    private JLabel comboLabel;

    public PlayerComboPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new TitledBorder(new LineBorder(Color.BLACK), TITLE_STRING,
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font(FONT_NAME, Font.PLAIN, TITlE_FONT_SIZE)));
        initScoreLabel();
        add(comboLabel);
        add(Box.createRigidArea(new Dimension(0, COMBO_PADDING)));
    }

    private void initScoreLabel() {
        comboLabel = new JLabel("0 Combo");
        comboLabel.setFont(new Font(FONT_NAME, Font.PLAIN, COMBO_FONT_SIZE));
        comboLabel.setAlignmentX(CENTER_ALIGNMENT);
        setMinimumSize(new Dimension(PlayerStatusPanel.WIDTH, HEIGHT));
        setPreferredSize(new Dimension(PlayerStatusPanel.WIDTH, HEIGHT));
        setMaximumSize(new Dimension(PlayerStatusPanel.WIDTH, HEIGHT));
    }

    public void setCombo(int combo) {
        comboLabel.setText(Integer.toString(combo) + " Combo");
    }
}
