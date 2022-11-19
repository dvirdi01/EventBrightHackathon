package main;

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
        JLabel message = new JLabel();
        message.setText("Welcome to our GUI");
        message.setForeground(Color.BLACK);
        message.setFont(new Font("Verdana", Font. BOLD, 25));

        mainFrame.add(Box.createRigidArea(new Dimension(70, 50)));
        mainFrame.add(message);

    }

    public static void main(String[] args) {
        WelcomeGUI gui = new WelcomeGUI();
        gui.mainFrame.setVisible(true);
    }
}
