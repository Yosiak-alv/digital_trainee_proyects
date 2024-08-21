package com.digital.springrepo_service_controller.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class IsRequiredValidation implements ConstraintValidator<IsRequired, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //return value != null && !value.isEmpty() && !value.isBlank();
        return StringUtils.hasText(value);
    }
}
