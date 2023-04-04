package br.seeddesafiocdc.controlador;

import br.seeddesafiocdc.dto.AutorDto;
import br.seeddesafiocdc.entidade.Autor;
import br.seeddesafiocdc.repositorio.AutorRepositorio;
import br.seeddesafiocdc.validators.EmailDuplicadoValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autor")
public class AutorControlador {

    private final AutorRepositorio autorRepositorio;
    private final EmailDuplicadoValidator emailDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(emailDuplicadoValidator);
    }

    @Autowired
    public AutorControlador(AutorRepositorio autorRepositorio, EmailDuplicadoValidator emailDuplicadoValidator) {
        this.autorRepositorio = autorRepositorio;
        this.emailDuplicadoValidator = emailDuplicadoValidator;
    }

    @PostMapping
    public ResponseEntity<Object> criaAutor(@RequestBody @Valid AutorDto autorDto) {

        Autor autor = autorDto.paraEntidade();

        Autor autorDB = autorRepositorio.save(autor);

        return new ResponseEntity<>(autorDB.paraDto(), HttpStatus.OK);
    }
}
