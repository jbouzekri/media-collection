/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.gui.detail;

import javax.swing.JPanel;

/**
 *
 * @author jobou
 */
public abstract class MediaDetail {

  public abstract void setPanel(JPanel panel);

  public abstract void initComponents();

  public abstract void loadItemForId(Integer id);

  public abstract void detailPaneVisibility(boolean visible);
}
