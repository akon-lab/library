package interface_pac;

import java.util.LinkedList;

public interface SqlInterface<T> {
    T searchById(Integer id);
    LinkedList<T> getAll();

    void add(T item);
    void update(T item);
    void remove(Integer id);

}
