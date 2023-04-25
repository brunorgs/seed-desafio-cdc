package br.seeddesafiocdc.dto;

import br.seeddesafiocdc.entidade.Pais;
import br.seeddesafiocdc.validators.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(field = "nome", domainClass = Pais.class)
    private String nome;

    public PaisRequest() {
    }


    public Pais paraEntidade() {
        return new Pais(nome);
    }

    public String getNome() {
        return nome;
    }
}
