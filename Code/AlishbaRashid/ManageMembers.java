
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ManageMembers {
     static List<Member> members = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
         int choice;

        do {
            System.out.println("\n=== Manage Members ===");
            System.out.println("1. Add Member");
            System.out.println("2. Edit Member");
            System.out.println("3. Deactivate Member");
            System.out.println("4. View Members");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> addMember();
                case 2 -> editMember();
                case 3 -> deactivateMember();
                case 4 -> viewMembers();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    static void addMember() {
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine();
        if (findMember(id) != null) {
            System.out.println("Member ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Member member = new Member(id, name, email);
        members.add(member);
        System.out.println("Member added successfully.");
    }

    static void editMember() {
        System.out.print("Enter Member ID to edit: ");
        String id = scanner.nextLine();
        Member member = findMember(id);

        if (member != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            member.updateDetails(name, email);
        } else {
            System.out.println("Member not found.");
        }
    }

    static void deactivateMember() {
        System.out.print("Enter Member ID to deactivate: ");
        String id = scanner.nextLine();
        Member member = findMember(id);

        if (member != null) {
            member.deactivate();
        } else {
            System.out.println("Member not found.");
        }
    }

    static void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members available.");
        } else {
            for (Member member : members) {
                member.display();
            }
        }
    }

    static Member findMember(String id) {
        for (Member m : members) {
            if (m.getMemberId().equalsIgnoreCase(id)) {
                return m;
            }
        }
        return null;
    }
    }
    

