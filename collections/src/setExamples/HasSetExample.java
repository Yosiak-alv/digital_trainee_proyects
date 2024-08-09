package setExamples;

import java.util.HashSet;
import java.util.Set;

public class HasSetExample {
    public static void main(String[] args) {
        //ONLY UNIQUE ELEMENTS
        Set<String> hashSet = new HashSet<>();
        System.out.println(hashSet.add("one"));
        System.out.println(hashSet.add("two"));
        System.out.println(hashSet.add("three"));
        System.out.println(hashSet.add("four"));
        System.out.println(hashSet.add("five"));
        System.out.println(hashSet);

        boolean b = hashSet.add("one");
        System.out.println("contains: " + b);
        System.out.println(hashSet);
    }
}
