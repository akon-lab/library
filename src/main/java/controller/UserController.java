package controller;

import db.repository.UserRepository;
import interface_pac.ControllerInterface;
import models.UserModel;

import java.util.ArrayList;

public class UserController implements ControllerInterface<UserModel> {
    private UserRepository userSql = null;

   public UserController() {
        if (userSql == null) {
            userSql = new UserRepository();
        }
    }

    @Override
    public ArrayList<UserModel> getAll() {
        return userSql.getAll();
    }

    @Override
    public UserModel getItemById(Integer id) {
        return userSql.searchById(id);
    }

    @Override
    public void add(UserModel item) {
        userSql.add(item);
    }

    @Override
    public void update(UserModel item) {
        userSql.update(item);
    }

    @Override
    public void remove(Integer id) {
        userSql.remove(id);
    }

    @Override
    public ArrayList<UserModel> serch(String word) {
        return userSql.search(word);
    }


}
