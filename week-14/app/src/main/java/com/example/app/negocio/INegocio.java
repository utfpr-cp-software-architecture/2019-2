package com.example.app.negocio;


import com.example.app.negocio.excecao.ObjetoJaExisteException;
import java.util.Set;

interface INegocio<T> {
    
    void incluir(T objeto) throws ObjetoJaExisteException;
    Set<T> listar();
    
}
