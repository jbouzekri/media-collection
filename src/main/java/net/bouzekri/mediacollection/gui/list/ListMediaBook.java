/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.gui.list;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import java.awt.Dialog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import net.bouzekri.mediacollection.DatabaseConnection;
import net.bouzekri.mediacollection.gui.detail.BookDetail;
import net.bouzekri.mediacollection.gui.detail.MediaDetail;
import net.bouzekri.mediacollection.gui.dialog.BookDialog;
import net.bouzekri.mediacollection.model.Book;
import net.bouzekri.mediacollection.model.Media;

/**
 *
 * @author jobou
 */
public class ListMediaBook extends ListMedia {

    Dao<Book, Integer> dao;

    public ListMediaBook() throws SQLException {
        ConnectionSource connection = DatabaseConnection.getInstance().getConnectionSource();
        dao = DaoManager.createDao(connection, Book.class);
        try {
          itemList = (List<Media>)(List<?>) dao.queryForAll();
        } catch (SQLException ex) {
          itemList = new ArrayList<Media>();
          Logger.getLogger(ListMedia.class.getName()).log(Level.SEVERE, null, ex);
        }

/*        Book book = new Book();
        book.setTitle("My first book 23");
        book.setDate();

        // persist the account object to the database
        bookDao.create(book);*/
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

  @Override
  public Dialog getModifyDialog(java.awt.Frame parent, boolean modal) {
    return new BookDialog(parent, modal);
  }

  @Override
  public MediaDetail getDetailPanel(JPanel detailPanel) {
    if (this.detailPanel == null) {
      this.detailPanel = new BookDetail();
      this.detailPanel.setPanel(detailPanel);
    }

    return this.detailPanel;
  }
}
