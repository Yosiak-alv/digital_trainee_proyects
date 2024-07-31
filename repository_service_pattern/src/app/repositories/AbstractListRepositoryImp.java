package app.repositories;

import app.models.BaseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractListRepositoryImp<T extends BaseModel, ID>
        implements BaseListRepository<T, ID> {

    List<T> data = new ArrayList<>();

    @Override
    public List<T> findAll() {
        return this.data;
    }

    @Override
    public Optional<T> findById(ID id) {
        return this.data.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public void save(T model) {
        this.data.add(model);
    }

    @Override
    public void update(ID id, T model) {
        T result = this.findById(id).orElse(null);
        if (result != null) result = model;
    }

    @Override
    public void deleteById(ID id) {
        this.data.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public long count() {
        return this.data.size();
    }

    @Override
    public List<T> findAll(int fromIndex, int toIndex) {
        return this.data.subList(fromIndex, toIndex);
    }

    /* @Override
    public List<T> findAllSortedBy(String field, boolean isAscending) {
        return List.of();
    }*/
}
