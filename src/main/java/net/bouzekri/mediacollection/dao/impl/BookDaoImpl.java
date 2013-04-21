/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.dao.impl;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import net.bouzekri.mediacollection.dao.BookDao;
import net.bouzekri.mediacollection.model.Book;

/** JDBC implementation of the AccountDao interface. */
public class BookDaoImpl extends BaseDaoImpl<Book, Integer> implements BookDao {
    // this constructor must be defined
    public BookDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Book.class);
    }
}