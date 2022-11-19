package src;

import javax.swing.*;
import java.awt.*;

public class WelcomeGUI {
    static final int FRAME_WIDTH = 1000;
    static final int FRAME_HEIGHT = 900;
    JFrame mainFrame = new JFrame();
    BorderLayout borderLayout = new BorderLayout();


    public WelcomeGUI() {
        mainFrame.setLayout(borderLayout);
        mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel();
        title.setText("Caloriemeter");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Verdana", Font. BOLD, 25));

        JLabel description = new JLabel();
        description.setText("Are you looking to loose or gain weight? Are you tired of surfing youtube videos to find the"
                + "right diet plan for you? Are you looking for free diet plans build according to your needs and body?"
                + "\n If you answered yes to one or more of these questions then wait no more, because you have come at"
                + "the right place!");
        description.setForeground(Color.BLACK);
        description.setFont(new Font("Verdana", Font. BOLD, 25));

        mainFrame.add(Box.createRigidArea(new Dimension(70, 50)));
        mainFrame.add(title);
        mainFrame.add(description);

    }

    public static void main(String[] args) {
        WelcomeGUI gui = new WelcomeGUI();
        gui.mainFrame.setVisible(true);
    }
}