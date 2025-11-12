package com.example.app;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Frame with a list on the left and text fields on the right
 */
public class ListFrame extends JFrame {
    
    private JList<String> itemList;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label1;
    private JLabel label2;
    
    public ListFrame() {
        setTitle("List Frame");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponents();
        
        setVisible(true);
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        
        // Create the main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Left panel with list
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Items"));
        leftPanel.setPreferredSize(new Dimension(200, 0));
        
        // Sample data for the list
        String[] listData = {
            "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
            "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"
        };
        
        itemList = new JList<>(listData);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemList.setSelectedIndex(0);
        
        JScrollPane listScrollPane = new JScrollPane(itemList);
        leftPanel.add(listScrollPane, BorderLayout.CENTER);
        
        // Right panel with text fields and labels
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        // First label and text field
        label1 = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        rightPanel.add(label1, gbc);
        
        textField1 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rightPanel.add(textField1, gbc);
        
        // Second label and text field
        label2 = new JLabel("Description:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        rightPanel.add(label2, gbc);
        
        textField2 = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rightPanel.add(textField2, gbc);
        
        // Add list selection listener
        itemList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedItem = itemList.getSelectedValue();
                    if (selectedItem != null) {
                        textField1.setText(selectedItem);
                        textField2.setText("Description for " + selectedItem);
                    }
                }
            }
        });
        
        // Initialize with first item selected
        if (listData.length > 0) {
            textField1.setText(listData[0]);
            textField2.setText("Description for " + listData[0]);
        }
        
        // Add panels to main panel
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);
        
        add(mainPanel);
    }
}