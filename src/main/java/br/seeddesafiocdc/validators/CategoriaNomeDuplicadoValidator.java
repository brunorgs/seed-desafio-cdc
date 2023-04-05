package br.seeddesafiocdc.validators;

import br.seeddesafiocdc.dto.CategoriaDto;
import br.seeddesafiocdc.entidade.Categoria;
import br.seeddesafiocdc.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaNomeDuplicadoValidator implements Validator {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()) return;

        CategoriaDto categoriaDto = (CategoriaDto) target;

        Optional<Categoria> categoria = categoriaRepositorio.findByNome(categoriaDto.getNome());

        if(categoria.isPresent()) {
            errors.reject("nome.duplicado", "Ja existe uma categoria na base de dados com esse nome");
        }
    }
}
