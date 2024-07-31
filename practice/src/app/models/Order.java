package app.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order extends BaseModel<Integer> {
    private Integer id;
    private Client client;
    private List<Product> products;
    private Date date;

    private static int countId = 0;
    private final static int MAX_PRODUCTS = 10;

    public Order() {
        this.id = ++countId;
        this.date = new Date();
        this.products = new ArrayList<>(MAX_PRODUCTS);
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        if(products.size() < MAX_PRODUCTS){
            this.products = products;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal(){
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void showTicket() {
        System.out.println("------------------------------------------");
        System.out.println("#Id: " + id);
        System.out.println("Date: " + date);
        System.out.println("Client: " + client.getName() + " - " + client.getType());
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("Total Products: " + products.size());
        System.out.println("Oder Total: $" + getTotal());
        System.out.println("------------------------------------------");
    }

    @Override
    public String toString() {
        return  "id=" + id + '\'' +
                ", client={ " + client  + " }" + '\'' +
                ", products= " + products  + '\'' +
                ", date=" + date ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
