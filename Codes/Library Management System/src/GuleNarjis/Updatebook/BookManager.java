/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Updatebook;

/**
 *
 * @author Gule Narjis
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    static List<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void initializeSampleBooks() {
        books.add(new Book("Effective Java", "Joshua Bloch", "Programming", 45.0, true));
        books.add(new Book("Clean Code", "Robert C. Martin", "Software Engineering", 50.0, true));
    }

    public static void updateBook() {
        System.out.print("Enter title of the book to update: ");
        String title = scanner.nextLine();
        Book book = findBookByTitle(title);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.println("\nCurrent Details:");
        book.displayDetails();

        System.out.print("\nEnter new title (leave blank to keep current): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty() && isTitleDuplicate(newTitle)) {
            System.out.println("Error: Title already exists.");
            return;
        }

        System.out.print("Enter new author (leave blank to keep current): ");
        String newAuthor = scanner.nextLine();

        System.out.print("Enter new genre (leave blank to keep current): ");
        String newGenre = scanner.nextLine();

        System.out.print("Enter new price (enter -1 to keep current): ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine(); // clear buffer

        System.out.print("Is the book available? (yes/no): ");
        String availability = scanner.nextLine();

        // Update values
        if (!newTitle.isEmpty()) book.setTitle(newTitle);
        if (!newAuthor.isEmpty()) book.setAuthor(newAuthor);
        if (!newGenre.isEmpty()) book.setGenre(newGenre);
        if (newPrice >= 0) book.setPrice(newPrice);

        if (availability.equalsIgnoreCase("yes") || availability.equalsIgnoreCase("no")) {
            book.setAvailable(availability.equalsIgnoreCase("yes"));
        }

        System.out.println("\nBook updated successfully.");
        book.displayDetails();
    }

    private static Book findBookByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    private static boolean isTitleDuplicate(String newTitle) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(newTitle)) {
                return true;
            }
        }
        return false;
    }
}

