package db.repository;

import db.ConnectDb;
import interface_pac.SqlInterface;
import models.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("list")
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
    public ArrayList<UserModel> getAll() {
        ArrayList<UserModel> list = new ArrayList<>();

        try {
            String sql = "select * from users ";

            Statement statement = super.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new UserModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("list")
                ));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return list;

    }

    @Override
    public void add(UserModel user) {
        try {
            String sql = "INSERT INTO users(name,email,password,list) " +
                    "VALUES(?, ?, ?, ?)";
            PreparedStatement stmt = super.getConnection().prepareStatement(sql);

            stmt.setString(1,user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4,user.getStringlist());

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

    @Override
    public ArrayList<UserModel> search(String word) {
        ArrayList<UserModel> list = new ArrayList<>();

        try {
            String sql = "select * from users " +
                    "where name like '%" + word + "%' " +
                    "or email like '%" + word + "%' ";

            Statement statement = super.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new UserModel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("list")
                ));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

       return list;
    }


}
