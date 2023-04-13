package br.seeddesafiocdc.controlador;

import br.seeddesafiocdc.dto.CategoriaDto;
import br.seeddesafiocdc.entidade.Categoria;
import br.seeddesafiocdc.repositorio.CategoriaRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaControlador {

    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    public CategoriaControlador(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @PostMapping
    public ResponseEntity<Object> criaCategoria(@RequestBody @Valid CategoriaDto categoriaDto) {
        Categoria categoria = categoriaRepositorio.save(categoriaDto.toModel());
        return new ResponseEntity<>(categoria.paraDto(), HttpStatus.OK);
    }
}
