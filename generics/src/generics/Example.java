package generics;

import poo.models.Client;
import poo.models.ClientPremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();

        clients.add(new Client("John", "Doe"));

        Client andres = clients.iterator().next();

        Client[] clientsArray = {
                new Client("John2", "Doe"),
                new Client("Alice", "Doe")
        };

        Integer[] numbersArray = {1, 2, 3};

        List<Client> clientsList = fromArrayToList(clientsArray);
        List<Integer> numbersList = fromArrayToList(numbersArray);

        clientsList.forEach(System.out::println);
        numbersList.forEach(System.out::println);

        List<String> names = fromArrayToList(new String[]{"Tom", "John", "Alice"}, numbersArray);
        names.forEach(System.out::println);

        List<ClientPremium> clientsPremium = fromArrayToList(
                new ClientPremium[]{new ClientPremium("Josias", "Doe")});

        printClient(clients);
        printClient(clientsList);
        printClient(clientsPremium);

        System.out.println("The max of 1, 9 , 4: " + maximo(1, 9, 4));
        System.out.println("The max of 3.9, 11.6, 7.78: " + maximo(3.9, 11.6, 7.78));
        System.out.println("The max of zanahorias, arandanos, manzanas: " + maximo("zanahorias", "arandanos", "manzanas"));

    }
    public static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.asList(a);
    }
    public static <T extends Number> List<T> fromArrayToList(T[] a) {
        return Arrays.asList(a);
    }
    public static <T extends Client & Comparable<T> > List<T> fromArrayToList(T[] a) {
        return Arrays.asList(a);
    }
    public static <T,G> List<T> fromArrayToList(T[] a, G[] b) {
        for (G element : b) {
            System.out.println(element);
        }
        return Arrays.asList(a);
    }
    public static void printClient(List<? extends Client> clients) {
        clients.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if(b.compareTo(max) > 0) {
            max = b;
        }
        if(c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}


