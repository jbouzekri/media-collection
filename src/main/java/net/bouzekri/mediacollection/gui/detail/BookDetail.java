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
import javax.swing.JPanel;
import net.bouzekri.mediacollection.DatabaseConnection;
import net.bouzekri.mediacollection.dao.impl.BookDaoImpl;
import net.bouzekri.mediacollection.gui.MediaCollectionGui;
import net.bouzekri.mediacollection.model.Book;

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
      authorValueLabel.setText(bookItem.getAuthor());
      titleValueLabel.setText(bookItem.getTitle());
      serieValueLabel.setText(bookItem.getDisplayedSerie());
      detailPaneVisibility(true);
    } catch (SQLException ex) {
      Logger.getLogger(MediaCollectionGui.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void detailPaneVisibility(boolean visible) {
    coverLabel.setVisible(visible);
    detailScrollPane.setVisible(visible);
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
    coverLabel.setText("Cover");
    coverLabel.setToolTipText("");
    coverLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

    detailScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    detailInScrollPanel.setPreferredSize(new java.awt.Dimension(100, 100));

    authorLabel.setText("Author");

    authorValueLabel.setText("Author name 2");

    titleLabel.setText("Title");

    titleValueLabel.setText("Title name");

    serieLabel.setText("Serie");

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
