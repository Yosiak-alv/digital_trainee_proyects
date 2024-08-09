package poo.repositories;

import poo.exceptions.AccessDataException;

import java.util.List;

public interface CrudRepository<T> {
    void create(T t) throws AccessDataException;
    void update(T t) throws AccessDataException;
    void delete(Integer id) throws AccessDataException;
    T getById(Integer id) throws AccessDataException;
    List<T> list();
}
