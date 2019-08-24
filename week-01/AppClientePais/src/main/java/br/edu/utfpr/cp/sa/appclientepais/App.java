package br.edu.utfpr.cp.sa.appclientepais;

public class App {
    
    public static void main(String[] args) {
        
        var cliente1 = new Cliente();
//        cliente.incluir("John Doe", 27, "123", 129.0, "Brasil");
        cliente1.nome = "John Doe";
        cliente1.idade = 27;
        cliente1.telefone = "123";
        cliente1.limiteCredito = 129.0;
        cliente1.nomePais = "Brasil";
        
        cliente1.incluir (cliente1);
        
        
//        cliente.incluir("Anna Doe", 32, "54654", 500.0, "Brasil");
        
        cliente1.listar().forEach(System.out::println);
    }
    
}
