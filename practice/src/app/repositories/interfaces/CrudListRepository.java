package app.repositories.interfaces;

import java.util.List;

public interface CrudListRepository<T, ID> {
    List<T> findAll();
    T findById(ID id);
    void create(T model);
    void update(ID id,T model);
    void delete(ID id);
}
