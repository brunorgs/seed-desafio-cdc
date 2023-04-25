package br.seeddesafiocdc.controlador;

import br.seeddesafiocdc.dto.DetalheLivroDto;
import br.seeddesafiocdc.entidade.Livro;
import br.seeddesafiocdc.exception.LivroNaoExisteException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livro/detalhe")
public class DetalheLivroControlador {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public DetalheLivroDto obtemLivro(@RequestParam("id") Long id) {

        Livro livroDb = entityManager.find(Livro.class, id);

        if(livroDb == null) throw new LivroNaoExisteException(id);

        return new DetalheLivroDto(livroDb);
    }
}
