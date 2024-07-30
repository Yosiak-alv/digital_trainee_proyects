package poo.repositories.customrepo;

import poo.models.Client;
import poo.models.Product;
import poo.repositories.AbstractListRepository;
import poo.repositories.OrderType;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends AbstractListRepository<Product> {

    @Override
    public void update(Product product) {
        Product entity = getById(product.getId());
        if (entity != null) {
            entity.setDescription(product.getDescription());
            entity.setPrice(product.getPrice());
        }
    }

    @Override
    public List<Product> list(String field, OrderType order) {
        List<Product> products = new ArrayList<>(this.data);
        products.sort((a, b) -> {
            int result = 0;
            if (order == OrderType.ASC) {
                result = order(field, a, b);
            } else if (order == OrderType.DESC) {
                result = order(field, b, a);
            }
            return result;
        });
        return products;
    }

    private static int order(String field, Product a, Product b) {
        return switch (field) {
            case "description" -> a.getDescription().compareTo(b.getDescription());
            case "price" -> a.getPrice().compareTo(b.getPrice());
            case "id" -> a.getId().compareTo(b.getId());
            default -> 0;
        };
    }
}
