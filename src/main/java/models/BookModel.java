package models;

public class BookModel {
    private Integer id;
    private String title;
    private String author;
    private Integer copy;

    public BookModel(BookBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.author = builder.author;
        this.copy = builder.copy;
    }
    public BookModel(String title, String author,  Integer copy) {
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

    public static class BookBuilder{
        private Integer id;
        private String title;
        private String author;
        private Integer copy;
        public BookBuilder(String title){
            this.title = title;
        }
        public BookBuilder withId(Integer id){
            this.id = id;
            return this;
        }

        public BookBuilder withAuthor(String author){
            this.author = author;
            return this;
        }
        public BookBuilder withCopy(Integer copy){
            this.copy = copy;
            return this;
        }

        public BookModel build(){
            return new BookModel(this);
        }
    }
}
