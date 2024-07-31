import app.models.User;
import app.services.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        System.out.println("create users");

        userService.create(new User("josias@example.com", "123456", true));
        userService.create(new User("example@example.com","1234"));
        userService.create(new User("test@test.com","1234", false));

        System.out.println("\nfind user by id");
        System.out.println(userService.findById(1));

        System.out.println("\nfind all users");
        userService.findAll().forEach(System.out::println);

        System.out.println("\nfind all users from index 1 to 2");
        userService.findAll(1, 2).forEach(System.out::println);

        System.out.println("\nfind all users sorted by email");
        userService.findAllSortedBy("email", false).forEach(System.out::println);

        System.out.println("\nupdate user with id");
        userService.update(2, new User("edit@edit.com", "1234", false));
        userService.findAll().forEach(System.out::println);

        System.out.println("\ndelete user with id");
        userService.delete(1);
        userService.findAll().forEach(System.out::println);

        System.out.println("\ncount users");
        System.out.println(userService.count());
    }
}