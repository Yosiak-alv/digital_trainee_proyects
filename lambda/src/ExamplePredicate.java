import models.User;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ExamplePredicate {
    public static void main(String[] args) {
        Predicate<Integer> test = number -> number > 10;
        boolean result = test.test(15);
        System.out.println(result);

        Predicate<String> test2 = text -> text.equals("ADMIN");
        System.out.println(test2.test("ADMIN"));

        BiPredicate<String, String> test3 = String::equals;
        System.out.println(test3.test("ADMIN", "ADMIN"));
        BiPredicate<Integer, Integer> test4 = (a, b) -> a > b;
        System.out.println(test4.test(10, 5));

        User a =  new User();
        User b  = new User();

        a.setName("John");
        b.setName("Alvaro");

        BiPredicate<User, User> test5 = (user1, user2) -> user1.getName().equals(user2.getName());
        System.out.println(test5.test(a, b));
    }
}
