/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Addusecase;

/**
 *
 * @author Gule Narjis
 */
public class Book {
    private String title;
    private String isbn;
    private String author;
    private int quantity;
    private boolean isAvailable;

    public Book(String title, String isbn, String author, int quantity) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.quantity = quantity;
        this.isAvailable = quantity > 0;
    }

    public String getIsbn() {
        return isbn;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("ISBN: " + isbn);
        System.out.println("Author: " + author);
        System.out.println("Quantity: " + quantity);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}

