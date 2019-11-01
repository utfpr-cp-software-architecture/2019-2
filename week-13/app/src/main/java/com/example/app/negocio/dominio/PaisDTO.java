package com.example.app.negocio.dominio;

import com.example.app.apresentacao.PaisModel;
import com.example.app.persistencia.Pais;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class PaisDTO {

    private Long id;

    @EqualsAndHashCode.Include
    private String nome;
    private SiglaPaisDTO sigla;

    public static PaisDTO DTOFromEntity(Pais pais) {
        return PaisDTO.builder()
                .id(pais.getId())
                .nome(pais.getNome())
                .sigla(SiglaPaisDTO.valueOf(pais.getSigla()))
                .build();
    }
    
    public static Set<PaisDTO> DTOsFromEntities(List<Pais> paises) {
        var resultado = new HashSet<PaisDTO>();

        for (Pais paisAtual : paises) 
            resultado.add(PaisDTO.DTOFromEntity(paisAtual));

        return resultado;
    }
    
    public static Pais EntityFromDTO (PaisDTO pais) {
        return Pais.builder()
                .id(pais.getId())
                .nome(pais.getNome())
                .sigla(pais.getSigla().toString())
               .build();
    }
    
    public static Set<PaisModel> ModelsFromDTOs (Set<PaisDTO> paises) {
        var resultado = new HashSet<PaisModel>();
        
        for (PaisDTO paisAtual: paises)
            resultado.add(PaisDTO.ModelFromDTO(paisAtual));
        
        return resultado;
    }
    
    public static PaisModel ModelFromDTO (PaisDTO pais) {
        return PaisModel.builder()
                    .id(pais.getId())
                    .nome(pais.getNome())
                    .sigla(pais.getSigla().toString())
                    .build();
    }
    
    public static PaisDTO DTOFromModel (PaisModel pais) {
        return PaisDTO.builder()
                .id(pais.getId())
                .nome(pais.getNome())
                .sigla(SiglaPaisDTO.valueOf(pais.getSigla()))
                .build();
    } 
}
