package br.edu.utfpr.cp.sa.appclientepais.negocio;

import br.edu.utfpr.cp.sa.appclientepais.negocio.excecao.ObjetoJaExisteException;
import java.util.Set;

interface INegocio<T> {
    
    void incluir(T objeto) throws ObjetoJaExisteException;
    Set<T> listar();
    
}
