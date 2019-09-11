package br.edu.utfpr.cp.sa.appclientepais.persistencia;

import br.edu.utfpr.cp.sa.appclientepais.negocio.dominio.Cliente;
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
public class ClienteDAO {

    public ClienteDAO() {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            log.info("Criando tabela cliente ...");
            conn.createStatement().executeUpdate(
                    "CREATE TABLE cliente ("
                    + "id int NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT id_cliente_pk PRIMARY KEY,"
                    + "nome varchar(255),"
                    + "telefone varchar(30),"
                    + "idade int,"
                    + "limiteCredito double,"
                    + "pais_id int)");

            log.info("Tabela criada com sucesso!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void incluir(Cliente cliente) {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            String sql = "INSERT INTO cliente (nome, telefone, idade, limiteCredito, pais_id) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getTelefone());
            statement.setInt(3, cliente.getIdade());
            statement.setDouble(4, cliente.getLimiteCredito());
            statement.setInt(5, cliente.getPais().getId());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                log.info("Dados inseridos: " + cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Set<Cliente> listar() {

        var resultado = new HashSet<Cliente>();

        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            String sql = "SELECT * FROM cliente";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            Cliente clienteAtual = null;
            var paisDAO = new PaisDAO();

            while (result.next()) {

                clienteAtual = new Cliente(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getInt("idade"),
                        result.getString("telefone"),
                        result.getDouble("limiteCredito"),
                        paisDAO.listar(result.getInt("pais_id")));

                resultado.add(clienteAtual);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;

    }

}
