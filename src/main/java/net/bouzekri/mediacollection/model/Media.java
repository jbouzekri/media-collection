/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author jobou
 */
public abstract class Media extends Object {

      public Vector toTableRow(ArrayList<String> enabledColumns) {
        Vector rowVector = new Vector();

        Class<?> reflectionClass = this.getClass();

          for (int i = 0; i < enabledColumns.size(); i++) {
            try {
              Field reflectionField = reflectionClass.getDeclaredField(enabledColumns.get(i));
              reflectionField.setAccessible(true);
              rowVector.addElement(reflectionField.get(this));
            } catch(Exception e) {
              rowVector.addElement("");
            }
          }

        return rowVector;
    }
}
