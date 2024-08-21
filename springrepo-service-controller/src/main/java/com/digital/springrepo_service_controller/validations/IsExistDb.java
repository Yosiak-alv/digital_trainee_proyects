package com.digital.springrepo_service_controller.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,  ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsExistDbValidation.class)
@Documented
public @interface IsExistDb {
    String message() default "Record already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
