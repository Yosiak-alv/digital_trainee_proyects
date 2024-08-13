package com.digitaltrainee.example_hibernate.controllers;

import com.digitaltrainee.example_hibernate.models.User;
import com.digitaltrainee.example_hibernate.models.dtos.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserAPIController {

    @GetMapping("/users/details")
    public UserDto details() {
        User user = new User("John", "Doe");
        UserDto userDto = new UserDto();
        userDto.setTitle("User Details");
        userDto.setUser(user);

        return userDto;
    }

    @GetMapping("/users")
    public List<User> list() {

        return List.of(
                new User("John", "Doe"),
                new User("Jane", "Doe")
        );
    }

    @GetMapping(path = "/users/detail-map")
    public Map<String, Object> detailMap() {
        User user = new User("John", "Doe");
        Map<String, Object> map  = new HashMap<>();
        map.put("title", "User Details");
        map.put("user", user);
        return map;
    }
}
