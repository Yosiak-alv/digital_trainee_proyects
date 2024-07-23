package sales.models;

import java.util.Date;

public class Order {

    private final int id;
    private final Date date;
    private Client client;
    private Product[] products;

    private static int count = 0;
    private int totalProducts = 0;
    private final static int MAX_PRODUCTS = 10;

    public Order(){
        this.id = ++count;
        this.date = new Date();
        this.products = new Product[MAX_PRODUCTS];
    }

    public void addProduct(Product product) {
        if (totalProducts < MAX_PRODUCTS) {
            this.products[totalProducts++] = product;
        }else{
            System.out.println("No se pueden agregar mas productos (MAX: " + MAX_PRODUCTS + "), en Orden Id: "+ id);
        }
    }

    public void addClient(Client client) {
        this.client = client;
    }

    public void showOrder() {
        System.out.println("------------------------------------------");
        System.out.println("#Id: " + id);
        System.out.println("Fecha: " + date);
        System.out.println(client);
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("Total de Productos: " + totalProducts);
        System.out.println("Total de la Orden: $" + getTotal());
        System.out.println("------------------------------------------");
    }

    public double getTotal() {
        double total = 0;
        for (Product product : this.products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }
}
