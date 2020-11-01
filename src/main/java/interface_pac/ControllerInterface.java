package interface_pac;

import java.util.ArrayList;

public interface ControllerInterface<T> {
    ArrayList<T> getAll();
    T getItemById(Integer id);

    void add(T item);
    void update(T item);
    void remove(Integer id);
}
