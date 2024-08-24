package com.digital.spring_architecture_test.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

public class NotEmptyArrayValidator implements ConstraintValidator<NotEmptyArray, Object[]> {
    @Override
    public boolean isValid(Object[] array, ConstraintValidatorContext context) {
        return array != null && array.length > 0 && array[0] != null;
    }
}
