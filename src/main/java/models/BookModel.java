package models;

public class BookModel {
    private Integer id;
    private String title;
    private String author;
    private String desc;
    private String img;
    private Integer price;

    public BookModel( ) {

    }
    public BookModel(Integer id, String title, String author, String desc, String img, Integer price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.desc = desc;
        this.img = img;
        this.price = price;
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

    public String getDesc() {
        return desc;
    }

    public String getImg() {
        return img;
    }

    public Integer getPrice() {
        return price;
    }
}
