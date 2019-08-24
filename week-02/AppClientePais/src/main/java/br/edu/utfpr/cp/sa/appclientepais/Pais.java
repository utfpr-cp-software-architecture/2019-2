package br.edu.utfpr.cp.sa.appclientepais;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Pais {
    
    @EqualsAndHashCode.Include
    private String nome;
    private SiglaPais sigla;
}
