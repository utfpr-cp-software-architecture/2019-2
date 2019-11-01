package com.example.app.negocio;

import com.example.app.negocio.dominio.PaisDTO;
import com.example.app.negocio.excecao.ObjetoJaExisteException;
import com.example.app.persistencia.PaisDAO;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaisNegocio implements INegocio<PaisDTO> {

    private final PaisDAO paisDAO;

    @Override
    public void incluir(PaisDTO pais) throws ObjetoJaExisteException {

        if (paisDAO.findByNome(pais.getNome()).isPresent())
            throw new ObjetoJaExisteException();
        
        paisDAO.save(PaisDTO.EntityFromDTO(pais));
    }

    @Override
    public Set<PaisDTO> listar() {
        return PaisDTO.DTOsFromEntities(paisDAO.findAll());
    }
}
