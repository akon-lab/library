package interface_pac;

import java.util.ArrayList;

public interface ServiceInterface<T> {
    ArrayList<T> getAll();
    T getItemById(Integer id);

    void remove(Integer id);

    void add(T item);
    void update(T item);
    ArrayList<T> search(String word);
}
