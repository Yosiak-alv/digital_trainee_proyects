package test;

import sales.enums.PaymentType;
import sales.models.Client;
import sales.models.Order;
import sales.models.Product;

public class Main {
    public static void main(String[] args) {
        // Create new clients
        Client client = new Client("Josias", PaymentType.CREDITO);
        Client client2 = new Client("Isaac", PaymentType.CONTADO);
        Client client3 = new Client("Maria", PaymentType.CONTADO);

        Product[] products = new Product[10];
        products[0] = new Product("Laptop", 15000);
        products[1] = new Product("Mouse", 500);
        products[2] = new Product("Keyboard", 1000);
        products[3] = new Product("Monitor", 3000);
        products[4] = new Product("Headset", 2000);
        products[5] = new Product("Mousepad", 100.50);
        products[6] = new Product("Webcam", 1500);
        products[7] = new Product("Printer", 5000);
        products[8] = new Product("Scanner", 3000);
        products[9] = new Product("Projector", 10000);
        //products[10] = new Product("Tablet", 8000);

        Order order = new Order();
        order.addClient(client);
        for (Product product : products) {
            //only add 10 products
            order.addProduct(product);
        }
        order.showOrder();

        Order order2 = new Order();
        order2.addClient(client2);
        order2.addProduct(products[0]);
        order2.addProduct(products[1]);
        order2.addProduct(products[2]);
        order2.showOrder();

        Order order3 = new Order();
        order3.addClient(client3);
        order3.addProduct(products[3]);
        order3.addProduct(products[4]);
        order3.addProduct(products[5]);
        order3.addProduct(products[6]);
        order3.showOrder();
    }
}