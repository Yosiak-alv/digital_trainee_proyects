package com.digital.springJpa.validations;

import com.digital.springJpa.repositories.UserRepository;
import com.digital.springJpa.services.UserService;
import jakarta.validation.ConstraintValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsByUsernameValidator implements ConstraintValidator<ExistsByUsername, String> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String value, jakarta.validation.ConstraintValidatorContext context) {
        return !userService.existsByUsername(value);
    }
}
