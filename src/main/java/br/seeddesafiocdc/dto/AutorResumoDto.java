package br.seeddesafiocdc.dto;

import br.seeddesafiocdc.entidade.Autor;

public class AutorResumoDto {

    private Long id;
    private String nome;
    private String descricao;

    public AutorResumoDto(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public static AutorResumoDto paraDto(Autor autor) {
        return new AutorResumoDto(autor.getId(), autor.getNome(), autor.getDescricao());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
