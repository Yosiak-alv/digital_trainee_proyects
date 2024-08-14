package com.springboot.springmvc.controllers;

import com.springboot.springmvc.controllers.dto.UserDto;
import com.springboot.springmvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.*;

@RestController
@RequestMapping(path = "/api")

public class UserRestController {
    @GetMapping (path = "/details")
    public UserDto details(){

        User user = new User("Carlos", "Lopez");

        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTittle("Hola Mundo SpringBoot");

        return userDto;
    }

    @GetMapping (path = "/details-maps")
    public Map<String, Object> detailMaps() {

        User user = new User("Juan", "Perez");
        Map<String, Object> body = new HashMap<>();

        body.put("tittle", "Hola mundo spring boot");
        body.put("User", user);
        return body;
    }

    @GetMapping("/List")
    public List<User> list(){
        User user = new User("Karla", "Jose");
        User user2 = new User("Juan", "Lopez");
        User user3 = new User("Karla", "Martel");

        List<User> users = Arrays.asList(user, user2, user3);

        return users;
    }

}
