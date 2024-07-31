package main;

import app.models.Client;
import app.models.Order;
import app.models.Product;
import app.models.enums.ClientType;
import app.repositories.ClientRepository;
import app.repositories.OrderRepository;
import app.repositories.ProductRepository;
import app.repositories.interfaces.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BaseRepository<Client, Integer>  clientRepo = new ClientRepository();
        BaseRepository<Product, Integer> productRepo = new ProductRepository();
        BaseRepository<Order, Integer> orderRepo = new OrderRepository();

        //clients
        clientRepo.create(new Client("Client 1", ClientType.CONTADO));
        clientRepo.create(new Client("Client 2", ClientType.CREDITO));
        clientRepo.create(new Client("Client 3", ClientType.CONTADO));

        //products
        productRepo.create(new Product("Product 1", 100.0));
        productRepo.create(new Product("Product 2", 200.0));
        productRepo.create(new Product("Product 3", 300.0));
        productRepo.create(new Product("Product 4", 400.0));
        productRepo.create(new Product("Product 5", 500.0));


        //listing
        System.out.println("\nListing all clients");
        clientRepo.findAll().forEach(System.out::println);

        System.out.println("\nListing all products");
        productRepo.findAll().forEach(System.out::println);

        //find one
        System.out.println("\nFinding client with id 2");
        System.out.println(clientRepo.findById(2));

        System.out.println("\nFinding product with id 2");
        System.out.println(productRepo.findById(2));

        Order order1 = new Order();
        List<Product> orderProducts = new ArrayList<>(
                List.of(
                        productRepo.findById(1),
                        productRepo.findById(2),
                        productRepo.findById(3)
                )
        );
        order1.setProducts(orderProducts);
        order1.setClient(clientRepo.findById(1));
        //order1.setProducts(productRepo.findAll(1,4));
        orderRepo.create(order1);

        //list the order 1
        System.out.println("\nFinding order with id 1");
        System.out.println(orderRepo.findById(1));
        System.out.println("\norder 1 ticket");
        order1.showTicket();
        System.out.println("Total: " + orderRepo.findById(1).getTotal());

        //list total orders count
        System.out.println("\nTotal orders count: " + orderRepo.count());

    }
}