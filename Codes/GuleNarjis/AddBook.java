/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Addusecase;

/**
 *
 * @author Gule Narjis
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddBook {
    static List<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addBook() {
        System.out.println("\n=== Add New Book ===");

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        if (findBookByIsbn(isbn) != null) {
            System.out.println("Error: Book with this ISBN already exists.");
            return;
        }

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
            if (quantity < 0) {
                System.out.println("Error: Quantity cannot be negative.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Quantity must be a valid number.");
            return;
        }

        Book newBook = new Book(title, isbn, author, quantity);
        books.add(newBook);

        System.out.println("Book added successfully!");
        newBook.displayInfo();
    }

    static Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("\n--- Book List ---");
            for (Book book : books) {
                book.displayInfo();
                System.out.println("-----------------");
            }
        }
    }
}

