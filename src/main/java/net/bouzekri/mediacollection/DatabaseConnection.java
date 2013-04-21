/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.bouzekri.mediacollection.model.Book;

/**
 *
 * @author jobou
 */
public final class DatabaseConnection {

    private static DatabaseConnection instance = null;

    String databaseUrl = "jdbc:sqlite:data.db";
    ConnectionSource connectionSource = null;

    protected DatabaseConnection() {
        initConnection();
    }

    public boolean initConnection() {
        if (connectionSource == null) {
           try {
               connectionSource = new JdbcConnectionSource(databaseUrl);

               TableUtils.createTableIfNotExists(connectionSource, Book.class);

           } catch (SQLException ex) {
               Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
               return false;
           }
       }

        return true;
    }

    public void close() {
        if (connectionSource != null) {
            try {
                connectionSource.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean open() {
        return initConnection();
    }

    public ConnectionSource getConnectionSource() {
        return this.connectionSource;
    }

    public static DatabaseConnection getInstance() {
       if(instance == null) {
          instance = new DatabaseConnection();
       }
       return instance;
    }
}
