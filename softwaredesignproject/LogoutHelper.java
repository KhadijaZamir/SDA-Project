package softwaredesignproject;

import javax.swing.*;

public class LogoutHelper {
    public static void performLogout(JFrame frame) {
        int confirm = JOptionPane.showConfirmDialog(
                frame,
                "Are you sure you want to logout?",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            frame.dispose(); // close current window
            new LoginFrame().setVisible(true); // redirect to login
        }
    }
}
