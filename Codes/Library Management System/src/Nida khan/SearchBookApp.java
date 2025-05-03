
package Usecase;

import java.util.Scanner;
public class SearchBookApp {
    public static void initiateSearch() {
        System.out.println("Search page loaded. Ready for input.");
    }
    public static SearchData getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title (or leave blank): ");
        String title = scanner.nextLine();
        System.out.print("Enter author name (or leave blank): ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN (or leave blank): ");
        String isbn = scanner.nextLine();
        return new SearchData(title, author, isbn);
    }
    public static boolean validateSearchInput(SearchData data) {
        return data != null && (!data.title.isEmpty() || !data.author.isEmpty() || !data.isbn.isEmpty());
    }
    public static boolean checkSearchCriteria(SearchData data) {
        if (!data.isbn.isEmpty()) {
            return data.isbn.matches("\\d{10}|\\d{13}"); // 10 or 13 digit ISBN
        }
        return true;
    }
    public static Book[] queryCatalog(SearchData data) {
        Book[] books = {
            new Book("Effective Java", "Joshua Bloch", "0134685997"),
            new Book("Clean Code", "Robert Martin", "0132350882"),
            new Book("Head First Java", "Kathy Sierra", "0596009208")
        };
        Book[] results = new Book[books.length];
        int count = 0;
        for (Book b : books) {
            if ((data.title.isEmpty() || b.title.toLowerCase().contains(data.title.toLowerCase())) &&
                (data.author.isEmpty() || b.author.toLowerCase().contains(data.author.toLowerCase())) &&
                (data.isbn.isEmpty() || b.isbn.equals(data.isbn))) {
                results[count++] = b;
            }
        }
        Book[] finalResults = new Book[count];
        System.arraycopy(results, 0, finalResults, 0, count);
        return finalResults;
    }
    public static void processSearchResults(Book[] results) {
        System.out.println("Found " + results.length + " result(s).");
    }
    public static void displaySearchResults(Book[] results) {
        if (results.length == 0) {
            System.out.println("No books found.");
        } else {
            for (Book b : results) {
                System.out.println(b);
            }
        }
    }
    public static void logSearchActivity(String userId, SearchData data) {
        System.out.println("Search log: User = " + userId + ", Query = " + data);
    }
    static class SearchData {
        String title;
        String author;
        String isbn;
        public SearchData(String title, String author, String isbn) {
            this.title = title.trim();
            this.author = author.trim();
            this.isbn = isbn.trim();
        }
        public String toString() {
            return "[Title: " + title + ", Author: " + author + ", ISBN: " + isbn + "]";
        }
    }
    static class Book {
        String title;
        String author;
        String isbn;
        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }
        public String toString() {
            return "Book: " + title + " by " + author + " (ISBN: " + isbn + ")";
        }
    }
    public static void main(String[] args) {
        initiateSearch();
        SearchData input = getUserInput();
        if (!validateSearchInput(input)) {
            System.out.println("Please enter at least one search field.");
            return;
        }
        if (!checkSearchCriteria(input)) {
            System.out.println("Invalid ISBN format. Must be 10 or 13 digits.");
            return;
        }
        Book[] results = queryCatalog(input);
        processSearchResults(results);
        displaySearchResults(results);
        logSearchActivity("user123", input);
    }
}

