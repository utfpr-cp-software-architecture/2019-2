package com.example.app.negocio.excecao;

public class ObjetoJaExisteException extends Exception {

    public ObjetoJaExisteException() {
        super("Não é permitido mais de um objeto com o mesmo nome");
    }
    
}
