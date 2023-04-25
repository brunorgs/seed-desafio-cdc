package br.seeddesafiocdc.dto;

import br.seeddesafiocdc.entidade.Livro;

import java.math.BigDecimal;
import java.util.Date;

public class DetalheLivroDto {

    private Long id;

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private Integer numeroPaginas;

    private String isbn;

    private Date dataPublicacao;

    private AutorResumoDto autorDto;

    public DetalheLivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autorDto = AutorResumoDto.paraDto(livro.getAutor());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorResumoDto getAutorDto() {
        return autorDto;
    }
}
