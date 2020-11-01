package controller;

import comparators.BookCopyComparator;
import db.repository.BookRepository;
import interface_pac.ControllerInterface;
import models.BookModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BookController implements ControllerInterface<BookModel> {
    private BookRepository bookSql = null;


    public BookController() {
        if (bookSql == null) {
            bookSql = new BookRepository();
        }
    }



    //interface method
    @Override
    public ArrayList<BookModel> getAll() {
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

    @Override
    public ArrayList<BookModel> serch(String word) {
        return bookSql.search(word);
    }

    public void sortByCopy(ArrayList<BookModel> books){
        Comparator copy=new BookCopyComparator();
        Collections.sort(books,copy);
    }
}
