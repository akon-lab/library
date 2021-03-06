package interface_pac;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SqlInterface<T> {
    T searchById(Integer id);
    ArrayList<T> getAll();

    void add(T item);
    void update(T item);
    void remove(Integer id) throws SQLException;

    ArrayList<T> search(String word);
}
