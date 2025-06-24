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

class RegisterPage extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JButton registerButton, loginRedirectButton;
    private JLabel messageLabel;
    private HashMap<String, User> userDatabase;

    public RegisterPage(HashMap<String, User> userDatabase) {
        this.userDatabase = userDatabase;

        setTitle("Library - Register");
        setLayout(null);
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("New Username:");
        userLabel.setBounds(50, 40, 120, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(180, 40, 150, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("New Password:");
        passLabel.setBounds(50, 80, 120, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 80, 150, 25);
        add(passwordField);

        JLabel roleLabel = new JLabel("Select Role:");
        roleLabel.setBounds(50, 120, 120, 25);
        add(roleLabel);

        String[] roles = {"Student", "Employee"};
        roleComboBox = new JComboBox<>(roles);
        roleComboBox.setBounds(180, 120, 150, 25);
        add(roleComboBox);

        registerButton = new JButton("Register");
        registerButton.setBounds(80, 180, 100, 30);
        registerButton.addActionListener(this);
        add(registerButton);

        loginRedirectButton = new JButton("Go to Login");
        loginRedirectButton.setBounds(200, 180, 130, 30);
        loginRedirectButton.addActionListener(this);
        add(loginRedirectButton);

        messageLabel = new JLabel("");
        messageLabel.setBounds(50, 230, 300, 25);
        add(messageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String user = usernameField.getText();
            String pass = String.valueOf(passwordField.getPassword());
            String role = (String) roleComboBox.getSelectedItem();

            if (user.isEmpty() || pass.isEmpty()) {
                messageLabel.setText("Please fill all fields.");
            } else if (userDatabase.containsKey(user)) {
                messageLabel.setText("User already exists!");
            } else {
                userDatabase.put(user, new User(user, pass, role));
                messageLabel.setText("Registered successfully!");
            }

        } else if (e.getSource() == loginRedirectButton) {
            dispose();
            new LoginPage(userDatabase);
        }
    }
}

