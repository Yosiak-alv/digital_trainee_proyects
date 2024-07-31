package app.repositories;

import app.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends AbstractListRepository<Product, Integer>{

    @Override
    public List<Product> findAllSortedBy(String field, boolean isAscending) {
        List<Product> filterProducts = new ArrayList<>(datasource);
        filterProducts.sort((a, b) -> {
            if (isAscending) {
                return compare(field, a, b);
            } else {
                return compare(field, b, a);
            }
        });
        return filterProducts;
    }

    private int compare(String field, Product a, Product b) {
        return switch (field) {
            case "id" -> a.getId().compareTo(b.getId());
            case "name" -> a.getName().compareTo(b.getName());
            case "price" -> a.getPrice().compareTo(b.getPrice());
            default -> 0;
        };
    }
}
