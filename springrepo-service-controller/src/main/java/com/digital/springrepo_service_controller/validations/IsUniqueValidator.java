package com.digital.springrepo_service_controller.validations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IsUniqueValidator implements ConstraintValidator<IsUnique, Object> {
    @Autowired
    private EntityManager entityManager;

    private String fieldName;
    private Class<?> domainClass;

    @Override
    public void initialize(IsUnique constraintAnnotation) {
        this.fieldName = constraintAnnotation.fieldName();
        this.domainClass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        String queryStr = String.format("SELECT COUNT(e) FROM %s e WHERE e.%s = :value",
                domainClass.getSimpleName(), fieldName);
        Query query = entityManager.createQuery(queryStr);
        query.setParameter("value", value);

        Long count = (Long) query.getSingleResult();

        return count == 0;
    }
}
