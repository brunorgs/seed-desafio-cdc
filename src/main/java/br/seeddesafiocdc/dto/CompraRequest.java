package br.seeddesafiocdc.dto;

import br.seeddesafiocdc.entidade.Estado;
import br.seeddesafiocdc.entidade.Pais;
import br.seeddesafiocdc.validators.Documento;
import br.seeddesafiocdc.validators.IdExists;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompraRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @Documento
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @IdExists(domainClass = Pais.class)
    private Long paisId;

    @IdExists(domainClass = Estado.class)
    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public CompraRequest() {
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
