package interface_pac;

import java.util.LinkedList;

public interface ControllerInterface<T> {
    LinkedList<T> getAll();
    T getItemById(Integer id);

    void add(T item);
    void update(T item);
    void remove(Integer id);
}
