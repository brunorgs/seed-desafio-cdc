package br.seeddesafiocdc.repositorio;

import br.seeddesafiocdc.entidade.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);
}
