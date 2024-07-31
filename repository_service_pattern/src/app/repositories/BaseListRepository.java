package app.repositories;

public interface BaseListRepository<T, ID>
    extends ListPagingAndSortingRepository<T>, CrudListRepository<T, ID> {

}
