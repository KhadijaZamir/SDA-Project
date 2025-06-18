
import java.util.Scanner;

public class Demo {
 
    public static String[] memberIDs = {"12"};
    public static String[] memberTypes = {"student"};
    public static int[] booksBorrowed = {0};
    public static boolean[] hasOverdueBooks = {false};
    public static boolean[] hasUnpaidFines = {false};

    public static String[] bookIDs = {"Book1"};
    public static String[] bookTitles = {"Java Programming"};
    public static boolean[] isBookAvailable = {true};
    public static boolean[] isBookReserved = {false};
    public static String[] bookIssuedTo = {""};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IssueBook.initiateBookIssue();

        System.out.print("Enter Member ID: ");
        String memberID = scanner.nextLine();

        System.out.print("Enter Book ID: ");
        String bookID = scanner.nextLine();

        if (!IssueBook.validateMember(memberID)) return;
        if (!IssueBook.checkBookAvailability(bookID)) return;
        if (!IssueBook.checkBorrowingLimit(memberID)) return;

        String memberType = IssueBook.getMemberType(memberID);
        String dueDate = IssueBook.calculateDueDate(memberType);

        IssueBook.markBookIssued(bookID, memberID);
        IssueBook.updateRecords(bookID, memberID);
        IssueBook.confirmIssue();

        System.out.println("Please return the book by: " + dueDate);
        System.out.println("Book handed over to member.");

        scanner.close();
    }
    }
    

