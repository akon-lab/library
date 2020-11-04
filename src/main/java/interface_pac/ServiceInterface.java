package interface_pac;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ServiceInterface<T> {
    ArrayList<T> getAll();
    T getItemById(Integer id);

    void add(T item);
    void update(T item);
    void remove(Integer id) throws SQLException;
    ArrayList<T> search(String word);
}
