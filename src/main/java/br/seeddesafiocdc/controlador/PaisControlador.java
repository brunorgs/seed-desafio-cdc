package br.seeddesafiocdc.controlador;

import br.seeddesafiocdc.dto.PaisRequest;
import br.seeddesafiocdc.entidade.Pais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pais")
public class PaisControlador {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String criaPais(@RequestBody @Valid PaisRequest paisRequest) {

        Pais pais = paisRequest.paraEntidade();
        entityManager.persist(pais);

        return pais.toString();
    }
}
