package poo.models;

public class Product extends BaseEntity {
    private String description;
    private Double price;

    public Product(String description, Double price) {
        super();
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "id=" + getId() + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price ;
    }
}
