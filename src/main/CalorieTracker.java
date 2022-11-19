package main;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JTextField foodfield = new JTextField();
    JTextField dateField = new JTextField();


    //JTables
    JTable loggingTable;
    DefaultTableModel loggingTableModel;
    DefaultTableCellRenderer loggingCellRenderer;
    String[] logRowComponents;

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
        displayLeftPanel();

        //displayButtons();

        topPanel.setVisible(true);
        mainFrame.add(topPanel, borderLayout.NORTH);
        mainPanel.setVisible(true);
        displayLogTable();
        displayButtons();
        mainFrame.add(mainPanel, borderLayout.CENTER);
    }

    private void displayLeftPanel() {
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(new Color(142, 239, 138));
        leftPanel.setPreferredSize(new Dimension(150, 50));

        // create labels
        JLabel dateLabel = new JLabel("Date(D/M/Y)");
        JLabel foodLabel = new JLabel("Food");

        // add labels
        leftPanel.add(Box.createRigidArea(new Dimension(15, 10)));
        leftPanel.add(dateLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(15, 10)));
        leftPanel.add(foodLabel);
        //-----------------------------------------------------------------

        displayTextFields();
        leftPanel.setVisible(true);
        mainFrame.add(leftPanel, borderLayout.WEST);
    }

    private void displayTextFields() {
        JPanel helperPanel1 = new JPanel();

        BoxLayout helperLayout = new BoxLayout(helperPanel1, BoxLayout.Y_AXIS);
        helperPanel1.setBackground(new Color(142, 239, 138));
        helperPanel1.setLayout(helperLayout);
        helperPanel1.setPreferredSize(new Dimension(125, 50));

        dateField.setBorder(BorderFactory.createLoweredBevelBorder());
        foodfield.setBorder(BorderFactory.createLoweredBevelBorder());

        helperPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
        helperPanel1.add(dateField);
        helperPanel1.add(Box.createRigidArea(new Dimension(0, 10)));
        helperPanel1.add(foodfield);
        helperPanel1.add(Box.createRigidArea(new Dimension(0, 800)));


        //-----------------------------------------------------------------
        helperPanel1.setVisible(true);
        mainPanel.add(helperPanel1, new BorderLayout().WEST);
    }

    private void displayButtons() {
        JPanel helperPanel2 = new JPanel();

        FlowLayout helperLayout = new FlowLayout(FlowLayout.LEADING);
        helperPanel2.setBackground(new Color(238, 238, 238));
        helperPanel2.setLayout(helperLayout);
        helperPanel2.setPreferredSize(new Dimension(100, 335));
        helperPanel2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        helperPanel2.add(addButton);
        helperPanel2.add(modifyButton);
        helperPanel2.add(deleteButton);
        performButtonAction();

        //-----------------------------------------------------------------
        helperPanel2.setVisible(true);
        mainPanel.add(helperPanel2, new BorderLayout().SOUTH);
    }

    private void performButtonAction() {
        performAddButtonTask();
        performModifyButtonTask();
        performDeleteButtonTask();
    }

    private void performDeleteButtonTask() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!loggingTable.getSelectionModel().isSelectionEmpty()) {
                    if (e.getSource() == deleteButton) {

                        int selectedRowIndex = loggingTable.getSelectedRow();
                        int confirmation = JOptionPane.showConfirmDialog(mainPanel,
                                "Are you sure you want to delete this  entry?",
                                "Delete Selected", JOptionPane.YES_NO_OPTION);
                        if (confirmation == JOptionPane.YES_OPTION) {
                            loggingTableModel.removeRow(loggingTable.getSelectedRow());
                        }
                    }
                }
            }
        });

    }

    private void performModifyButtonTask() {
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == modifyButton) {
                    int selectedRowIndex = loggingTable.getSelectedRow();

                    if (!loggingTable.getSelectionModel().isSelectionEmpty()) {
                        String newDate = JOptionPane.showInputDialog(mainPanel,
                                "Enter new Date");
                        loggingTable.setValueAt(newDate, selectedRowIndex, 0);

                        String newFood = JOptionPane.showInputDialog(mainPanel,
                                "Enter new food item");
                        loggingTable.setValueAt(newFood, selectedRowIndex, 1);

                    } else {
                        JOptionPane.showMessageDialog(mainPanel,
                                "You must select a row to perform this operation",
                                "Invalid Row Selection", JOptionPane.DEFAULT_OPTION);
                    }

                }
            }
        });
    }

    private void performAddButtonTask() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addButton) {

                    String date;
                    String food;

                    date = dateField.getText();
                    food = foodfield.getText();

                    logRowComponents = new String[]{date, food};
                    loggingTableModel.addRow(logRowComponents);

                    dateField.setText("");
                    foodfield.setText("");
                }
            }
        });
    }





    //MODIFIES: this
    //EFFECTS: creates a call log which is displayed upon button click
    private void displayLogTable() {
        loggingTable = new JTable();
        loggingTableModel = new DefaultTableModel();
        loggingTable.setModel(loggingTableModel);

        loggingTableModel.addColumn("Date");
        loggingTableModel.addColumn("Food");
//      loggingTable.getColumnModel().getColumn(0).setPreferredWidth(1);

        loggingTable.setRowSelectionAllowed(true);
        loggingTable.setCellSelectionEnabled(true);

        JScrollPane scrollPane = new JScrollPane(loggingTable);
        loggingTable.setBackground(new Color(26, 175, 119, 255));
        loggingTable.setFillsViewportHeight(true);
        scrollPane.setVisible(true);
        mainPanel.add(scrollPane);

    }

}
