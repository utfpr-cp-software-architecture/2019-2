package com.example.app.negocio.validador;

public class ValidaTelefoneJP implements IValidaTelefone {

    @Override
    public boolean valida(String telefone) {
        if (telefone.length() == 2)
            return true;
        
        else 
            return false;
    }
}
