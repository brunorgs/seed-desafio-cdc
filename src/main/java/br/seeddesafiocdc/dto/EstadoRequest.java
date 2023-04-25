package br.seeddesafiocdc.dto;

import br.seeddesafiocdc.entidade.Estado;
import br.seeddesafiocdc.entidade.Pais;
import br.seeddesafiocdc.validators.IdExists;
import br.seeddesafiocdc.validators.UniqueValue;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    @UniqueValue(field = "nome", domainClass = Estado.class)
    private String nome;

    @NotNull
    @IdExists(domainClass = Pais.class)
    private Long paisId;


    public EstadoRequest(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public EstadoRequest() {
    }

    public Estado paraEntidade(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, this.paisId);

        return new Estado(this.nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
