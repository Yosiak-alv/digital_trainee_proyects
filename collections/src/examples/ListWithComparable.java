package examples;

import models.Student;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListWithComparable {
    public static void main(String[] args) {
        // List is an interface most typically implemented by ArrayList
        List<Student> students = new LinkedList<>();

        students.add(new Student("John", 90));
        students.add(new Student("Jane", 80));
        students.add(new Student("Doe", 70));
        students.add(new Student("Smith", 60));
        students.add(new Student("David", 50));
        students.add(new Student("Charllton", 50));
        students.add(new Student("Bruce", 50));
        students.add(new Student("Zack", 50));
        students.add(new Student("Alfred", 50));
        students.add(new Student("Diana", 50));

        students.sort(Comparator.comparing(Student::getName).reversed());

        System.out.println(students);

        System.out.println("ITERATE WITH STREAM FOREACH");
        students.forEach(System.out::println);
    }
}
