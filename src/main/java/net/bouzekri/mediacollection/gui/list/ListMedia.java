/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.gui.list;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jobou
 */
public abstract class ListMedia {

    ArrayList<String> availableColumn = new ArrayList<String>();

    public DefaultTableModel load() {
        return new DefaultTableModel();
    }

    public Object getListElement(int index) {
        return null;
    }

    public ArrayList<String> getAvailableColumns() {
        if (availableColumn.isEmpty()) {
            setAvailableColumns();
        }
        return availableColumn;
    }

    public abstract void setAvailableColumns();

    public abstract int[] getFilterColumn();
}
