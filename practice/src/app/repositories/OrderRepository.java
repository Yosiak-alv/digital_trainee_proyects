package app.repositories;

import app.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository extends AbstractListRepository<Order, Integer>{

    @Override
    public List<Order> findAllSortedBy(String field, boolean isAscending) {
        List<Order> filterOrders = new ArrayList<>(datasource);
        filterOrders.sort((a, b) -> {
            if (isAscending) {
                return compare(field, a, b);
            } else {
                return compare(field, b, a);
            }
        });
        return filterOrders;
    }

    private int compare(String field, Order a, Order b) {
        return switch (field) {
            case "id" -> a.getId().compareTo(b.getId());
            case "client" -> a.getClient().getName().compareTo(b.getClient().getName());
            case "products" -> a.getProducts().size() - b.getProducts().size();
            case "date" -> a.getDate().compareTo(b.getDate());
            default -> 0;
        };
    }
}
