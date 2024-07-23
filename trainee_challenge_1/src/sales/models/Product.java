package sales.models;

public class Product {

    private int id;
    private String name;
    private double price;
    private static int count = 0;

    public Product(String name, double price) {
        this.id = ++count;
        this.name = name;
        this.price = price;
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public double getPrice() {
        return price;
    }

    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setPrice(double price) {this.price = price;}

    @Override
    public String toString() {

        return "id: "+ id + " - " + name +  " $" + price;
    }
}
