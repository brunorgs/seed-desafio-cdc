package br.seeddesafiocdc.dto;

import java.util.List;

public class ErroValidacaoDto {

    private List<String> mensagens;

    public ErroValidacaoDto(List<String> mensagem) {
        this.mensagens = mensagem;
    }

    public List<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<String> mensagens) {
        this.mensagens = mensagens;
    }
}
