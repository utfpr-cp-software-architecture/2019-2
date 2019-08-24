package br.edu.utfpr.cp.sa.appclientepais;

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
