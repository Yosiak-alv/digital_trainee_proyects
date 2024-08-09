package setExamples;

import java.util.HashSet;
import java.util.Set;

public class Duplicates2HasSetExample {
    public static void main(String[] args) {
        String[] fishes = {"Shark", "Tuna", "Salmon", "Tuna", "Salmon"};

        Set<String> fishSet = new HashSet<>();
        Set<String> duplicateFishSet = new HashSet<>();
        for (String fish : fishes) {
            if (!fishSet.add(fish)) {
                duplicateFishSet.add(fish);
            }
        }
        fishSet.removeAll(duplicateFishSet);

        System.out.println("uniques " + fishSet);

        System.out.println("duplicates " + duplicateFishSet);
    }
}
