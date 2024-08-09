import models.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumeExample {
    public static void main(String[] args) {

        Consumer<Date> consumer = (date) -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(sdf.format(date));
        };

        consumer.accept(new Date());

        BiConsumer<String, Integer> consumerBi = (name, age) -> {
            System.out.println(name + " is " + age + " years old.");
        };

        consumerBi.accept("John", 25);

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("Hello world!");

        List<String> names = List.of("John", "Jane", "Jack");
        names.forEach(consumer2);

        Supplier<User> createUser = User::new;
        User user = createUser.get();

        BiConsumer<User, String> setName = User::setName;
        setName.accept(user, "John");

        System.out.println(user.getName());

        Supplier<String> provider = () -> "Hello world from suplier!";
        System.out.println(provider.get());
    }

}
