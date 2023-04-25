package br.seeddesafiocdc.controlador;

import br.seeddesafiocdc.dto.LivroDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livro")
public class LivroControlador {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String criaLivro(@RequestBody @Valid LivroDto livroDto) {

        entityManager.persist(livroDto.paraEntidade(entityManager));
        return "Livro criado";
    }
}
