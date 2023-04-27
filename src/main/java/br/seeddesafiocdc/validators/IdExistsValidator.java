package br.seeddesafiocdc.validators;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class IdExistsValidator implements ConstraintValidator<IdExists, Object> {
    private Class<?> tClass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(IdExists constraintAnnotation) {
        this.tClass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if(value == null) return true;

        Query query = entityManager.createQuery(String.format("select 1 from %s where id=:value", tClass.getSimpleName().toLowerCase()));
        query.setParameter("value", value);

        List resultList = query.getResultList();

        if(resultList.size() > 1) throw new IllegalStateException(String.format("Existe mais de 1 %s com o id=%s", tClass.getName(), value));

        return !resultList.isEmpty();
    }
}
