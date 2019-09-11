package br.edu.utfpr.cp.sa.appclientepais.negocio.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Pais {
    
    private int id;
    
    @EqualsAndHashCode.Include
    private String nome;
    private SiglaPais sigla;
}
