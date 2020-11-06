package controller;

import models.UserModel;
import services.BookService;
import services.UserService;

import java.util.ArrayList;

public class UserController {
    private UserService userService = null;
    private BookService bookService = null;

    public UserController() {
        if (userService == null) {
            userService = new UserService();
        }
        if (bookService == null) {
            bookService = new BookService();
        }
    }

    public ArrayList<UserModel> getAll() {
        return userService.getAll();
    }

    public UserModel getItemById(Integer id) {
        return userService.getItemById(id);
    }

    public UserModel getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    public void add(UserModel item) {
        userService.add(item);
    }

    public void update(UserModel item) {
        userService.update(item);
    }

    public void remove(Integer id) {
          userService.remove(id);
    }

    public ArrayList<UserModel> serch(String word) {
        return userService.search(word);
    }

    public void removeBookFromUsersList(Integer bookId, Integer userId) {
        userService.removeBookFromUsersList(bookId, userId);
    }

    public void addBookIntoUsersList(String booksId, Integer userId) {
        userService.addBookIntoUsersList(booksId, userId);
        bookService.borrowBook(booksId);
    }
}
