package setExamples;

import java.util.HashSet;
import java.util.Set;

public class DuplicateSetExample {
    public static void main(String[] args) {
        String[] fishes = {"Shark", "Tuna", "Salmon", "Tuna", "Salmon"};

        Set<String> fishSet = new HashSet<>();
        for (String fish : fishes) {
            if (!fishSet.add(fish)) {
                System.out.println("Duplicate fish: " + fish);
            }
        }
        System.out.println(+ fishSet.size() + " Fish set with no duplicates: " + fishSet);
    }
}
