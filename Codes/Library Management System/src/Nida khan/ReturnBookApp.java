
package Usecase;

import java.util.*;

public class ReturnBookApp {

    static Map<String, Book> issuedBooks = new HashMap<>();
 
    static String currentUser = "user123";

    public static void main(String[] args) {

        issuedBooks.put("B101", new Book("B101", "Clean Code", currentUser, "2024-04-15"));

        System.out.println("Return Book Process Started");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book ID to return: ");
        String bookId = scanner.nextLine().trim();

        if (issuedBooks.containsKey(bookId)) {
            Book book = issuedBooks.get(bookId);
            if (book.issuedTo.equals(currentUser)) {
              
                issuedBooks.remove(bookId);
                System.out.println("Book returned successfully: " + book.title);

                boolean isLate = checkIfLate(book.dueDate);
                if (isLate) {
                    int fine = calculateFine(book.dueDate);
                    System.out.println("Book is returned late. Fine: Rs. " + fine);
                } else {
                    System.out.println("Book returned on time. No fine.");
                }

                logReturn(bookId);
            } else {
                System.out.println("This book is not issued to you.");
            }
        } else {
            System.out.println("Invalid Book ID or book not issued.");
        }
    }
    public static int calculateFine(String dueDate) {
       
        return 50;
    }

    public static boolean checkIfLate(String dueDate) {
        return true; 
        
    }

    
    public static void logReturn(String bookId) {
        System.out.println("Return logged for book ID: " + bookId + ", by user: " + currentUser);
    }

    
    static class Book {
        String id;
        String title;
        String issuedTo;
        String dueDate;

        Book(String id, String title, String issuedTo, String dueDate) {
            this.id = id;
            this.title = title;
            this.issuedTo = issuedTo;
            this.dueDate = dueDate;
        }
    }
}

