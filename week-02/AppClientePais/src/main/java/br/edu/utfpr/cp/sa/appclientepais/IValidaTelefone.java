package br.edu.utfpr.cp.sa.appclientepais;

interface IValidaTelefone {
    
    default boolean valida (String telefone) {
        if (telefone.length() == 8)
            return true;
        
        else
            return false;
    }
}
