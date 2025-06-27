
package softwaredesignproject;


public class SoftwareDesignProject {

    
    public static void main(String[] args) {
         
        UserDatabase.addUser("admin", "admin123", "admin@library.com");
        UserDatabase.addUser("user1", "user123", "user1@example.com");
        
        
        new LoginFrame().setVisible(true);
    }
    
}
