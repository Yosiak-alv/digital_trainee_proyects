package com.digital.springrepo_service_controller;

import com.digital.springrepo_service_controller.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name",null, "es requerido!");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"descripcion", "NotBlank.product.description");
        if(product.getDescription() == null || product.getDescription().isBlank()){
            errors.rejectValue("description", null, "es requerido!, por favor");
        }

        if (product.getPrice() == null) {
            errors.rejectValue("price", null, "No puede ser nulo");
        } else if (product.getPrice() <= 500) {
            errors.rejectValue("price", null, "debe ser mayor o igual que 500");
        }
    }
}
