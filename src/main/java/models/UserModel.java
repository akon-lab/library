package models;


import java.util.ArrayList;

public class UserModel {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private ArrayList<BookModel> bookList = null;
    private String stringlist = null;



    public UserModel(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.bookList = userBuilder.bookList;
        this.stringlist = userBuilder.stringlist;
    }
        public UserModel(){

        }
    // for get data from db
    public UserModel(Integer id, String name, String email, String password, String list) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.stringlist = list;
        //this.bookList = setBookList(list);
    }

    //for save data to db
    public UserModel(String name, String email, String password, ArrayList<BookModel> bookList) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.bookList = bookList;
    }

    //setter
    //из стринга в лист


    //getter
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBookList(ArrayList<BookModel> bookList) {
        this.bookList = bookList;
    }

    public void setStringlist(String stringlist) {
        this.stringlist = stringlist;
    }

    public ArrayList<BookModel> getBookList() {
        return bookList;
    }

    public String getStringlist() {
        return stringlist;
    }

    public static class UserBuilder{
        private Integer id;
        private String name;
        private String email;
        private String password;
        private ArrayList<BookModel> bookList = null;
        private String stringlist = null;
        public UserBuilder(String name){
            this.name = name;
        }
        public UserBuilder withId(Integer id){
            this.id = id;
            return this;
        }

        public UserBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public UserBuilder withPassword(String password){
            this.password = password;
            return this;
        }

        public UserBuilder withBookList(ArrayList<BookModel> bookList){
            this.bookList = bookList;
            return this;
        }

        public UserBuilder withStringList(String stringlist){
            this.stringlist = stringlist;
            return this;
        }

        public UserModel build(){
            return new UserModel(this);
        }

    }
}
