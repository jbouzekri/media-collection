/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.gui.list;

import java.sql.SQLException;

/**
 *
 * @author jobou
 */
public class ListMediaFactory {

    public static final int BOOK_LIST = 1;

    public static ListMedia getList(int type) throws SQLException, Exception {

        ListMedia list = null;

        switch (type) {
            case ListMediaFactory.BOOK_LIST:
                list = new ListMediaBook();
                break;

            default:
                throw new Exception("Unknown list type");
        }

        return list;
    }
}
