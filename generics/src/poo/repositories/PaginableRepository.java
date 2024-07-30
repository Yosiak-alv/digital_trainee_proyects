package poo.repositories;

import java.util.List;

public interface PaginableRepository<T> {
    List<T> list(int first, int last);
}
