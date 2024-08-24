package com.digital.spring_architecture_test.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidPaymentTypeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPaymentType {
    String message() default "Payment Type must be CREDIT_CARD, DEBIT_CARD or CASH";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
