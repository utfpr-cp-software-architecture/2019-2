package br.edu.utfpr.cp.sa.appclientepais.negocio.validador;

public class TelefoneNaoCorrespondePaisException extends Exception {

    public TelefoneNaoCorrespondePaisException() {
        super("O número do telefone precisa ser validado de acordo com o país");
    }
    
}
