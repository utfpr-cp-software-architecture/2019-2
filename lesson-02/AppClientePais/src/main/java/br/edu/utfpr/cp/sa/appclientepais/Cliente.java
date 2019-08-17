package br.edu.utfpr.cp.sa.appclientepais;

import java.util.ArrayList;

public class Cliente {

    String nome;
    int idade;
    String telefone;
    double limiteCredito;
    String nomePais;

    ArrayList<Cliente> lista;

    public Cliente() {
        
        lista = new ArrayList<>();
    }

    public Cliente(String nome, int idade, String telefone, double limiteCredito, String nomePais) {
        this();
        
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.limiteCredito = limiteCredito;
        this.nomePais = nomePais;
    }
    
//    void incluir(String nome,
//            int idade,
//            String telefone,
//            double limiteCredito,
//            String nomePais) {
    
        void incluir (Cliente cliente) {
        
//        lista.add(new Cliente(nome, idade, telefone, limiteCredito, nomePais));
          lista.add(cliente);

    }

    ArrayList<Cliente> listar() {
        return lista;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", idade=" + idade + ", telefone=" + telefone + ", limiteCredito=" + limiteCredito + ", nomePais=" + nomePais + '}';
    }
    
    
    
}
