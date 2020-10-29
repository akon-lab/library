package db.repository;

import db.ConnectDb;
import interface_pac.SqlInterface;
import models.BookModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class BookRepository extends ConnectDb implements SqlInterface<BookModel> {

    @Override
    public BookModel searchById(Integer id) {

        BookModel item = new BookModel();

        try {
            String sql = "select * from books " +
                    "where id = " + id + ";";
            Statement statement = super.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                item = new BookModel(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("image"),
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
    public LinkedList<BookModel> getAll() {
        LinkedList<BookModel> list = new LinkedList<>();

        try {
            String sql = "select * from books ";
            Statement statement = super.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new BookModel(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("image"),
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
            String sql = "INSERT INTO books(title,description,image,price,author) " +
                    "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement stmt = super.getConnection().prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getDesc());
            stmt.setString(3, book.getImg());
            stmt.setInt(4, book.getPrice());
            stmt.setString(5, book.getAuthor());
            stmt.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void update(BookModel item) {

    }

    @Override
    public void remove(Integer id) {

    }


}
