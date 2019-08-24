package br.edu.utfpr.cp.sa.appclientepais;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {
        
        

        try {
            var paisBrasil = new Pais("Brasil", SiglaPais.BR);
            var paisEUA = new Pais("Estados Unidos", SiglaPais.EUA);
            var paisJP = new Pais("Japão", SiglaPais.JP);
        
            var cliente1 = new Cliente();
            cliente1.setNome("John Doe");
            cliente1.setIdade(27);
            cliente1.setPais(paisBrasil);
            cliente1.setTelefone("12312312");

            var cliente2 = new Cliente();
            cliente2.setNome("Ana Doe");
            cliente2.setIdade(32);
            cliente2.setPais(paisJP);
            cliente2.setTelefone("23");

            var clienteNegocio = new ClienteNegocio();
            
            clienteNegocio.incluir(cliente1);
            clienteNegocio.incluir(cliente2);

            clienteNegocio.listar().forEach(System.out::println);

        } catch (NomeMenorCincoCaracteresException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (ObjetoJaExisteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (PaisNaoDefinidoException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (TelefoneNaoCorrespondePaisException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
