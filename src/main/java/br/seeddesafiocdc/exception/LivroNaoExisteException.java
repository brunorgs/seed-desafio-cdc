package br.seeddesafiocdc.exception;

public class LivroNaoExisteException extends RuntimeException {

    private Long livroid;

    public LivroNaoExisteException() {
    }

    public LivroNaoExisteException(Long id) {
        this.livroid = id;
    }

    public Long getLivroid() {
        return livroid;
    }
}
