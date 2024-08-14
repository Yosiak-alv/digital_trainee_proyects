package com.springboot.springmvc.controllers;


import com.springboot.springmvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Antonio", "Moran");
        user.setEmail("antonio@gmail.com");
        model.addAttribute("user", "SpringBoot");
        model.addAttribute("user", user);

        return "details";
    }

    @GetMapping("/List")
    public String list(ModelMap model){
        List<User> users = Arrays.asList(
                new User("Karla", "Jose", "Karla@gmail.com"),
                new User("Juan", "Lopez", "Juan@gmail.com"),
                new User("Marco", "Martel", "Marco@gmail.com"),
                new User("Mateo", "Jose", "Mateo@gmail.com")
        );

        model.addAttribute("users", users);
        model.addAttribute("tittle", "Listado de usuarios");
        return "list";
    }

}
