package br.edu.utfpr.cp.sa.appclientepais.negocio.validador;

public class ValidaTelefoneJP implements IValidaTelefone {

    @Override
    public boolean valida(String telefone) {
        if (telefone.length() == 2)
            return true;
        
        else 
            return false;
    }
}
