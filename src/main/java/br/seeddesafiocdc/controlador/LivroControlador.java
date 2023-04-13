package br.seeddesafiocdc.controlador;

import br.seeddesafiocdc.dto.LivroDto;
import br.seeddesafiocdc.entidade.Livro;
import br.seeddesafiocdc.repositorio.LivroRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livro")
public class LivroControlador {

    private LivroRepositorio livroRepositorio;

    @Autowired
    public LivroControlador(LivroRepositorio livroRepositorio) {
        this.livroRepositorio = livroRepositorio;
    }

    @PostMapping
    public ResponseEntity<Object> criaLivro(@RequestBody @Valid LivroDto livroDto) {

        Livro livro = livroRepositorio.save(livroDto.paraEntidade());

        return new ResponseEntity<>(livro.paraDto(), HttpStatus.OK);
    }
}
