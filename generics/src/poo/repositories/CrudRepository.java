package poo.repositories;

import java.util.List;

public interface CrudRepository<T> {
    void create(T t);
    void update(T t);
    void delete(Integer id);
    T getById(Integer id);
    List<T> list();
}
