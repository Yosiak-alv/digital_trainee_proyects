package app.repositories.interfaces;

import java.util.List;

public interface ListPagingAndSortingRepository<T> {
    List<T> findAll(int fromIndex, int toIndex);
    List<T> findAllSortedBy(String field, boolean isAscending);
}
