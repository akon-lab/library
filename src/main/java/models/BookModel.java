package models;

public class BookModel {
    private Integer id;
    private String title;
    private String author;
    private Integer copy;

    public BookModel( ) {

    } public BookModel(String title, String author,  Integer copy) {
        this.title = title;
        this.author = author;
        this.copy = copy;
    }
    public BookModel(Integer id, String title, String author,  Integer copy) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.copy = copy;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getCopy() {
        return copy;
    }
}
