package setExamples;

import models.Student;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetComparable {
    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>(Comparator.comparing(Student::getQualification).reversed());

        students.add(new Student("John", 10));
        students.add(new Student("Walter", 3));
        students.add(new Student("Jane", 4));
        students.add(new Student("Mary", 5));
        students.add(new Student("Alice", 6));
        students.add(new Student("Bob", 7));
        students.add(new Student("John", 2));

        System.out.println("Students: " + students);

    }
}
