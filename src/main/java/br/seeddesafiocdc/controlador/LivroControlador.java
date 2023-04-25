package br.seeddesafiocdc.controlador;

import br.seeddesafiocdc.dto.LivroDto;
import br.seeddesafiocdc.dto.LivroIdTituloDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/lista")
    public List<LivroIdTituloDto> listaLivro() {
        List<Object[]> resultList = entityManager.createQuery("select (id, titulo) from livro").getResultList();
        List<LivroIdTituloDto> response = new ArrayList<>();

        for (Object[] infoLivro : resultList) {
            response.add(new LivroIdTituloDto((Long)infoLivro[0], (String)infoLivro[1]));
        }

        return response;
    }
}
