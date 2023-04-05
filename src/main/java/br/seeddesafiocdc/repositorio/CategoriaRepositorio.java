package br.seeddesafiocdc.repositorio;

import br.seeddesafiocdc.entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNome(String nome);
}
