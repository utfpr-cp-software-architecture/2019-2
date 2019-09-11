package br.edu.utfpr.cp.sa.appclientepais.persistencia;

import br.edu.utfpr.cp.sa.appclientepais.negocio.dominio.Pais;
import br.edu.utfpr.cp.sa.appclientepais.negocio.dominio.SiglaPais;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.java.Log;

@Log
public class PaisDAO {

    public PaisDAO() {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            log.info("Criando tabela pais ...");
            conn.createStatement().executeUpdate(
                    "CREATE TABLE pais ("
                    + "id int NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT id_pais_pk PRIMARY KEY,"
                    + "nome varchar(255),"
                    + "siglapais varchar(3))");

            log.info("Tabela criada com sucesso!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void incluir(Pais pais) {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            String sql = "INSERT INTO pais (nome, siglapais) VALUES (?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, pais.getNome());
            statement.setString(2, pais.getSigla().toString());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                log.info("Dados inseridos: " + pais);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Set<Pais> listar() {
        
        var resultado = new HashSet<Pais>();

        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {
            
            String sql = "SELECT * FROM pais";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            Pais paisAtual = null;
            
            while (result.next()) {
                paisAtual = new Pais(
                        result.getInt("id"), 
                        result.getString("nome"), 
                        SiglaPais.valueOf(result.getString("siglapais")));
                        
                resultado.add(paisAtual);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return resultado;

    }

    public Pais listar (int id) {
        return this.listar().stream().filter(p -> p.getId() == id).findAny().get();
    }
}
