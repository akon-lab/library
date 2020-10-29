package db.repository;

import db.ConnectDb;
import interface_pac.SqlInterface;
import models.BookModel;
import models.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class UserRepository extends ConnectDb implements SqlInterface<UserModel> {

    public UserModel searchUserByUsername(String username) {
        UserModel userItem = null;

        try {
            String sql = "select * from users " +
                    "where username = " + username + ";";
            Statement statement = super.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                userItem = new UserModel(
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getString("fname"),
                        resultSet.getString("sname")
                );
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return userItem;
    } //in future will be avaiable
    @Override
    public UserModel searchById(Integer id) {
        return null;
    }

    @Override
    public LinkedList<UserModel> getAll() {
        return null;
    }

    @Override
    public void add(UserModel user) {
        try {
            String sql = "INSERT INTO users(username,password,fname,sname) " +
                    "VALUES(?, ?, ?, ?)";
            PreparedStatement stmt = super.getConnection().prepareStatement(sql);

            stmt.setString(1,user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFname());
            stmt.setString(4,user.getSname());

            stmt.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void update(UserModel item) {

    }

    @Override
    public void remove(Integer id) {

    }



}
