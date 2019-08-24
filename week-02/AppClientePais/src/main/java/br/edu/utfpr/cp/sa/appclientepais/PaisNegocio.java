package br.edu.utfpr.cp.sa.appclientepais;

import java.util.HashSet;
import java.util.Set;

public class PaisNegocio implements INegocio<Pais> {

    private Set<Pais> lista;

    public PaisNegocio() {
        lista = new HashSet<>();
    }

    @Override
    public void incluir(Pais pais) throws ObjetoJaExisteException {
        if (!lista.add(pais)) {
            throw new ObjetoJaExisteException();
        }
    }

    @Override
    public Set<Pais> listar() {
        return lista;
    }
}
