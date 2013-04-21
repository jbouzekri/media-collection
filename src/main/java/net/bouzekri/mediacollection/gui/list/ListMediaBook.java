/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.gui.list;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.bouzekri.mediacollection.DatabaseConnection;
import net.bouzekri.mediacollection.model.Book;

/**
 *
 * @author jobou
 */
public class ListMediaBook extends ListMedia {

    Dao<Book, Integer> bookDao;
    List<Book> allBook;

    public ListMediaBook() throws SQLException {
        ConnectionSource connection = DatabaseConnection.getInstance().getConnectionSource();
        bookDao = DaoManager.createDao(connection, Book.class);

        Book book = new Book();
        book.setTitle("My first book 23");
        book.setDate();

        System.out.println(book.getDate());
        // persist the account object to the database
        bookDao.create(book);
    }

    @Override
    public DefaultTableModel load() {
        DefaultTableModel tableModel = new DefaultTableModel();
        for (int i = 0; i < getAvailableColumns().size(); i++) {
            tableModel.addColumn(getAvailableColumns().get(i));
        }
        try {
            allBook = bookDao.queryForAll();
            for (int i = 0; i < allBook.size(); i++) {
                tableModel.addRow(allBook.get(i).toTableRow());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListMediaBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tableModel;
    }

    @Override
    public Book getListElement(int index) {
        return allBook.get(index);
    }

    @Override
    public void setAvailableColumns() {
        availableColumn.add("id");
        availableColumn.add("title");
        availableColumn.add("author");
    }

  @Override
  public int[] getFilterColumn() {
    return new int[]{0, 1, 2};
  }
}
