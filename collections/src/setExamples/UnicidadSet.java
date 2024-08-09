package setExamples;

import models.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UnicidadSet {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("John1", 20));
        students.add(new Student("John2", 20));
        students.add(new Student("John3", 20));
        students.add(new Student("John4", 20));
        students.add(new Student("John5", 20));
        students.add(new Student("John6", 20));
        students.add(new Student("John1", 20));

        System.out.println("Students: " + students);


        System.out.println("Iterate with for each");
        for (Student student : students) {
            System.out.println(student.getName());
        }

        System.out.println("Iterate with iterator and while");
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            System.out.println(student.getName());
        }

        System.out.println("Iterate with forEach");
        students.forEach(student -> System.out.println(student.getName()));
    }


}
