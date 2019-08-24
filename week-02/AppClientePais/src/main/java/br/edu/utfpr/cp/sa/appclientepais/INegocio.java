package br.edu.utfpr.cp.sa.appclientepais;

import java.util.Set;

interface INegocio<T> {
    
    void incluir(T objeto) throws ObjetoJaExisteException;
    Set<T> listar();
    
}
