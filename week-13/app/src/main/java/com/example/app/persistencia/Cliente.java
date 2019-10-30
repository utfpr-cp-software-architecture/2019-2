package com.example.app.persistencia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Cliente implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private String nome;
    private int idade;
    private double limiteCredito;
    private String telefone;

    @ManyToOne
    private Pais pais;
}
