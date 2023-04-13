package br.seeddesafiocdc.repositorio;

import br.seeddesafiocdc.entidade.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {
}
