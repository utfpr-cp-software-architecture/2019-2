package com.example.app.negocio.dominio;

import com.example.app.negocio.excecao.NomeMenorCincoCaracteresException;
import com.example.app.negocio.excecao.PaisNaoDefinidoException;
import com.example.app.negocio.validador.FabricaValidadorTelefone;
import com.example.app.negocio.validador.TelefoneNaoCorrespondePaisException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClienteDTO {
    
    private int id;

    @EqualsAndHashCode.Include
    private String nome;
    private int idade;
    private String telefone;
    private double limiteCredito;
    private PaisDTO pais;

    public void setIdade(int idade) {
        this.idade = idade;

        if (idade <= 18) {
            this.limiteCredito += 100.0;

        } else if (idade > 18 && idade <= 35) {
            this.limiteCredito += 300.0;

        } else {
            this.limiteCredito += 500.0;
        }
    }

    public void setLimiteCredito(double limiteCredito) {
        throw new UnsupportedOperationException("Não é possível alterar o limite de crédito diretamente");
    }

    public void setPais(PaisDTO pais) throws PaisNaoDefinidoException {

        if (pais == null) {
            if (pais.getNome().length() < 1) {
                throw new PaisNaoDefinidoException();
            }
        }

        this.pais = pais;

        if (pais.getSigla() == SiglaPaisDTO.BR) {
            this.limiteCredito += 100.0;
        }
    }

    public void setNome(String nome) throws NomeMenorCincoCaracteresException {
        if (nome.length() <= 5) {
            throw new NomeMenorCincoCaracteresException();
        } else {
            this.nome = nome;
        }
    }

    public void setTelefone(String telefone) throws TelefoneNaoCorrespondePaisException {
        
        if (FabricaValidadorTelefone.of(this.getPais().getSigla()).valida(telefone))
            this.telefone = telefone;
        
        else
            throw new TelefoneNaoCorrespondePaisException();
    }
}
