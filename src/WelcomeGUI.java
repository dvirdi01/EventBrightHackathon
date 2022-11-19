package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeGUI extends JFrame {
    static final int FRAME_WIDTH = 1000;
    static final int FRAME_HEIGHT = 900;
    JFrame mainFrame = new JFrame();
    BorderLayout borderLayout = new BorderLayout();

    private CardLayout card;
    private JPanel page1;
    private JPanel page2;
    private JPanel page3;
    private JPanel cPanel;
    private JPanel btnPanel;
    private JButton nextBtn;
    private JButton weightLossBtn;
    private JButton weightGainBtn;
    private JTextField name;
    private JTextField age;
    private JTextField weight;
    private JTextField height;
    private JTextField gender;
    private JTextField calorieGoal;


    public WelcomeGUI() {
//        mainFrame.setLayout(borderLayout);
//        mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
//        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel();
        title.setText("Caloriemeter");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Verdana", Font. BOLD, 25));

        JLabel description = new JLabel();
        description.setText("<html> Are you looking to loose or gain weight? <br/> Are you tired of surfing youtube videos to find the"
                + " right diet plan for you? <br/> Are you looking for free diet plan build according to your needs and body?"
                + " <br/> Then wait no more, because you have come at the right place! </html");
        description.setForeground(Color.BLACK);
        description.setFont(new Font("Verdana", Font. BOLD, 25));

        initializations();

        JLabel page1Label = new JLabel("Welcome!");
        JLabel page2Label = new JLabel("Information");
        JLabel page3Label = new JLabel(" Set Your Goal");

        btnPanel.add(nextBtn);

        page1.add(page1Label);
        page1.add(title);
        page1.add(description);
        page2.add(page2Label);
        page3.add(page3Label);
        page3GUI();
        page2GUI();

        cPanel.add(page1, "1");
        cPanel.add(page2, "2");
        cPanel.add(page3, "3");

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.next(cPanel);
            }
        });

        getContentPane().add(cPanel, BorderLayout.NORTH);

// using to get the content pane
        getContentPane().add(btnPanel, BorderLayout.SOUTH);

    }

    private void initializations() {
        cPanel = new JPanel();
        page1 = new JPanel();
        page2 = new JPanel();
        page3 = new JPanel();
        btnPanel = new JPanel();
        card = new CardLayout();
        cPanel.setLayout(card);
        nextBtn = new JButton("Next");
    }

    private void page3GUI() {
        weightLossBtn = new JButton("Weight Loss");
        weightGainBtn = new JButton("Weight Gain");
        page3.add(weightLossBtn);
        page3.add(weightGainBtn);
    }

    private void page2GUI() {
        name = new JTextField("Enter name...", 20);
        weight = new JTextField("Enter age...", 20);
        height = new JTextField("Enter height...", 20);
        age = new JTextField("Enter age...", 20);
        calorieGoal = new JTextField("Enter calorie goal...", 20);


        page2.add(new JLabel("Name: "));
        page2.add(name);

        page2.add(new JLabel("Weight: "));
        page2.add(weight);

        page2.add(new JLabel("Height: "));
        page2.add(height);

        page2.add(new JLabel("Age: "));
        page2.add(age);

        page2.add(new JLabel("Calorie goal: "));
        page2.add(calorieGoal);

        JButton enterBtn = new JButton("Enter");
        page2.add(enterBtn);
    }

    public static void main(String[] args) {
        WelcomeGUI gui = new WelcomeGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }

}