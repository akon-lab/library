package services;

import comparators.BookCopyComparator;
import db.repository.BookRepository;
import interface_pac.ServiceInterface;
import models.BookModel;

import java.util.*;

public class BookService implements ServiceInterface<BookModel> {
    private BookRepository bookSql = null;



    public ArrayList<BookModel> recommendBooks(ArrayList<BookModel> alreadyHave) {
        return null;
    }

    //return and borrow
    public void returnedBook(Integer id) {
        if(bookSql==null){
            bookSql = new BookRepository();
        }
        bookSql.updateBookCopy(id, bookSql.searchById(id).getCopy() + 1);
    }
    public ArrayList<BookModel> getAllUserBooks(int id){
        if(bookSql == null){
            bookSql = new BookRepository();
        }
        return bookSql.getAllUserBooks(id);
    }

    public void addUserBook(int user_id,int book_id){
        if(bookSql == null){
            bookSql = new BookRepository();
        }
        bookSql.addUserBook(user_id,book_id);
    }

    public void borrowBook(String booksId) {
        if(bookSql==null){
            bookSql = new BookRepository();
        }
        for (String id:booksId.split(" ")){
            bookSql.updateBookCopy(Integer.parseInt(id), bookSql.searchById(Integer.parseInt(id)).getCopy() - 1);
        }

    }

    @Override
    public void remove(Integer id) {
        if(bookSql == null){
            bookSql = new BookRepository();
        }
        bookSql.remove(id);
    }

    //interface method
    @Override
    public ArrayList<BookModel> getAll() {
        if(bookSql==null){
            bookSql = new BookRepository();
        }
        return bookSql.getAll();
    }

    @Override
    public BookModel getItemById(Integer id) {
        if(bookSql == null){
            bookSql = new BookRepository();
        }
        return bookSql.searchById(id);
    }

    @Override
    public void add(BookModel item) {
        if(bookSql ==null){
            bookSql = new BookRepository();
        }
        bookSql.add(item);
    }

    @Override
    public void update(BookModel item) {
        if(bookSql == null){
            bookSql = new BookRepository();
        }
        bookSql.update(item);
    }


    @Override
    public ArrayList<BookModel> search(String word) {
        if(bookSql ==null){
            bookSql = new BookRepository();
        }
        return bookSql.search(word);
    }

    public ArrayList<BookModel> sortByCopy(ArrayList<BookModel> books) {
        Comparator copy = new BookCopyComparator();
        Collections.sort(books, copy);
        return books;
    }
}
