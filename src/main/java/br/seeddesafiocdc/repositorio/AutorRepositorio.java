package br.seeddesafiocdc.repositorio;

import br.seeddesafiocdc.entidade.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {
}
