package poo.repositories;

import java.util.List;

public interface OrdenableRepository<T> {
    List<T> list (String field, OrderType order);
}
