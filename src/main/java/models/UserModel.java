package models;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserModel {
    private Integer id;
    private String name;
    private String email;
    private String password;

    private ArrayList<Integer> bookList=new ArrayList<>();
    private String stringlist;

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
    public UserModel(String name, String email, String password, ArrayList<Integer> bookList) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.stringlist = setStringList(bookList);
        this.bookList = bookList;
    }

    //setter
    //из стринга в лист
    private ArrayList<Integer> setBookList(String listOfNum) {
        if (listOfNum!=null){
            bookList = new ArrayList<>();
            for (String str : listOfNum.trim().split(" ")) {
                bookList.add(Integer.parseInt(str));
            }
        }

        return null;
    }

    //перезаписать лист инт книгок на стринг
    public String setStringList(ArrayList<Integer> booksList) {
        stringlist = booksList.stream().map(String::valueOf).collect(Collectors.joining(" "));
        return stringlist;

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

    public ArrayList<Integer> getBookList() {
        return bookList;
    }

    public String getStringlist() {
        return stringlist;
    }
}
