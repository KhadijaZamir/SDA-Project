package softwaredesignproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;

public class ManageMember extends JFrame {

    private final HashMap<String, String> members = new HashMap<>();
    private JPanel contentPanel;

    public ManageMember() {
        setTitle("Manage Members");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(contentPanel);

        showLoginForm();
    }

    private void showLoginForm() {
        JPanel loginPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        loginPanel.add(new JLabel("Admin Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Admin Password:"));
        loginPanel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(this, loginPanel, "Admin Login",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String user = usernameField.getText().trim();
            String pass = new String(passwordField.getPassword()).trim();

            if (user.equals("admin") && pass.equals("admin123")) {
                showMemberPanel();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid admin credentials", "Access Denied", JOptionPane.ERROR_MESSAGE);
                dispose();
            }
        } else {
            dispose();
        }
    }

    private void showMemberPanel() {
        contentPanel.removeAll();

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addBtn = new JButton("Add Member");
        JButton removeBtn = new JButton("Remove Member");
        JButton viewBtn = new JButton("View Members");

        addBtn.addActionListener(e -> addMember());
        removeBtn.addActionListener(e -> removeMember());
        viewBtn.addActionListener(e -> viewMembers());

        buttonPanel.add(addBtn);
        buttonPanel.add(removeBtn);
        buttonPanel.add(viewBtn);

        contentPanel.add(buttonPanel, BorderLayout.NORTH);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void addMember() {
        JTextField username = new JTextField();
        JTextField password = new JTextField();

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.add(new JLabel("Username:"));
        panel.add(username);
        panel.add(new JLabel("Password:"));
        panel.add(password);

        int result = JOptionPane.showConfirmDialog(this, panel, "Add New Member",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String user = username.getText().trim();
            String pass = password.getText().trim();

            if (!user.isEmpty() && !pass.isEmpty()) {
                if (members.containsKey(user)) {
                    JOptionPane.showMessageDialog(this, "Member already exists", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    members.put(user, pass);
                    JOptionPane.showMessageDialog(this, "Member added successfully");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Fields cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void removeMember() {
        String user = JOptionPane.showInputDialog(this, "Enter username to remove:");
        if (user != null && members.containsKey(user)) {
            members.remove(user);
            JOptionPane.showMessageDialog(this, "Member removed successfully");
        } else {
            JOptionPane.showMessageDialog(this, "Member not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewMembers() {
        if (members.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No members to show", "Members", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] columns = {"Username", "Password"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (String username : members.keySet()) {
            model.addRow(new Object[]{username, members.get(username)});
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(this, scrollPane, "Registered Members", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManageMember().setVisible(true);
        });
    }
}



