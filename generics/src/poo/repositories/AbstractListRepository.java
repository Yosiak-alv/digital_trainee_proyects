package poo.repositories;

import poo.exceptions.ReadAccessDataException;
import poo.exceptions.RegisterDuplicateAccessDataException;
import poo.exceptions.WriteAccessDataException;
import poo.models.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListRepository <T extends BaseEntity>
implements OrdenablePaginableCrudRepository<T> {
    protected List<T> data;

    public AbstractListRepository() {this.data = new ArrayList<>();}

    @Override
    public List<T> list() { return data; }

    @Override
    public List<T> list(int first, int last) {
        return data.subList(first, last);
    }

    @Override
    public T getById(Integer id)  throws ReadAccessDataException {
        if (id == null || id < 0) throw new ReadAccessDataException("Id must be greater than 0 and not null");

        T result = null;
        for (T entity : data) {
            if (entity.getId() != null && entity.getId().equals(id)) result = entity;
        }
        if(result == null) throw new ReadAccessDataException("Not found entity with id: " + id);
        return result;
    }

    @Override
    public void create(T t) throws WriteAccessDataException {
        if(t == null) throw new WriteAccessDataException("Entity is null");
        if (data.contains(t)) throw new RegisterDuplicateAccessDataException("Entity already exists");

        data.add(t);
    }

    @Override
    public void update(T t) throws ReadAccessDataException {
        T entity = getById(t.getId());
        if (entity != null) {
            entity = t;
        }
    }

    @Override
    public void delete(Integer id) throws ReadAccessDataException {
        T entity = getById(id);
        if (entity != null) {
            data.remove(entity);
        }
    }

    @Override
    public int total() { return data.size(); }
}
