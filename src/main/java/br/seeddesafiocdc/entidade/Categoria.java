package br.seeddesafiocdc.entidade;

import br.seeddesafiocdc.dto.CategoriaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String nome;

    public Categoria(Long id, @NotBlank String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Categoria() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaDto paraDto() {
        return new CategoriaDto(this.id, this.nome);
    }
}
