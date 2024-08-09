package examples;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // TreeMap is a sorted map
        Map<String, Object> person = new TreeMap<>(Comparator.comparing(String::length).reversed());
        person.put("name", "John");
        person.put("lastName", "Doe");
        person.put("lastNameFather", "Smith");
        person.put("email", "joedoe@example.com");
        person.put("age", 30);

        Map<String, String> address = new TreeMap<>();
        address.put("street", "1234 Main St");
        address.put("city", "Springfield");
        address.put("state", "IL");
        address.put("country", "USA");
        address.put("zip", "62701");

        person.put("address", address);
        System.out.println("person: " + person);
    }
}
