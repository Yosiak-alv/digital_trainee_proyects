package examples;

import models.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkListExample {
    public static void main(String[] args) {
        // LinkedList have the ability to add elements at the beginning and at the end of the list
        // Better control for adding and removing elements
        LinkedList<Student> students = new LinkedList<>();

        System.out.println("size: " + students.size());
        System.out.println("isEmpty: " + students.isEmpty());

        students.add(new Student("John", 90));
        students.add(new Student("Jane", 80));
        students.add(new Student("Doe", 70));
        students.add(new Student("Smith", 60));
        students.add(new Student("David", 50));

        System.out.println("size: " + students.size());

        students.addFirst(new Student("First", 100));
        students.addLast(new Student("Last", 10));

        System.out.println("size: " + students.size());

        System.out.println("First: " + students.getFirst());
        System.out.println("Last: " + students.getLast());
        System.out.println("index 2: " + students.get(2));

        // remove
        students.removeFirst();
        students.removeLast();

        System.out.println("size: " + students.size());
        students.remove(new Student("Smith", 60));

        System.out.println("size: " + students.size());
        Student luca = new Student("Luca", 100);
        students.add(luca);
        System.out.println("index luca: " + students.indexOf(luca));

        students.remove(2);

        System.out.println("size: " + students.size());
        System.out.println("index of luca: " + students.indexOf(luca));

        students.set(3, new Student("lalo", 50));

        System.out.println("size: " + students.size());

        ListIterator<Student> li = students.listIterator();

        while(li.hasNext()){
            System.out.println("ListIterator: " + li.next());
        }

        System.out.println("======== Previous ========");

        while(li.hasPrevious()){
            System.out.println("ListIterator: " + li.previous());
        }



    }


}
