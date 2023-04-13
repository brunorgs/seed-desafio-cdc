package br.seeddesafiocdc.dto;

import br.seeddesafiocdc.entidade.Categoria;
import br.seeddesafiocdc.validators.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class CategoriaDto {

    private Long id;

    @NotBlank
    @UniqueValue(domainClass=Categoria.class, field = "nome")
    private String nome;

    public CategoriaDto(Long id, @NotBlank String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toModel(){
        return new Categoria(this.id, this.nome);
    }
}
