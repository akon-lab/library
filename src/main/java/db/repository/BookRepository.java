package db.repository;

import db.ConnectDb;
import interface_pac.SqlInterface;
import models.BookModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookRepository extends ConnectDb implements SqlInterface<BookModel> {

    @Override
    public BookModel searchById(Integer id) {

        BookModel item = new BookModel();

        try {
            String sql = "select * from books " +
                    "where id = " + id + " limit 1;";
            Statement statement = super.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                item = new BookModel(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("title"),
                        resultSet.getInt("price")
                );
            }

            return item;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return item;
    }

    @Override
    public ArrayList<BookModel> getAll() {
        ArrayList<BookModel> list = new ArrayList<>();

        try {
            String sql = "select * from books ";
            Statement statement = super.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new BookModel(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("title"),
                        resultSet.getInt("price")
                ));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(BookModel book) {
        try {
            String sql = "INSERT INTO books(title, price,author) " +
                    "VALUE(?, ?, ?)";
            PreparedStatement stmt = super.getConnection().prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, book.getCopy());
            stmt.setString(3, book.getAuthor());
            stmt.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void update(BookModel book) {
        try {
            String sql = "UPDATE books SET " +
                    "title = ?," +
                    "price = ?," +
                    "author = ? " +
                    "where id = ?";
            PreparedStatement stmt = super.getConnection().prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setInt(2, book.getCopy());
            stmt.setString(3, book.getAuthor());
            stmt.setInt(4, book.getId());
            stmt.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void remove(Integer id) {
        String sql = "delete from books where id = ?";

        try {
            PreparedStatement stmt = super.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public ArrayList<BookModel> search(String word) {
        ArrayList<BookModel> list = new ArrayList<>();

        try {
            String sql = "select * from books " +
                    "where title like '%" + word + "%' " +
                    "or author like '%" + word + "%' ";

            Statement statement = super.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new BookModel(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("title"),
                        resultSet.getInt("price")
                ));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }


}
