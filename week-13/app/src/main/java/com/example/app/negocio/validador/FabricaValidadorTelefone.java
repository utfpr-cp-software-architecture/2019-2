package com.example.app.negocio.validador;

import com.example.app.negocio.dominio.SiglaPaisDTO;




public interface FabricaValidadorTelefone {
    
    public static IValidaTelefone of (SiglaPaisDTO sigla) {
        switch (sigla) {
            case BR: return new ValidaTelefoneBR();
            case JP: return new ValidaTelefoneJP();
            case EUA: return new ValidaTelefoneEUA();
        }
        
        return null;
    }
    
}
