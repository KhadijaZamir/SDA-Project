
package softwaredesignproject;

/**
 *
 * @author Gule Narjis
 */
public class SoftwareDesignProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Initialize with some test users
        UserDatabase.addUser("admin", "admin123", "admin@library.com");
        UserDatabase.addUser("user1", "user123", "user1@example.com");
        
        // Show login window
        new LoginFrame().setVisible(true);
    }
    
}
