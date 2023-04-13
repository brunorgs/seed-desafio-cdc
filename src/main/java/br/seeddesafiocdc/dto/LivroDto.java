package br.seeddesafiocdc.dto;

import br.seeddesafiocdc.entidade.Livro;
import br.seeddesafiocdc.validators.UniqueValue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

import java.util.Date;

public class LivroDto {

    @NotBlank
    @UniqueValue(field = "titulo", domainClass = Livro.class)
    private String titulo;

    @NotBlank
    @Length(max = 500)
    private String resumo;

    private String sumario;

    @Min(20)
    @NotNull
    private BigDecimal preco;

    @Min(100)
    @NotNull
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValue(field = "isbn", domainClass = Livro.class)
    private String isbn;

    @Future
    private Date dataPublicacao;

    @NotNull
    private CategoriaDto categoria;

    private AutorDto autor;

    public LivroDto(String titulo, String resumo, String sumario, BigDecimal preco,
                    Integer numeroPaginas, String isbn, Date dataPublicacao, CategoriaDto categoria, AutorDto autor) {
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

    public LivroDto() {
    }

    public Livro paraEntidade() {
        return new Livro(
            this.titulo,
            this.resumo,
            this.sumario,
            this.preco,
            this.numeroPaginas,
            this.isbn,
            this.dataPublicacao,
            this.categoria.toModel(),
            this.autor.paraEntidade()
        );
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoria = categoria;
    }

    public AutorDto getAutor() {
        return autor;
    }

    public void setAutor(AutorDto autor) {
        this.autor = autor;
    }
}
