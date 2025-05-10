package br.com.fiap.gestao.infra.exception;

public class UniqueException extends RuntimeException {
    public UniqueException(String mensagem) {
        super(mensagem);
    }
}
