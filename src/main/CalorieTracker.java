package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CalorieTracker {

    static final int FRAME_WIDTH = 1000;
    static final int FRAME_HEIGHT = 900;
    JFrame mainFrame = new JFrame();
    BorderLayout borderLayout = new BorderLayout();

    //Panels
    JPanel mainPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    //buttons
    JButton addButton = new JButton("Add");
    JButton modifyButton = new JButton("Modify");
    JButton deleteButton = new JButton("Delete");

    //TextFields
    JTextField itemName = new JTextField();

    public CalorieTracker() {
        setUpFrame();
        setUpPanel();
    }

    private void setUpFrame() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Calorie Tracker");
        mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(borderLayout);
        mainFrame.getContentPane().setBackground(new Color(255, 255, 255, 255));
        mainFrame.setResizable(true);
        mainFrame.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                WelcomeGUI welcomeGUI = new WelcomeGUI();



            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    private void setUpPanel() {
        topPanel = new JPanel();
        topPanel.setBackground(new Color(6, 54, 2));
        topPanel.setPreferredSize(new Dimension(50, 100));

        JLabel topPanelLabel = new JLabel();
        topPanelLabel.setText("Calories Tracker");
        topPanelLabel.setForeground(Color.WHITE);
        topPanelLabel.setFont(new Font("Verdana", Font. BOLD, 25));

        topPanel.add(Box.createRigidArea(new Dimension(70, 50)));
        topPanel.add(topPanelLabel);

        BorderLayout centerPanelLayout = new BorderLayout();
        mainPanel.setLayout(centerPanelLayout);
        JLabel mainPanelLabel = new JLabel();
        mainPanelLabel.setText("Include everything else here");
        mainPanelLabel.setForeground(Color.BLACK);
        mainPanelLabel.setFont(new Font("Verdana", Font. BOLD, 25));
        mainPanel.add(mainPanelLabel);

        topPanel.setVisible(true);
        mainFrame.add(topPanel, borderLayout.NORTH);
        mainPanel.setVisible(true);
        mainFrame.add(mainPanel, borderLayout.CENTER);
    }

}
