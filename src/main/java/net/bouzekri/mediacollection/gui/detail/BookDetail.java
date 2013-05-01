/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.gui.detail;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.bouzekri.mediacollection.AppResourceBundle;
import net.bouzekri.mediacollection.DatabaseConnection;
import net.bouzekri.mediacollection.dao.impl.BookDaoImpl;
import net.bouzekri.mediacollection.exception.MediaImageNotFoundException;
import net.bouzekri.mediacollection.gui.MediaCollectionGui;
import net.bouzekri.mediacollection.model.Book;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author jobou
 */
public class BookDetail extends MediaDetail {

  protected javax.swing.JLabel serieLabel;
  protected javax.swing.JLabel serieValueLabel;
  protected javax.swing.JLabel titleLabel;
  protected javax.swing.JLabel titleValueLabel;
  protected javax.swing.JLabel authorLabel;
  protected javax.swing.JLabel authorValueLabel;
  protected javax.swing.JLabel coverLabel;
  protected javax.swing.JPanel detailInScrollPanel;
  private javax.swing.JPanel detailPanel;
  protected javax.swing.JScrollPane detailScrollPane;

  @Override
  public void setPanel(JPanel panel) {
    this.detailPanel = panel;
  }

  @Override
  public void loadItemForId(Integer id) {
    ConnectionSource connection = DatabaseConnection.getInstance().getConnectionSource();

    try {
      BookDaoImpl dao = DaoManager.createDao(connection, Book.class);
      Book bookItem = dao.queryForId(id);

      this.printDetailInPanel(bookItem);

    } catch (SQLException ex) {
      Logger.getLogger(MediaCollectionGui.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void detailPaneVisibility(boolean visible) {
    coverLabel.setVisible(visible);
    detailScrollPane.setVisible(visible);
  }

  public void detailPaneImageVisibility(boolean visible) {
    coverLabel.setVisible(false);
  }

  public void printDetailInPanel(Book book) {
    authorValueLabel.setText(book.getAuthor());
    titleValueLabel.setText(book.getTitle());
    serieValueLabel.setText(book.getDisplayedSerie());
    detailPaneVisibility(true);

    if (StringUtils.isNotBlank(book.getCover())) {

      ImageIcon image = new ImageIcon(book.getCover());

      try {
        coverLabel.setIcon(MediaDetail.getScaledImage(image));
      } catch (MediaImageNotFoundException ex) {
        Logger.getLogger(BookDetail.class.getName()).log(Level.SEVERE, ex.getMessage());
      }

      coverLabel.setText("");
    } else {
      this.detailPaneImageVisibility(false);
    }
  }

  @Override
  public void initComponents() {
    coverLabel = new javax.swing.JLabel();
    detailScrollPane = new javax.swing.JScrollPane();
    detailInScrollPanel = new javax.swing.JPanel();
    authorLabel = new javax.swing.JLabel();
    authorValueLabel = new javax.swing.JLabel();
    titleLabel = new javax.swing.JLabel();
    titleValueLabel = new javax.swing.JLabel();
    serieLabel = new javax.swing.JLabel();
    serieValueLabel = new javax.swing.JLabel();

    coverLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    coverLabel.setText(AppResourceBundle.getInstance().getString("col_ListMediaBook_cover"));
    coverLabel.setToolTipText("");
    coverLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

    detailScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    detailInScrollPanel.setPreferredSize(new java.awt.Dimension(100, 100));

    authorLabel.setText(AppResourceBundle.getInstance().getString("col_ListMediaBook_author"));

    authorValueLabel.setText("Author name 2");

    titleLabel.setText(AppResourceBundle.getInstance().getString("col_ListMediaBook_title"));

    titleValueLabel.setText("Title name");

    serieLabel.setText(AppResourceBundle.getInstance().getString("col_ListMediaBook_displayed_serie"));

    serieValueLabel.setText("Serie name");

    javax.swing.GroupLayout detailInScrollPanelLayout = new javax.swing.GroupLayout(detailInScrollPanel);
    detailInScrollPanel.setLayout(detailInScrollPanelLayout);
    detailInScrollPanelLayout.setHorizontalGroup(
      detailInScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(detailInScrollPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(detailInScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(authorLabel)
          .addComponent(titleLabel)
          .addComponent(serieLabel))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(detailInScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(authorValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
          .addComponent(titleValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(serieValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    detailInScrollPanelLayout.setVerticalGroup(
      detailInScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(detailInScrollPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(detailInScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(titleLabel)
          .addComponent(titleValueLabel))
        .addGap(11, 11, 11)
        .addGroup(detailInScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(authorLabel)
          .addComponent(authorValueLabel))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(detailInScrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(serieLabel)
          .addComponent(serieValueLabel))
        .addContainerGap(416, Short.MAX_VALUE))
    );

    detailScrollPane.setViewportView(detailInScrollPanel);

    javax.swing.GroupLayout detailPanelLayout = new javax.swing.GroupLayout(detailPanel);
    detailPanel.setLayout(detailPanelLayout);
    detailPanelLayout.setHorizontalGroup(
      detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(detailScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
      .addGroup(detailPanelLayout.createSequentialGroup()
        .addGap(122, 122, 122)
        .addComponent(coverLabel)
        .addContainerGap(138, Short.MAX_VALUE))
    );
    detailPanelLayout.setVerticalGroup(
      detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(detailPanelLayout.createSequentialGroup()
        .addComponent(coverLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(detailScrollPane))
    );
  }

}
