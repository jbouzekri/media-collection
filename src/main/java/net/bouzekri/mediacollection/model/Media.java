/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.bouzekri.mediacollection.DatabaseConnection;
import net.bouzekri.mediacollection.dao.MediaDao;
import net.bouzekri.mediacollection.tools.StringTools;

/**
 *
 * @author jobou
 */
public abstract class Media extends Object {

      public Object[] toTableRow(ArrayList<String> enabledColumns) {
        boolean fieldFound;
        boolean methodFound;
        Object[] row = new Object[enabledColumns.size()];

        Class<?> reflectionClass = this.getClass();

        for (int i = 0; i < enabledColumns.size(); i++) {
          fieldFound = true;
          methodFound = true;

          try {
            Field reflectionField = reflectionClass.getDeclaredField(enabledColumns.get(i));
            reflectionField.setAccessible(true);
            row[i] = reflectionField.get(this);
          } catch (Exception e) {
            fieldFound = false;
          }

          try {
            if (!fieldFound) {
              Method reflectionMethod = reflectionClass.getDeclaredMethod("get"+StringTools.camelize(enabledColumns.get(i)));
              reflectionMethod.setAccessible(true);
              row[i] = reflectionMethod.invoke(this);
            }
          } catch(Exception e) {
            methodFound = false;
          }

          if (!fieldFound && !methodFound) {
            row[i] = "";
          }
        }

        return row;
    }

    public abstract MediaDao getDao() throws SQLException;
}
