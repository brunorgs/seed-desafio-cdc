package br.seeddesafiocdc.dto;

import br.seeddesafiocdc.entidade.Autor;
import br.seeddesafiocdc.validators.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.time.ZonedDateTime;

public class AutorDto {

    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(field = "email", domainClass = Autor.class)
    private String email;

    @NotBlank
    @Length(max = 400)
    private String descricao;

    private ZonedDateTime dataCriacao;

    public AutorDto() {
    }

    public AutorDto(Long id, String nome, String email, String descricao, ZonedDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ZonedDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(ZonedDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Autor paraEntidade() {
        return new Autor(
                this.id,
                this.nome,
                this.email,
                this.descricao,
                this.dataCriacao
        );
    }
}
