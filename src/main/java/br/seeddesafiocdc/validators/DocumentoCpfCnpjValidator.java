package br.seeddesafiocdc.validators;

import br.seeddesafiocdc.dto.CompraRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DocumentoCpfCnpjValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CompraRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()) return;

        CompraRequest compraRequest = (CompraRequest) target;

        if(!compraRequest.temDocumentoValido()) {
            errors.reject("documento.invalido", "Documento está invalido");
        }
    }
}
