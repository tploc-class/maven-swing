package com.example.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main Swing application frame
 */
public class MainFrame extends JFrame {
    
    private JPanel mainPanel;
    private JTextField nameTextField;
    private JButton submitButton;
    private JButton showListButton;
    private JLabel resultLabel;
    
    public MainFrame() {
        setTitle("Swing Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
        
        setVisible(true);
    }
    
    private void initComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Name label
        JLabel nameLabel = new JLabel("Enter your name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(nameLabel, gbc);
        
        // Name text field
        nameTextField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(nameTextField, gbc);
        
        // Submit button
        submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(submitButton, gbc);
        
        // Show List button
        showListButton = new JButton("Show List");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(showListButton, gbc);
        
        // Result label
        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setForeground(new Color(0, 100, 0));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(resultLabel, gbc);
        
        // Add action listener to submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText().trim();
                if (!name.isEmpty()) {
                    resultLabel.setText("Hello, " + name + "!");
                    resultLabel.setForeground(new Color(0, 100, 0));
                } else {
                    resultLabel.setText("Please enter your name.");
                    resultLabel.setForeground(Color.RED);
                }
            }
        });
        
        // Add action listener to show list button
        showListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListFrame();
            }
        });
        
        add(mainPanel);
    }
    
    public static void main(String[] args) {
        // Use SwingUtilities to ensure GUI creation happens on EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
