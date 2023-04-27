package br.seeddesafiocdc.controlador;

import br.seeddesafiocdc.dto.CompraRequest;
import br.seeddesafiocdc.validators.EstadoValidator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compra")
public class CompraControlador {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EstadoValidator estadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoValidator);
    }

    @PostMapping
    public String criaCompra(@RequestBody @Valid CompraRequest compraRequest) {
        return null;
    }
}
