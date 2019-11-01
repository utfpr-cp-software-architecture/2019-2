package com.example.app.negocio;

import com.example.app.negocio.dominio.ClienteDTO;
import com.example.app.negocio.excecao.ObjetoJaExisteException;
import java.util.HashSet;
import java.util.Set;

public class ClienteNegocio implements INegocio<ClienteDTO>{

    private Set<ClienteDTO> lista;

    public ClienteNegocio() {
        lista = new HashSet<>();
    }

    @Override
    public void incluir(ClienteDTO cliente) throws ObjetoJaExisteException {
        if (!lista.add(cliente))
            throw new ObjetoJaExisteException();
    }

    @Override
    public Set<ClienteDTO> listar() {
        return lista;
    }
}
