package br.seeddesafiocdc.controlador;

import br.seeddesafiocdc.dto.AutorDto;
import br.seeddesafiocdc.entidade.Autor;
import br.seeddesafiocdc.repositorio.AutorRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autor")
public class AutorControlador {

    private final AutorRepositorio autorRepositorio;

    @Autowired
    public AutorControlador(AutorRepositorio autorRepositorio) {
        this.autorRepositorio = autorRepositorio;
    }

    @PostMapping
    public ResponseEntity<Object> criaAutor(@RequestBody @Valid AutorDto autorDto) {

        Autor autor = autorDto.paraEntidade();

        Autor autorDB = autorRepositorio.save(autor);

        return new ResponseEntity<>(AutorDto.paraDto(autorDB), HttpStatus.OK);
    }
}
