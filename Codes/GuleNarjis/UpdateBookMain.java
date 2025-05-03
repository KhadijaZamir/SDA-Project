/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Updatebook;

/**
 *
 * @author Gule Narjis
 */
public class UpdateBookMain {
    public static void main(String[] args) {
        BookManager.initializeSampleBooks();

        System.out.println("=== Update Book Interface ===");
        BookManager.updateBook();
    }
}
