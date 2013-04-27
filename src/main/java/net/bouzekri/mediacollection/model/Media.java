/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.model;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import net.bouzekri.mediacollection.dao.MediaDao;

/**
 *
 * @author jobou
 */
public abstract class Media extends Object {

      public Object[] toTableRow(ArrayList<String> enabledColumns) {
        Object[] row = new Object[enabledColumns.size()];

        Class<?> reflectionClass = this.getClass();

          for (int i = 0; i < enabledColumns.size(); i++) {
            try {
              Field reflectionField = reflectionClass.getDeclaredField(enabledColumns.get(i));
              reflectionField.setAccessible(true);
              row[i] = reflectionField.get(this);
            } catch(Exception e) {
              row[i] = "";
            }
          }

        return row;
    }

    public abstract MediaDao getDao() throws SQLException;
}
