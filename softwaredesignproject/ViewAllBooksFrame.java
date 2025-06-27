package softwaredesignproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewAllBooksFrame extends JFrame {
    public ViewAllBooksFrame() {
        setTitle("All Available Books");
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] columns = {"ID", "Title", "Author", "Genre", "Available"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }
        };

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

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
}
