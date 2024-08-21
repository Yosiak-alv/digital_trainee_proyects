package com.digital.springrepo_service_controller.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsRequiredValidation.class)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD, ElementType.METHOD})
public @interface IsRequired {
    String message() default "Field is required";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
