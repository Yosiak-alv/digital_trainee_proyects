import models.Product;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product g  = new Product();
        g.setName("table");
        g.setPrice(100L);
        g.setDate(LocalDate.now());

        System.out.println("JSON: " + JsonSerializer.serializeToJson(g));
        System.out.println("Hello world!");
    }
}