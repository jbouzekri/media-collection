/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.gui;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import java.awt.Dialog;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import net.bouzekri.mediacollection.DatabaseConnection;
import net.bouzekri.mediacollection.dao.impl.BookDaoImpl;
import net.bouzekri.mediacollection.gui.list.ListMedia;
import net.bouzekri.mediacollection.gui.list.ListMediaFactory;
import net.bouzekri.mediacollection.gui.list.MediaTableModel;
import net.bouzekri.mediacollection.model.Book;
import net.bouzekri.mediacollection.tools.IntComparator;

/**
 *
 * @author jobou
 */
public class MediaCollectionGui extends JFrame {

    public MediaTableModel tableModel;
    public ListMedia currentListMedia;

    private TableRowSorter<AbstractTableModel> sorter;

    int currentType = ListMediaFactory.BOOK_LIST;

    /**
     * Creates new form MyMediaCollectionGui
     */
    public MediaCollectionGui() throws SQLException, Exception {
        initComponents();
        loadList();
        detailPaneOnLoadVisibility(false);
    }

    private void detailPaneOnLoadVisibility(boolean visible) {
      coverLabel.setVisible(visible);
      detailScrollPane.setVisible(visible);
    }

    private void loadList() throws SQLException, Exception {
        currentListMedia = ListMediaFactory.getList(currentType);

        tableModel = currentListMedia.load();
        sorter = new TableRowSorter<AbstractTableModel>(tableModel);
        sorter.setComparator(0, new IntComparator());
        MediaListTable.setModel(tableModel);
        MediaListTable.setRowSorter(sorter);

        ListSelectionModel rowSelectionModel = MediaListTable.getSelectionModel();
        rowSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                rowInListSelected(e);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    ListScrollPane = new javax.swing.JScrollPane();
    MediaListTable = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    searchField = new javax.swing.JTextField();
    addButton = new javax.swing.JButton();
    detailPanel = new javax.swing.JPanel();
    coverLabel = new javax.swing.JLabel();
    detailScrollPane = new javax.swing.JScrollPane();
    detailInScrollPanel = new javax.swing.JPanel();
    authorLabel = new javax.swing.JLabel();
    authorValueLabel = new javax.swing.JLabel();
    titleLabel = new javax.swing.JLabel();
    titleValueLabel = new javax.swing.JLabel();
    serieLabel = new javax.swing.JLabel();
    serieValueLabel = new javax.swing.JLabel();
    MenuBar = new javax.swing.JMenuBar();
    FileMenu = new javax.swing.JMenu();
    jMenuItem2 = new javax.swing.JMenuItem();
    EditMenu = new javax.swing.JMenu();
    EditPreferenceMenu = new javax.swing.JMenuItem();
    ViewMenu = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    HelpMenu = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("My Media Collection");
    setPreferredSize(new java.awt.Dimension(900, 500));
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosed(java.awt.event.WindowEvent evt) {
        appClosed(evt);
      }
    });

    MediaListTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    MediaListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    ListScrollPane.setViewportView(MediaListTable);

    jLabel1.setText("Filter");

    searchField.setText("jTextField1");
    searchField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        searchFieldActionPerformed(evt);
      }
    });

    addButton.setText("Add");
    addButton.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        addButtonMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(searchField))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(addButton)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(addButton)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    detailPanel.setMaximumSize(new java.awt.Dimension(300, 32767));
    detailPanel.setMinimumSize(new java.awt.Dimension(300, 100));
    detailPanel.setPreferredSize(new java.awt.Dimension(300, 100));

    coverLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    coverLabel.setText("Cover");
    coverLabel.setToolTipText("");
    coverLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

    detailScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    detailInScrollPanel.setPreferredSize(new java.awt.Dimension(100, 100));

    authorLabel.setText("Author");

    authorValueLabel.setText("Author name");

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

    FileMenu.setText("File");

    jMenuItem2.setText("Open Library");
    FileMenu.add(jMenuItem2);

    MenuBar.add(FileMenu);

    EditMenu.setText("Edit");

    EditPreferenceMenu.setText("Preference");
    EditMenu.add(EditPreferenceMenu);

    MenuBar.add(EditMenu);

    ViewMenu.setText("View");

    jMenuItem1.setText("Books");
    ViewMenu.add(jMenuItem1);

    MenuBar.add(ViewMenu);

    HelpMenu.setText("?");
    MenuBar.add(HelpMenu);

    setJMenuBar(MenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(ListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(detailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(ListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
          .addComponent(detailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void appClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_appClosed
        DatabaseConnection.getInstance().close();
    }//GEN-LAST:event_appClosed

  private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
    RowFilter<AbstractTableModel, Object> rf = null;

    try {
        rf = RowFilter.regexFilter(searchField.getText(), currentListMedia.getFilterColumn());
    } catch (java.util.regex.PatternSyntaxException ex) {
        Logger.getLogger(MediaCollectionGui.class.getName()).log(Level.SEVERE, null, ex);
        return;
    }
    sorter.setRowFilter(rf);
  }//GEN-LAST:event_searchFieldActionPerformed

  private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        final MediaCollectionGui thisFrame = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dialog dialog = currentListMedia.getModifyDialog(thisFrame, false);
                dialog.setVisible(true);
            }
        });
  }//GEN-LAST:event_addButtonMouseClicked

  private void rowInListSelected(ListSelectionEvent e) {
        //Ignore extra messages.
        if (e.getValueIsAdjusting()) {
          return;
        }

        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        if (lsm.isSelectionEmpty()) {
            detailPaneOnLoadVisibility(false);
        } else {
            int selectedRow = lsm.getMinSelectionIndex();
            Integer id = (Integer) MediaListTable.getModel().getValueAt(selectedRow, 0);
            ConnectionSource connection = DatabaseConnection.getInstance().getConnectionSource();
            try {
              BookDaoImpl dao = DaoManager.createDao(connection, Book.class);
              Book bookItem = dao.queryForId(id);
              authorValueLabel.setText(bookItem.getAuthor());
              detailPaneOnLoadVisibility(true);
            } catch (SQLException ex) {
              Logger.getLogger(MediaCollectionGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenu EditMenu;
  private javax.swing.JMenuItem EditPreferenceMenu;
  private javax.swing.JMenu FileMenu;
  private javax.swing.JMenu HelpMenu;
  private javax.swing.JScrollPane ListScrollPane;
  public javax.swing.JTable MediaListTable;
  private javax.swing.JMenuBar MenuBar;
  private javax.swing.JMenu ViewMenu;
  private javax.swing.JButton addButton;
  protected javax.swing.JLabel authorLabel;
  protected javax.swing.JLabel authorValueLabel;
  protected javax.swing.JLabel coverLabel;
  protected javax.swing.JPanel detailInScrollPanel;
  private javax.swing.JPanel detailPanel;
  protected javax.swing.JScrollPane detailScrollPane;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField searchField;
  protected javax.swing.JLabel serieLabel;
  protected javax.swing.JLabel serieValueLabel;
  protected javax.swing.JLabel titleLabel;
  protected javax.swing.JLabel titleValueLabel;
  // End of variables declaration//GEN-END:variables
}
