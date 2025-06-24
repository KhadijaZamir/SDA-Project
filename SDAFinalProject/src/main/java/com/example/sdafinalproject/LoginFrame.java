/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdafinalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private JTextField usernameField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    
    public LoginFrame() {
        setTitle("Library Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Title
        panel.add(new JLabel("Library Management System", SwingConstants.CENTER));
        
        // Username
        JPanel userPanel = new JPanel();
        userPanel.add(new JLabel("Username:"));
        userPanel.add(usernameField);
        panel.add(userPanel);
        
        // Password
        JPanel passPanel = new JPanel();
        passPanel.add(new JLabel("Password:"));
        passPanel.add(passwordField);
        panel.add(passPanel);
        
        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton("Login", this::login));
        buttonPanel.add(createButton("Register", e -> openRegistration()));
        panel.add(buttonPanel);
        
        add(panel);
    }
    
    private JButton createButton(String text, java.awt.event.ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        return button;
    }
    
    private void login(ActionEvent e) {
    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());
    
    if (username.isEmpty() || password.isEmpty()) {
        showMessage("Please enter both fields", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (UserDatabase.validateUser(username, password)) {
        showMessage("Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Close login window
        new DashboardFrame().setVisible(true); // Open dashboard
    } else {
        showMessage("Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void openRegistration() {
        new RegistrationForm(this).setVisible(true);
        setVisible(false);
    }
    
    private void showMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
}