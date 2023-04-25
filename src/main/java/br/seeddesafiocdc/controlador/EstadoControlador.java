package br.seeddesafiocdc.controlador;

import br.seeddesafiocdc.dto.EstadoRequest;
import br.seeddesafiocdc.entidade.Estado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estado")
public class EstadoControlador {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String criaEstado(@RequestBody @Valid EstadoRequest estadoRequest) {

        Estado estado = estadoRequest.paraEntidade(entityManager);
        entityManager.persist(estado);

        return estado.toString();
    }

}
