
public class Member {
     private String memberId;
    private String name;
    private String email;
    private boolean isActive;

    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.isActive = true;
    }
    public String getMemberId() {
        return memberId;
    }

    public boolean isActive() {
        return isActive;
    }
    public void updateDetails(String newName, String newEmail) {
        this.name = newName;
        this.email = newEmail;
        System.out.println("Member details updated successfully.");
    }
    public void deactivate() {
        this.isActive = false;
        System.out.println("Member deactivated successfully.");
    }
    public void display() {
        System.out.println("ID: " + memberId + ", Name: " + name + ", Email: " + email + ", Active: " + isActive);
    }
}
