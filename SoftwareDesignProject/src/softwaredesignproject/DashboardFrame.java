/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package softwaredesignproject;

/**
 *
 * @author Gule Narjis
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class DashboardFrame extends JFrame {
    private JTable booksTable;
    private DefaultTableModel tableModel;

    public DashboardFrame() {
        setTitle("Library Management Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create main panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create table model
        String[] columns = {"ID", "Title", "Author", "Genre", "Available"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }
        };
        booksTable = new JTable(tableModel);
        refreshBooksTable();

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(booksTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(createButton("Add Book", this::addBook));
        buttonPanel.add(createButton("Delete Book", this::deleteBook));
        buttonPanel.add(createButton("Search", this::searchBooks));
        buttonPanel.add(createButton("Refresh", e -> refreshBooksTable()));
        buttonPanel.add(createButton("Logout", this::logout));
        buttonPanel.add(createButton("Issue Book", this::issueBook));
buttonPanel.add(createButton("Return Book", this::returnBook));
buttonPanel.add(createButton("My Books", this::showMyBooks));

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JButton createButton(String text, java.awt.event.ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        return button;
    }

    private void refreshBooksTable() {
        tableModel.setRowCount(0); // Clear table
        List<Book> books = BookDatabase.getAllBooks();
        for (Book book : books) {
            tableModel.addRow(new Object[]{
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.isAvailable()
            });
        }
    }

    private void addBook(ActionEvent e) {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        
        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField genreField = new JTextField();

        panel.add(new JLabel("Book ID:"));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(new JLabel("Genre:"));
        panel.add(genreField);

        int result = JOptionPane.showConfirmDialog(
                this, panel, "Add New Book", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String id = idField.getText();
            String title = titleField.getText();
            String author = authorField.getText();
            String genre = genreField.getText();

            if (id.isEmpty() || title.isEmpty() || author.isEmpty() || genre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (BookDatabase.getBookById(id) != null) {
                JOptionPane.showMessageDialog(this, "Book ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            BookDatabase.addBook(new Book(id, title, author, genre));
            refreshBooksTable();
            JOptionPane.showMessageDialog(this, "Book added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void deleteBook(ActionEvent e) {
        int selectedRow = booksTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a book to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String bookId = (String) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(
                this, 
                "Are you sure you want to delete this book?", 
                "Confirm Delete", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (BookDatabase.removeBook(bookId)) {
                refreshBooksTable();
                JOptionPane.showMessageDialog(this, "Book deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void searchBooks(ActionEvent e) {
        String query = JOptionPane.showInputDialog(this, "Enter search term:", "Search Books", JOptionPane.PLAIN_MESSAGE);
        if (query != null && !query.trim().isEmpty()) {
            List<Book> results = BookDatabase.searchBooks(query);
            tableModel.setRowCount(0);
            for (Book book : results) {
                tableModel.addRow(new Object[]{
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getGenre(),
                        book.isAvailable()
                });
            }
        }
    }

    private void logout(ActionEvent e) {
        int confirm = JOptionPane.showConfirmDialog(
                this, 
                "Are you sure you want to logout?", 
                "Confirm Logout", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
            new LoginFrame().setVisible(true);
        }
    }
    
    private void issueBook(ActionEvent e) {
    int selectedRow = booksTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a book to issue", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String bookId = (String) tableModel.getValueAt(selectedRow, 0);
    Book book = BookDatabase.getBookById(bookId);
    
    if (!book.isAvailable()) {
        JOptionPane.showMessageDialog(this, "Book is already issued", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String username = JOptionPane.showInputDialog(this, "Enter username to issue book to:", "Issue Book", JOptionPane.PLAIN_MESSAGE);
    if (username != null && !username.trim().isEmpty()) {
        if (BookDatabase.issueBook(bookId, username)) {
            refreshBooksTable();
            JOptionPane.showMessageDialog(this, "Book issued successfully to " + username, "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to issue book", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

private void returnBook(ActionEvent e) {
    int selectedRow = booksTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a book to return", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String bookId = (String) tableModel.getValueAt(selectedRow, 0);
    if (BookDatabase.returnBook(bookId)) {
        refreshBooksTable();
        JOptionPane.showMessageDialog(this, "Book returned successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Book is not currently issued", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void showMyBooks(ActionEvent e) {
    String username = JOptionPane.showInputDialog(this, "Enter username to view borrowed books:", "View Borrowed Books", JOptionPane.PLAIN_MESSAGE);
    if (username != null && !username.trim().isEmpty()) {
        List<Book> borrowedBooks = BookDatabase.getBooksBorrowedBy(username);
        if (borrowedBooks.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No books currently borrowed by " + username, "Borrowed Books", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Books borrowed by ").append(username).append(":\n\n");
            for (Book book : borrowedBooks) {
                sb.append(book.getTitle()).append(" (ID: ").append(book.getId()).append(")\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString(), "Borrowed Books", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
}
