package br.seeddesafiocdc.validators;

import br.seeddesafiocdc.dto.AutorDto;
import br.seeddesafiocdc.entidade.Autor;
import br.seeddesafiocdc.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()) return;

        AutorDto autorDto = (AutorDto) target;

        Optional<Autor> optionalAutor = autorRepositorio.findByEmail(autorDto.getEmail());

        if(optionalAutor.isPresent()) {
            errors.reject("email.duplicado", "Email já existente na base de dados");
        }
    }
}
