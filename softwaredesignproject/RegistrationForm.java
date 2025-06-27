/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package softwaredesignproject;

/**
 *
 * @author Gule Narjis
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegistrationForm extends JFrame {
    private final JTextField usernameField = new JTextField(15);
    private final JTextField emailField = new JTextField(15);
    private final JPasswordField passwordField = new JPasswordField(15);
    private final JPasswordField confirmField = new JPasswordField(15);
    private final LoginFrame loginFrame;
    
    public RegistrationForm(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
        
        setTitle("User Registration");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Title
        panel.add(new JLabel("Create New Account", SwingConstants.CENTER));
        
        // Username
        panel.add(createFieldPanel("Username:", usernameField));
        
        // Email
        panel.add(createFieldPanel("Email:", emailField));
        
        // Password
        panel.add(createFieldPanel("Password:", passwordField));
        
        // Confirm Password
        panel.add(createFieldPanel("Confirm:", confirmField));
        
        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton("Register", this::register));
        buttonPanel.add(createButton("Back", e -> goBack()));
        panel.add(buttonPanel);
        
        add(panel);
    }
    
    private JPanel createFieldPanel(String label, JComponent field) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(label));
        panel.add(field);
        return panel;
    }
    
    private JButton createButton(String text, java.awt.event.ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        return button;
    }
    
    private void register(ActionEvent e) {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirm = new String(confirmField.getPassword());
        
        // Validation
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showMessage("All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!password.equals(confirm)) {
            showMessage("Passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (password.length() < 4) {
            showMessage("Password too short", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!email.contains("@")) {
            showMessage("Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (UserDatabase.addUser(username, password, email)) {
            showMessage("Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            goBack();
        } else {
            showMessage("Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void goBack() {
        dispose();
        loginFrame.setVisible(true);
    }
    
    private void showMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
}