package com.digital.springJpa.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistsByUsernameValidator.class)
public @interface ExistsByUsername {
    String message() default "Record already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
