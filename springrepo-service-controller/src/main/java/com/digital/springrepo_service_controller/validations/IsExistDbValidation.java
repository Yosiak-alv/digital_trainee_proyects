package com.digital.springrepo_service_controller.validations;

import com.digital.springrepo_service_controller.repositories.ProductRepository;
import com.digital.springrepo_service_controller.services.ProductService;
import com.digital.springrepo_service_controller.services.ProductServiceImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class IsExistDbValidation implements ConstraintValidator<IsExistDb, String> {

    @Autowired
    private ProductServiceImpl service;

    @Override
    public void initialize(final IsExistDb constraintAnnotation) {

    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return !service.existsBySku(value);
    }
}
