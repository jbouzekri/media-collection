package net.bouzekri.mediacollection.model;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import java.sql.SQLException;
import java.util.Date;
import net.bouzekri.mediacollection.DatabaseConnection;
import net.bouzekri.mediacollection.dao.impl.BookDaoImpl;

/**
 * @author jobou
 */
@DatabaseTable(tableName = "book", daoClass = BookDaoImpl.class)
public class Book extends Media {

    @DatabaseField(generatedId = true)
    private Integer id;

    @DatabaseField(canBeNull = false)
    private String title;

    @DatabaseField
    private String author;

    @DatabaseField(canBeNull = false)
    private Integer date = null;

    @DatabaseField
    private String serie = null;

    @DatabaseField
    private Integer number = null;

    @DatabaseField
    private String isbn = null;

    @DatabaseField
    private Integer rating = null;

    @DatabaseField
    private Integer published = null;

    @DatabaseField
    private String cover = null;

    public Book() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getDate() {
        return date;
    }
    public void setDate(Integer date) {
        this.date = date;
    }

    public void setDate() {
        Date now = new Date();
        this.date = (int) (now.getTime() * .001);
    }

    public String getSerie() {
        return serie;
    }
    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getNumber() {
        return this.number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getPublished() {
        return published;
    }
    public void setPublished(Integer published) {
        this.published = published;
    }

    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public BookDaoImpl getDao() throws SQLException {
      ConnectionSource connection = DatabaseConnection.getInstance().getConnectionSource();
      return DaoManager.createDao(connection, Book.class);
    }

    public String getDisplayedSerie() {
      return this.getSerie()+" ["+Integer.toString(this.getNumber())+"]";
    }

}
