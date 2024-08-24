package com.digital.spring_architecture_test.common.validation;

import com.digital.spring_architecture_test.enums.PaymentType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class ValidPaymentTypeValidator implements ConstraintValidator<ValidPaymentType, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
       return Arrays.stream(PaymentType.values()).anyMatch(paymentType -> paymentType.name().equals(value));
    }
}
