package br.seeddesafiocdc.validators;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String attribute;
    private Class<?> tClass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.attribute = constraintAnnotation.field();
        this.tClass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Query query = entityManager.createQuery(String.format("select 1 from %s where %s=:value", tClass.getSimpleName().toLowerCase(), attribute));
        query.setParameter("value", value);

        List resultList = query.getResultList();

        if(resultList.size() > 1) throw new IllegalStateException(String.format("Existe mais de 1 %s com o %s=%s", tClass.getName(), attribute, value));

        return resultList.isEmpty();
    }
}
