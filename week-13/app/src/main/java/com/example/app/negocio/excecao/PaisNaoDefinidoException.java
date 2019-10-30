package com.example.app.negocio.excecao;

public class PaisNaoDefinidoException extends Exception {

    public PaisNaoDefinidoException() {
        super("País não pode ser nulo/vazio");
    }
    
}
