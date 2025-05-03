
public class IssueBook {
    
    static String[] memberIDs = {"12"};
    static String[] memberTypes = {"student"};
    static int[] booksBorrowed = {0};
    static boolean[] hasOverdueBooks = {false};
    static boolean[] hasUnpaidFines = {false};

    static String[] bookIDs = {"Book1"};
    static String[] bookTitles = {"Java Programming"};
    static boolean[] isBookAvailable = {true};
    static boolean[] isBookReserved = {false};
    static String[] bookIssuedTo = {""};

    static void initiateBookIssue() {
        System.out.println("---- Issue Book Interface Loaded ----");
    }

    static boolean validateMember(String memberID) {
        int index = getMemberIndex(memberID);
        if (index == -1) {
            System.out.println("Error: Member not found.");
            return false;
        }
        if (hasOverdueBooks[index]) {
            System.out.println("Error: Member has overdue books.");
            return false;
        }
        if (hasUnpaidFines[index]) {
            System.out.println("Error: Member has unpaid fines.");
            return false;
        }
        return true;
    }

    static boolean checkBookAvailability(String bookID) {
        int index = getBookIndex(bookID);
        if (index == -1) {
            System.out.println("Error: Book not found.");
            return false;
        }
        if (!isBookAvailable[index] || isBookReserved[index]) {
            System.out.println("Error: Book is not available.");
            return false;
        }
        return true;
    }

    static boolean checkBorrowingLimit(String memberID) {
        int index = getMemberIndex(memberID);
        if (booksBorrowed[index] >= 3) {
            System.out.println("Error: Borrowing limit reached.");
            return false;
        }
        return true;
    }

    static String calculateDueDate(String memberType) {
        if (memberType.equals("student")) {
            return "14 days from today";
        } else {
            return "28 days from today";
        }
    }

    static void markBookIssued(String bookID, String memberID) {
        int index = getBookIndex(bookID);
        isBookAvailable[index] = false;
        bookIssuedTo[index] = memberID;
    }

    static void updateRecords(String bookID, String memberID) {
        int index = getMemberIndex(memberID);
        booksBorrowed[index]++;
    }

    static void confirmIssue() {
        System.out.println("Book issued successfully.");
    }

    static int getMemberIndex(String memberID) {
        for (int i = 0; i < memberIDs.length; i++) {
            if (memberIDs[i].equals(memberID)) return i;
        }
        return -1;
    }

    static int getBookIndex(String bookID) {
        for (int i = 0; i < bookIDs.length; i++) {
            if (bookIDs[i].equals(bookID)) return i;
        }
        return -1;
    }

    static String getMemberType(String memberID) {
        int index = getMemberIndex(memberID);
        return memberTypes[index];
    }
}
