package br.edu.utfpr.cp.sa.appclientepais;

public class ValidaTelefoneEUA implements IValidaTelefone {
    
    public boolean valida (String telefone) {
        if (telefone.length() == 3)
            return true;
        
        else
            return false;
    }
}
