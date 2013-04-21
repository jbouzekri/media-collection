package net.bouzekri.mediacollection;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.bouzekri.mediacollection.gui.MediaCollectionGui;

public class App
{
    public static void main( String[] args )
    {
        DatabaseConnection.getInstance().open();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MediaCollectionGui appFrame = null;
                try {
                    appFrame = new MediaCollectionGui();
                } catch (SQLException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
                appFrame.setVisible(true);
            }
        });

            /*Book book = new Book();
            book.setTitle("My first book");
            book.setDate();

            System.out.println(book.getDate());
            // persist the account object to the database
            bookDao.create(book);*/
    }
}
