package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CalorieTracker {

    static final int FRAME_WIDTH = 800;
    static final int FRAME_HEIGHT = 600;
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
        mainFrame.setTitle("Telephone Hut");
        mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(borderLayout);
        mainFrame.getContentPane().setBackground(new Color(203, 206, 227, 255));
        mainFrame.setResizable(true);
        mainFrame.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {

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

    }

}
