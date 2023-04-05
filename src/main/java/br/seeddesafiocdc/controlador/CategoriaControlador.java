package br.seeddesafiocdc.controlador;

import br.seeddesafiocdc.dto.CategoriaDto;
import br.seeddesafiocdc.entidade.Categoria;
import br.seeddesafiocdc.repositorio.CategoriaRepositorio;
import br.seeddesafiocdc.validators.CategoriaNomeDuplicadoValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaControlador {

    private CategoriaRepositorio categoriaRepositorio;
    private CategoriaNomeDuplicadoValidator categoriaNomeDuplicadoValidator;

    @Autowired
    public CategoriaControlador(CategoriaRepositorio categoriaRepositorio, CategoriaNomeDuplicadoValidator categoriaNomeDuplicadoValidator) {
        this.categoriaRepositorio = categoriaRepositorio;
        this.categoriaNomeDuplicadoValidator = categoriaNomeDuplicadoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(categoriaNomeDuplicadoValidator);
    }

    @PostMapping
    public ResponseEntity<Object> criaCategoria(@RequestBody @Valid CategoriaDto categoriaDto) {
        Categoria categoria = categoriaRepositorio.save(categoriaDto.toModel());
        return new ResponseEntity<>(categoria.paraDto(), HttpStatus.OK);
    }
}
