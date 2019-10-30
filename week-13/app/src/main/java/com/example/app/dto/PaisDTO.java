package com.example.app.dto;

import com.example.app.apresentacao.PaisModel;
import com.example.app.persistencia.Pais;
import java.util.ArrayList;
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

    public static PaisDTO fromEntity(Pais entidade) {
        return PaisDTO.builder()
                .id(entidade.getId())
                .nome(entidade.getNome())
                .sigla(SiglaPaisDTO.valueOf(entidade.getSigla()))
                .build();
    }
    
    public static HashSet<PaisDTO> fromEntities (List<Pais> entidades) {
        var resultados = new HashSet<PaisDTO>();
        
        for (Pais entidadePaisAtual: entidades)
            resultados.add(PaisDTO.fromEntity(entidadePaisAtual));
        
        return resultados;
    }
    
    public static Pais fromDTO (PaisDTO dto) {
        return Pais.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .sigla(dto.getSigla().toString())
               .build();
    }
    
    public static PaisModel toModel (PaisDTO dto) {
        return PaisModel.builder()
                            .id(dto.getId())
                            .nome(dto.getNome())
                            .sigla(dto.getSigla().toString())
                        .build();
    }
    
    public static List<PaisModel> toModels (Set<PaisDTO> paises) {
        var resultado = new ArrayList<PaisModel>();
        
        for (PaisDTO paisAtual: paises)
            resultado.add(PaisDTO.toModel(paisAtual));
        
        return resultado;
    }
}
