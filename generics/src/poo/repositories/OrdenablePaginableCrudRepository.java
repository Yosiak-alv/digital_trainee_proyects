package poo.repositories;

public interface OrdenablePaginableCrudRepository<T>
extends CrudRepository<T>, PaginableRepository<T>, OrdenableRepository<T>, ContableRepository {
}
