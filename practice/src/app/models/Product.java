package app.models;

import java.util.Objects;

public class Product extends BaseModel<Integer>{
    private Integer id;
    private String name;
    private Double price;

    private static int countId = 0;

    public Product(String name, Double price) {
        this.id = ++countId;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "id=" + id + '\'' +
                ", name=" + name + '\'' +
                ", price=" + price ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
