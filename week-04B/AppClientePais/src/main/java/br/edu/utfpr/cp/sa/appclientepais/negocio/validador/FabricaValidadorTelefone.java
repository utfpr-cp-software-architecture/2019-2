package br.edu.utfpr.cp.sa.appclientepais.negocio.validador;

import br.edu.utfpr.cp.sa.appclientepais.negocio.dominio.SiglaPais;


public interface FabricaValidadorTelefone {
    
    public static IValidaTelefone of (SiglaPais sigla) {
        switch (sigla) {
            case BR: return new ValidaTelefoneBR();
            case JP: return new ValidaTelefoneJP();
            case EUA: return new ValidaTelefoneEUA();
        }
        
        return null;
    }
    
}
