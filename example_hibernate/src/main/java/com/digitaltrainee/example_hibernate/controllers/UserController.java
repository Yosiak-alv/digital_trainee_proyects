package com.digitaltrainee.example_hibernate.controllers;

import com.digitaltrainee.example_hibernate.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users/details")
    public String details(Model model) {
        model.addAttribute("title", "User Details");
        model.addAttribute("user", new User("John", "Doe"));
        return "details";
    }

    @GetMapping("/users")
    public String list(Model model) {
        List<User> users = List.of(
                new User("John", "Doe"),
                new User("Jane", "Doe", "jane@example.com")
        );
        model.addAttribute("users", users);
        return "list";
    }
}
