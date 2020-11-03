package models;

import models.builders.UserBuilder;

import java.util.ArrayList;

public class UserModel {
    private Integer id;
    private String name;
    private String email;
    private String password;

    private ArrayList<BookModel> bookList = new ArrayList<>();
    private String stringlist = null;

    private final UserBuilder userBuilder = new UserBuilder();

    public UserModel() {

    }

    // for get data from db
    public UserModel(Integer id, String name, String email, String password, String list) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.stringlist = list;
        bookList = setBookList(list);
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
    private ArrayList<BookModel> setBookList(String listOfNum) {
        return userBuilder.setBookList(listOfNum);

    }

    //перезаписать лист инт книгок на стринг
    public String setStringList(ArrayList<Integer> booksList) {
         return userBuilder.setStringList(booksList);

    }

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

    public ArrayList<BookModel> getBookList() {
        return bookList;
    }

    public String getStringlist() {
        return stringlist;
    }
}
