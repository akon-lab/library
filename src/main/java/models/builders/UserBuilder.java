package models.builders;

import db.repository.BookRepository;
import models.BookModel;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserBuilder {
    private BookRepository bookSql = null;

    //setter
    //из стринга в лист
    public UserBuilder() {
        if (bookSql == null) {
            bookSql = new BookRepository();
        }
    }

    public ArrayList<BookModel> setBookList(String listOfNum) {
        ArrayList<BookModel> bookList = null;

        if (listOfNum != null) {
            bookList = new ArrayList<>();
            for (String str : listOfNum.split(" ")) {
                bookList.add(bookSql.searchById(Integer.parseInt(str)));
            }
            return bookList;
        }

        return bookList;
    }

    //перезаписать лист инт книгок на стринг
    public String setStringList(ArrayList<Integer> booksList) {
        return booksList.stream().map(String::valueOf).collect(Collectors.joining(" "));

    }
}
