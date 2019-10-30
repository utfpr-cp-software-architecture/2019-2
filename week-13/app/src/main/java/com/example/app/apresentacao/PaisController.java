package com.example.app.apresentacao;

import com.example.app.persistencia.PaisDAO;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PaisController {
    
    private final PaisDAO paisDAO;
    
    @GetMapping("/pais")
    public String listar(Model memoria) {
        
        memoria.addAttribute("listaPaises", );
        
        return "pais-view";
    }
    
    @PostMapping("/pais/criar")
    public String criar(PaisModel pais) {
        
        pais.setId(new Long(paises.size() + 1));
        
        paises.add(pais);
        
        return "redirect:/pais";
    }
    
    @GetMapping("/pais/apagar/{id}")
    public String apagar(@PathVariable Long id) {
        
        var pais = buscaPaisPeloId(id);
        
        paises.remove(pais);
        
        return "redirect:/pais";
    }
    
    @GetMapping("/pais/preparaAlterar/{id}")
    public String preparaAlterar (@PathVariable Long id, Model memoria) {
        
        var paisAtual = buscaPaisPeloId(id);
        
        memoria.addAttribute("paisAtual", paisAtual);
        memoria.addAttribute("listaPaises", paises);
        
        return "pais-view";
    }
    
    @PostMapping("/pais/alterar")
    public String alterar(PaisModel pais) {
        
        var paisAtual = buscaPaisPeloId(pais.getId());
        
        paisAtual.setNome(pais.getNome());
        paisAtual.setSigla(pais.getSigla());
        
        return "redirect:/pais";
    }
    
    private PaisModel buscaPaisPeloId (Long id) {
        return paises.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
