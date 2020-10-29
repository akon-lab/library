package controller;

import db.repository.UserRepository;
import interface_pac.ControllerInterface;
import models.UserModel;

import java.util.LinkedList;

public class UserController implements ControllerInterface<UserModel> {

    private final UserRepository userSql = new UserRepository();

    @Override
    public LinkedList<UserModel> getAll() {
        return null;
    }

    @Override
    public UserModel getItemById(Integer id) {
        return null;
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

    public UserModel findUserByUsername(String username) {
        return userSql.searchUserByUsername(username);
    }

}
