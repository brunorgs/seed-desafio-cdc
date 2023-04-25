package br.seeddesafiocdc.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;
import java.util.Date;


@Entity(name = "livro")
public class Livro {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String resumo;

    private String sumario;

    @Min(20)
    @Column(nullable = false)
    private BigDecimal preco;

    @Min(100)
    @Column(nullable = false)
    private Integer numeroPaginas;

    @Column(nullable = false)
    private String isbn;

    @Future
    private Date dataPublicacao;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Categoria categoria;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Autor autor;

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco,
                 Integer numeroPaginas, String isbn, Date dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Livro() {
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

    public Long getCategoriaId() {
        return categoria.getId();
    }

    public Long getAutorId() {
        return autor.getId();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
