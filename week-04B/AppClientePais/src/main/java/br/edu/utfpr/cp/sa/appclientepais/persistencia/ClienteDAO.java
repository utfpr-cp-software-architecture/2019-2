package br.edu.utfpr.cp.sa.appclientepais.persistencia;

import br.edu.utfpr.cp.sa.appclientepais.negocio.dominio.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import lombok.extern.java.Log;

@Log
public class ClienteDAO extends TemplateDAO<Cliente> {

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

    @Override
    protected String getStringSQLIncluir() {
        return "INSERT INTO cliente (nome, telefone, idade, limiteCredito, pais_id) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected void ormIncluir(PreparedStatement statement, Cliente objeto) throws SQLException {
        statement.setString(1, objeto.getNome());
        statement.setString(2, objeto.getTelefone());
        statement.setInt(3, objeto.getIdade());
        statement.setDouble(4, objeto.getLimiteCredito());
        statement.setInt(5, objeto.getPais().getId());
    }

    @Override
    protected String getStringSQLListar() {
        return "SELECT * FROM cliente";
    }

    @Override
    protected void ormListar(ResultSet result, Set<Cliente> resultado) throws SQLException {
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
    }

    @Override
    protected String getStringSQLExcluir() {
        return "DELETE FROM cliente WHERE id=?";
    }

    @Override
    protected String getStringSQLAlterar() {
        return "UPDATE cliente SET nome=?, telefone=?, idade=?, limiteCredito=?, pais_id=? WHERE id=?";
    }

    @Override
    protected void ormAlterar(PreparedStatement statement, Cliente objeto) throws SQLException {
        statement.setString(1, objeto.getNome());
        statement.setString(2, objeto.getTelefone());
        statement.setInt(3, objeto.getIdade());
        statement.setDouble(4, objeto.getLimiteCredito());
        statement.setInt(5, objeto.getPais().getId());
        statement.setInt(6, objeto.getId());
    }
}