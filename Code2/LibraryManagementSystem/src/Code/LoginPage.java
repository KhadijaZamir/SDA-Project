/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Code;

/**
 *
 * @author khadi
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

class LoginPage extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerRedirectButton;
    private JLabel messageLabel;
    private HashMap<String, User> userDatabase;

    public LoginPage(HashMap<String, User> userDatabase) {
        this.userDatabase = userDatabase;

        setTitle("Library - Login");
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 100, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 150, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 100, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(80, 150, 100, 30);
        loginButton.addActionListener(this);
        add(loginButton);

        registerRedirectButton = new JButton("Go to Register");
        registerRedirectButton.setBounds(200, 150, 130, 30);
        registerRedirectButton.addActionListener(this);
        add(registerRedirectButton);

        messageLabel = new JLabel("");
        messageLabel.setBounds(50, 200, 300, 25);
        add(messageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = usernameField.getText();
            String pass = String.valueOf(passwordField.getPassword());

            if (userDatabase.containsKey(user)) {
                User u = userDatabase.get(user);
                if (u.getPassword().equals(pass)) {
                    JOptionPane.showMessageDialog(this, "Login successful! Role: " + u.getRole());
                    dispose();
                    // Open main dashboard according to role if needed
                } else {
                    messageLabel.setText("Wrong password!");
                }
            } else {
                messageLabel.setText("User not found!");
            }

        } else if (e.getSource() == registerRedirectButton) {
            dispose();
            new RegisterPage(userDatabase);
        }
    }
}
