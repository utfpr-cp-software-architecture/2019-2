package com.example.app.servico;

import com.example.app.dto.PaisDTO;
import com.example.app.negocio.PaisNegocio;
import com.example.app.negocio.excecao.ObjetoJaExisteException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PaisServico {
    
    private final PaisNegocio paisNegocio;
    
    @GetMapping ("/servico/pais")
    public ResponseEntity<Set<PaisDTO>> listar() {
        
        if (paisNegocio.listar().size() == 0)
            return ResponseEntity.noContent().build();
        
        else
            return ResponseEntity.ok(paisNegocio.listar());
    }
    
    @PostMapping ("/servico/pais")
    public ResponseEntity<PaisDTO> criar (@RequestBody PaisDTO pais) {
        
        try {
            paisNegocio.incluir(pais);
            
            return ResponseEntity.status(201).body(paisNegocio.listar().stream()
                    .filter(p -> p.getNome().equalsIgnoreCase(pais.getNome()))
                    .findAny()
                    .get());
                                
        } catch (ObjetoJaExisteException ex) {
            Logger.getLogger(PaisServico.class.getName()).log(Level.SEVERE, null, ex);
            
            return ResponseEntity.badRequest().build();
        }
        
    }
    
}
