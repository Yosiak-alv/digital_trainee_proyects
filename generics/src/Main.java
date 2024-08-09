import poo.exceptions.AccessDataException;
import poo.models.Client;
import poo.models.Product;
import poo.repositories.AbstractListRepository;
import poo.repositories.OrdenablePaginableCrudRepository;
import poo.repositories.OrderType;
import poo.repositories.customrepo.ClientRepository;
import poo.repositories.customrepo.ProductRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) throws AccessDataException {

        OrdenablePaginableCrudRepository<Client> clientRepo = new ClientRepository();

        clientRepo.create(new Client("John", "Doe"));
        clientRepo.create(new Client("Clark", "Alvarez"));
        clientRepo.create(new Client("Bruce", "Wayne"));
        clientRepo.create(new Client("Peter", "Parker"));
        clientRepo.create(new Client("Tony", "Stark"));


        //list
        List<Client> clients = clientRepo.list();
        clients.forEach(System.out::println);
        System.out.println("===================paginable================");

        //list paginable
        List<Client> clientsPaginable = clientRepo.list(0, 2);
        clientsPaginable.forEach(System.out::println);

        //order
        System.out.println("===================order================");
        List<Client> clientsOrder = clientRepo.list("lastname", OrderType.ASC);
        clientsOrder.forEach(System.out::println);

        //update
        System.out.println("===================update================");
        Client bea = new Client("Bea", "Perez");
        bea.setId(1);
        clientRepo.update(bea);

        System.out.println("===================view updated================");
        clients = clientRepo.list();
        clients.forEach(System.out::println);

        //delete
        System.out.println("===================delete================");
        clientRepo.delete(2);

        System.out.println("===================view deleted================");
        clients = clientRepo.list();
        clients.forEach(System.out::println);

        //getById
        System.out.println("===================getById================");
        System.out.println(clientRepo.getById(3));

        //total
        System.out.println("===================total================");
        System.out.println(clientRepo.total());

        mainProducts();
    }

    private static void mainProducts() throws AccessDataException {
        OrdenablePaginableCrudRepository<Product> productRepo = new ProductRepository();

        productRepo.create(new Product("Laptop", 1000.0));
        productRepo.create(new Product("Mouse", 20.0));
        productRepo.create(new Product("Keyboard", 50.0));
        productRepo.create(new Product("Monitor", 300.0));

        //list
        List<Product> products = productRepo.list();
        products.forEach(System.out::println);

        //list paginable
        System.out.println("===================paginable================");
        List<Product> productsPaginable = productRepo.list(0, 2);
        productsPaginable.forEach(System.out::println);

        //order
        System.out.println("===================order================");
        List<Product> productsOrder = productRepo.list("price", OrderType.DESC);
        productsOrder.forEach(System.out::println);

        //update
        System.out.println("===================update================");
        Product laptop = new Product("laptop edit", 1000.0);
        laptop.setId(7);
        productRepo.update(laptop);

        System.out.println("===================view updated================");
        products = productRepo.list();
        products.forEach(System.out::println);

        //delete
        System.out.println("===================delete================");
        productRepo.delete(8);

        System.out.println("===================view deleted================");
        products = productRepo.list();
        products.forEach(System.out::println);

        //getById
        System.out.println("===================getById================");
        System.out.println(productRepo.getById(7));

        //total
        System.out.println("===================total================");
        System.out.println(productRepo.total());
    }
}