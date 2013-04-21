package net.bouzekri.mediacollection.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;
import java.util.Vector;
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

    public int getDate() {
        return date;
    }
    public void setDate(int date) {
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

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPublished() {
        return published;
    }
    public void setPublished(int published) {
        this.published = published;
    }

    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }

    public Vector toTableRow() {
        Vector bookVector = new Vector();
        bookVector.addElement(this.getId());
        bookVector.addElement(this.getTitle());
        bookVector.addElement(this.getAuthor());
        return bookVector;
    }
}
