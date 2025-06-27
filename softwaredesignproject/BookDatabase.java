/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package softwaredesignproject;

/**
 *
 * @author Gule Narjis
 */
import java.util.ArrayList;
import java.util.List;

public class BookDatabase {
    private static final List<Book> books = new ArrayList<>();

    static {
        // Initialize with some sample books
        addBook(new Book("B001", "Java Programming", "James Gosling", "Programming"));
        addBook(new Book("B002", "Effective Java", "Joshua Bloch", "Programming"));
        addBook(new Book("B003", "Clean Code", "Robert Martin", "Software"));
    }

    public static void addBook(Book book) {
        books.add(book);
    }

    public static boolean removeBook(String id) {
        return books.removeIf(book -> book.getId().equals(id));
    }

    public static List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public static boolean issueBook(String bookId, String username) {
    Book book = getBookById(bookId);
    if (book != null && book.isAvailable()) {
        book.setAvailable(false);
        book.setBorrowedBy(username);
        return true;
    }
    return false;
}

public static boolean returnBook(String bookId) {
    Book book = getBookById(bookId);
    if (book != null && !book.isAvailable()) {
        book.setAvailable(true);
        book.setBorrowedBy(null);
        return true;
    }
    return false;
}

    public static List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        String lowerQuery = query.toLowerCase();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(lowerQuery) ||
                book.getAuthor().toLowerCase().contains(lowerQuery) ||
                book.getGenre().toLowerCase().contains(lowerQuery)) {
                results.add(book);
            }
        }
        return results;
    }

    public static Book getBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
    public static List<Book> getBooksBorrowedBy(String username) {
    List<Book> borrowedBooks = new ArrayList<>();
    for (Book book : books) {
        if (!book.isAvailable() && username.equals(book.getBorrowedBy())) {
            borrowedBooks.add(book);
        }
    }
    return borrowedBooks;
}
}
