package br.seeddesafiocdc.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "estado")
public class Estado {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String nome;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Pais pais;

    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }
}
