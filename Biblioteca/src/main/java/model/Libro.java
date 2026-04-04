package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Libro implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("Year")
    @Expose
    private Integer year;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Publisher")
    @Expose
    private String publisher;
    @SerializedName("ISBN")
    @Expose
    private String isbn;
    @SerializedName("Pages")
    @Expose
    private Integer pages;
    private final static long serialVersionUID = -3930838321532352312L;

    public Libro() {
    }

    public Libro(Integer id, Integer year, String title, String publisher, String isbn, Integer pages) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.publisher = publisher;
        this.isbn = isbn;
        this.pages = pages;
    }

    @Override
    public String toString(){
        return "El libro " +title+", con el id "+id+", fue publicado en el año "+year+", contiene "+pages+" páginas y su código ISBN es: "+isbn;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}