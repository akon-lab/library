package controller;

import db.repository.BookRepository;
import interface_pac.ControllerInterface;
import models.BookModel;

import java.util.LinkedList;

public class BookController implements ControllerInterface<BookModel> {
    private BookRepository bookSql = null;


    public BookController() {
        if (bookSql == null) {
            bookSql = new BookRepository();
        }

    }

    //getter

    //interface method
    @Override
    public LinkedList<BookModel> getAll() {
        return bookSql.getAll();
    }

    @Override
    public BookModel getItemById(Integer id) {
        return bookSql.searchById(id);
    }

    @Override
    public void add(BookModel item) {
        bookSql.add(item);
    }

    @Override
    public void update(BookModel item) {
        bookSql.update(item);
    }

    @Override
    public void remove(Integer id) {
        bookSql.remove(id);
    }

}
