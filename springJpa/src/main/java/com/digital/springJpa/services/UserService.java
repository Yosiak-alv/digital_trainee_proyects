package com.digital.springJpa.services;

import com.digital.springJpa.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    User save(User user);
    boolean findByUsername(String username);
}
