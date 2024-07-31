package app.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudListRepository<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    void save(T model);
    void update(ID id, T model);
    void deleteById(ID id);

    long count();
}
