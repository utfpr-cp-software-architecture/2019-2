package com.example.app.negocio.validador;

public interface IValidaTelefone {
    
    public default boolean valida (String telefone) {
        if (telefone.length() == 8)
            return true;
        
        else
            return false;
    }
}
