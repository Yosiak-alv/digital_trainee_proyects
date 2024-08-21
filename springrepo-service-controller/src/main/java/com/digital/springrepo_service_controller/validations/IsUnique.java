package com.digital.springrepo_service_controller.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsUniqueValidator.class) // Specify the validator class
@Target({ElementType.FIELD, ElementType.METHOD}) // Can be used on fields and methods
@Retention(RetentionPolicy.RUNTIME)

public @interface IsUnique {
    String message() default "The value must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName() default "";

    Class<?> domainClass();
}
