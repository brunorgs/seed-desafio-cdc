package br.seeddesafiocdc.validators;

import br.seeddesafiocdc.dto.CompraRequest;
import br.seeddesafiocdc.entidade.Pais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EstadoValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return CompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()) return;

        CompraRequest compraRequest = (CompraRequest) target;

        Query query = entityManager.createQuery("select (pais) from estado where id=:value");
        query.setParameter("value", compraRequest.getEstadoId());

        Pais result = (Pais) query.getSingleResult();

        if(!compraRequest.getPaisId().equals(result.getId())) {
            errors.reject("estado.naoPertencePais", "Estado não pertence ao País informado");
        }
    }
}
