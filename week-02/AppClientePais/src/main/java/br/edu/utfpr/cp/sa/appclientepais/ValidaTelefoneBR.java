package br.edu.utfpr.cp.sa.appclientepais;

public class ValidaTelefoneBR implements IValidaTelefone {
    
    public boolean valida (String telefone) {
        if (telefone.length() == 8)
            return true;
        
        else
            return false;
    }
}
