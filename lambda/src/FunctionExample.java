import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, String> f1 = param -> "Hello " + param;
        System.out.println(f1.apply("world!"));

        Function<String, String> f2 = String::toUpperCase;
        System.out.println(f2.apply("hello world!"));

        BiFunction<String, String, String> f3 = (a, b) -> a.toUpperCase().concat(b.toUpperCase());
        System.out.println(f3.apply("test ", "world!"));

        BiFunction<String, String, Integer> f4 = String::compareTo;

        System.out.println(f4.apply("andres", "benjamin"));

        BiFunction<String, String, String> f5 = String::concat;
        System.out.println(f5.apply("Hello ", "welcome"));
    }
}
