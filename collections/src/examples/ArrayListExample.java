package examples;

import models.Student;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // List is an interface
        List<Student> students = new ArrayList<>();

        students.add(new Student("John", 90));
        students.add(new Student("Jane", 80));
        students.add(new Student("Doe", 70));
        students.add(2, new Student("Smith", 60));
        students.set(3, new Student("Doe", 50));

        System.out.println("size: " + students.size());

        //remove
        students.remove(new Student("Doe", 50));

        System.out.println("size: " + students.size());

        boolean b = students.contains(new Student("Jane", 80));
        System.out.println("contains: " + b);

        Object a[] = students.toArray();
        for (int i = 0; i < a.length; i++) {
            {
                System.out.println("ARRAY: " + a[i]);
            }
        }

    }

}
