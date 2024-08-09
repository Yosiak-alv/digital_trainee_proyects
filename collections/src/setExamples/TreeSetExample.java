package setExamples;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>((a,b) -> b.compareTo(a));

        treeSet.add("one");
        treeSet.add("two");
        treeSet.add("three");
        treeSet.add("three");
        treeSet.add("four");
        treeSet.add("five");

        System.out.println("TreeSet: " + treeSet);

        Set<Integer> treeSet2 = new TreeSet<>(Comparator.reverseOrder());
        treeSet2.add(1);
        treeSet2.add(2);
        treeSet2.add(3);
        treeSet2.add(4);
        treeSet2.add(5);

        System.out.println("TreeSet2: " + treeSet2);
    }
}
