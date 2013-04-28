/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.gui.list;

import java.awt.Dialog;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import net.bouzekri.mediacollection.gui.detail.MediaDetail;
import net.bouzekri.mediacollection.model.Media;

/**
 *
 * @author jobou
 */
public abstract class ListMedia {

    List<Media> itemList = new ArrayList<Media>();

    ArrayList<String> availableColumn = new ArrayList<String>();
    ArrayList<String> enabledColumn = new ArrayList<String>();

    MediaDetail detailPanel = null;

    public MediaTableModel load() {
        MediaTableModel tableModel = new MediaTableModel();
        for (int i = 0; i < this.getEnabledColumns().size(); i++) {
            tableModel.addColumn(getEnabledColumns().get(i));
        }
        for (int i = 0; i < itemList.size(); i++) {
            tableModel.addRow(itemList.get(i).toTableRow(this.getEnabledColumns()));
        }

        return tableModel;
    }

    public Media getListElement(int index) {
        return itemList.get(index);
    }

    public ArrayList<String> getAvailableColumns() {
        if (availableColumn.isEmpty()) {
            setAvailableColumns();
        }
        return availableColumn;
    }

    public abstract void setAvailableColumns();

    public ArrayList<String> getEnabledColumns() {
      return this.getAvailableColumns();
    }

    public abstract int[] getFilterColumn();

    public abstract Dialog getModifyDialog(java.awt.Frame parent, boolean modal);

    public abstract MediaDetail getDetailPanel(JPanel detailPanel);
}
