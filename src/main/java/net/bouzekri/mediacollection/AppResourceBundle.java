/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection;

import java.util.ResourceBundle;

/**
 *
 * @author jobou
 */
public class AppResourceBundle {

  private static ResourceBundle instance = null;

  public static ResourceBundle getInstance() {
       if(instance == null) {
          instance = ResourceBundle.getBundle("messages");
       }

       return instance;
  }
}
