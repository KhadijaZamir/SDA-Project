/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package softwaredesignproject;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
/**
 *
 * @author alish
 */
public class IssueDetails extends JFrame {
       public IssueDetails() {
        setTitle("Issued Books");
        setSize(600, 400);
        setLocationRelativeTo(null);

        List<Book> issuedBooks = BookDatabase.getAllBooks().stream()
                .filter(book -> !book.isAvailable())
                .toList();

        if (issuedBooks.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No books issued", "Issued Books", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Close the window if no data
            return;
        }

        String[] columns = {"ID", "Title", "Author", "Genre", "Issued To"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        for (Book book : issuedBooks) {
            tableModel.addRow(new Object[]{
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getBorrowedBy()
            });
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}


