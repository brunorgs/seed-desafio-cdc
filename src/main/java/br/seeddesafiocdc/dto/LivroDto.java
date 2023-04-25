package br.seeddesafiocdc.dto;

import br.seeddesafiocdc.entidade.Autor;
import br.seeddesafiocdc.entidade.Categoria;
import br.seeddesafiocdc.entidade.Livro;
import br.seeddesafiocdc.validators.IdExists;
import br.seeddesafiocdc.validators.UniqueValue;
import jakarta.persistence.EntityManager;
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
    @IdExists(domainClass = Categoria.class)
    private Long categoriaId;

    @NotNull
    @IdExists(domainClass = Autor.class)
    private Long autorId;

    public LivroDto(String titulo, String resumo, String sumario, BigDecimal preco,
                    Integer numeroPaginas, String isbn, Date dataPublicacao, Long categoria, Long autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoria;
        this.autorId = autor;
    }

    public LivroDto() {
    }

    public Livro paraEntidade(EntityManager entityManager) {

        Categoria categoria = entityManager.find(Categoria.class, this.categoriaId);
        Autor autor = entityManager.find(Autor.class, this.autorId);

        return new Livro(
            this.titulo,
            this.resumo,
            this.sumario,
            this.preco,
            this.numeroPaginas,
            this.isbn,
            this.dataPublicacao,
            categoria,
            autor
        );
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
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }
}
