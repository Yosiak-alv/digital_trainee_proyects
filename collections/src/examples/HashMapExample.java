package examples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        // hasMap have a key and a value
        Map<String,Object> person = new HashMap<>();

        System.out.println("Have elements: " + !person.isEmpty());

        person.put(null, "123456");
        person.put(null, "1234");
        person.put("name", "John");
        person.put("lastName", "Doe");
        person.put("lastNameFather", "Smith");
        person.put("email", "johndoe@example.com");
        person.put("age", 30);

        Map<String, String> address = new HashMap<>();
        address.put("street", "1234 Main St");
        address.put("city", "Springfield");
        address.put("state", "IL");
        address.put("country", "USA");
        address.put("zip", "62701");

        person.put("address", address);

        System.out.println("person: " + person);

        String name = (String) person.get("name");
        System.out.println("name: " + name);
        String lastName = (String) person.get("lastName");
        System.out.println("lastName: " + lastName);

        Map<String,String> addressPerson = (Map<String,String>) person.get("address");
        String country = addressPerson.get("country");
        String city = addressPerson.get("city");
        String hood = addressPerson.getOrDefault("hood", "Beach");

        System.out.println("THE COUNTRY OF: "+ name + " IS: " + country);
        System.out.println("THE CITY OF: "+ name + " IS: " + city);
        System.out.println("THE HOOD OF: "+ name + " IS: " + hood);

        boolean b = person.remove("lastNameFather", "Smith");
        System.out.println("remove: " + b);
        System.out.println("person: " + person);

        boolean b2 = person.containsKey("lastNameFather");
        System.out.println("containsKey: " + b2);

        b2 = person.containsValue("johndoe@example.com");
        System.out.println("containsValue: " + b2);

        System.out.println("================ values");
        Collection<Object> values = person.values();
        for (Object value : values) {
            System.out.println("value: " + value);
        }

        System.out.println("================ keys");

        Set<String> keys = person.keySet();
        for (String key : keys) {
            System.out.println("key: " + key);
        }

        System.out.println("================ entrySet");
        for (Map.Entry<String, Object> entry : person.entrySet()) {
            Object valor = entry.getValue();
            if(valor instanceof Map){
                String nombre = (String) person.get("name");
                Map<String,String> direccionMap = (Map<String,String>) valor;
                for (Map.Entry<String, String> entry2 : direccionMap.entrySet()) {
                    System.out.println("key: " + entry2.getKey() + " value: " + entry2.getValue());
                }
            }else{
                System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
            }
        }

        System.out.println("foreach java 8");
        person.forEach((key, value) -> {
            System.out.println("key: " + key + " value: " + value);
        });

        // total
        System.out.println("Total elements: " + person.size());
        //isempty
        System.out.println("Have elements: " + !person.isEmpty());
        boolean b3 = person.replace("name", "John", "Juan");
        System.out.println("replace: " + b3);
        System.out.println("person: " + person);
        
    }
}
