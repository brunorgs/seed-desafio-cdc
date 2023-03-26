package br.seeddesafiocdc.entidade;

import br.seeddesafiocdc.dto.AutorDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.time.ZonedDateTime;

@Entity(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = false, length = 400)
    private String descricao;

    @Column(nullable = false)
    private ZonedDateTime dataCriacao;

    public Autor(Long id, String nome, String email, String descricao, ZonedDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    public Autor() {
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

    public AutorDto paraDto() {
        return new AutorDto(
                this.id,
                this.nome,
                this.email,
                this.descricao,
                this.dataCriacao
        );
    }
}
