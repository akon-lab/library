package services;

import comparators.BookCopyComparator;
import db.repository.BookRepository;
import interface_pac.ServiceInterface;
import models.BookModel;

import java.util.*;

public class BookService implements ServiceInterface<BookModel> {
    private BookRepository bookSql = null;
    private ArrayList<BookModel> bookList = null;

    public BookService() {
        if (bookSql == null) {
            bookSql = new BookRepository();
        }
        if (bookList == null) {
            bookList = getAll();
        }
    }

    //getter
    public ArrayList<BookModel> getBookList() {
        return bookList;
    }

    public ArrayList<BookModel> recommendBooks(ArrayList<BookModel> alreadyHave) {

        return null;
    }

    //return and borrow
    public void returnedBook(Integer id) {
        bookSql.updateBookCopy(id, bookSql.searchById(id).getCopy() + 1);
    }

    public void borrowBook(String booksId) {
        for (String id:booksId.split(" ")){
            bookSql.updateBookCopy(Integer.parseInt(id), bookSql.searchById(Integer.parseInt(id)).getCopy() - 1);
        }

    }

    //
    public void remove(Integer id) {
        bookSql.remove(id);
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
    public ArrayList<BookModel> search(String word) {
        return bookSql.search(word);
    }

    public ArrayList<BookModel> sortByCopy(ArrayList<BookModel> books) {
        Comparator copy = new BookCopyComparator();
        Collections.sort(books, copy);
        return books;
    }
}
