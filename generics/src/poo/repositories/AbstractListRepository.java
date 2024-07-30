package poo.repositories;

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
    public T getById(Integer id) {
        for (T entity : data) {
            if (entity.getId() != null && entity.getId().equals(id)) return entity;
        }
        return null;
    }

    @Override
    public void create(T t) { data.add(t); }

    @Override
    public void update(T t) {
        T entity = getById(t.getId());
        if (entity != null) {
            entity = t;
        }
    }

    @Override
    public void delete(Integer id) {
        T entity = getById(id);
        if (entity != null) {
            data.remove(entity);
        }
    }

    @Override
    public int total() { return data.size(); }
}
