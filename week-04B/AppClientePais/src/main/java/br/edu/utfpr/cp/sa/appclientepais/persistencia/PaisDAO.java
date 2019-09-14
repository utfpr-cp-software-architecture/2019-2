package br.edu.utfpr.cp.sa.appclientepais.persistencia;

import br.edu.utfpr.cp.sa.appclientepais.negocio.dominio.Pais;
import br.edu.utfpr.cp.sa.appclientepais.negocio.dominio.SiglaPais;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import lombok.extern.java.Log;

@Log
public class PaisDAO extends TemplateDAO<Pais> {

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

    public Pais listar(int id) {
        return this.listar().stream().filter(p -> p.getId() == id).findAny().get();
    }

    @Override
    protected String getStringSQLIncluir() {
        return "INSERT INTO pais (nome, siglapais) VALUES (?, ?)";
    }

    @Override
    protected void ormIncluir(PreparedStatement statement, Pais objeto) throws SQLException {
        statement.setString(1, objeto.getNome());
        statement.setString(2, objeto.getSigla().toString());
    }

    @Override
    protected String getStringSQLListar() {
        return "SELECT * FROM pais";
    }

    @Override
    protected void ormListar(ResultSet result, Set<Pais> resultado) throws SQLException {
        Pais paisAtual = null;

        while (result.next()) {
            paisAtual = new Pais(
                    result.getInt("id"),
                    result.getString("nome"),
                    SiglaPais.valueOf(result.getString("siglapais")));

            resultado.add(paisAtual);
        }
    }

    @Override
    protected String getStringSQLExcluir() {
        return "DELETE FROM pais WHERE id=?";
    }

    @Override
    protected String getStringSQLAlterar() {
        return "UPDATE pais SET nome=?, siglapais=? WHERE id=?";
    }

    @Override
    protected void ormAlterar(PreparedStatement statement, Pais objeto) throws SQLException {
        statement.setString(1, objeto.getNome());
        statement.setString(2, objeto.getSigla().toString());
        statement.setInt(3, objeto.getId());

    }
}
