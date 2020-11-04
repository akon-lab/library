package controller;

import models.BookModel;
import services.BookService;

import java.util.ArrayList;

public class BookController  {
    private BookService bookService = null;


    public BookController() {
        if (bookService == null) {
            bookService = new BookService();
        }
    }

    public ArrayList<BookModel> getAll() {
        return bookService.getBookList();
    }

    public BookModel getItemById(Integer id) {
        return bookService.getItemById(id);
    }

    public void add(BookModel item) {
        bookService.add(item);
    }

    public void update(BookModel item) {
        bookService.update(item);
    }

    public void remove(Integer id) {
        bookService.remove(id);
    }

    public ArrayList<BookModel> serch(String word) {
        return bookService.search(word);
    }

    public ArrayList<BookModel>  sortByCopy(ArrayList<BookModel> books){
        return bookService.sortByCopy(books);
    }
}
