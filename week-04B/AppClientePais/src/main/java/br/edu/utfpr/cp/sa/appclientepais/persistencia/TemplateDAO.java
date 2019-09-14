package br.edu.utfpr.cp.sa.appclientepais.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public abstract class TemplateDAO<T> {

    protected abstract String getStringSQLIncluir();

    protected abstract void ormIncluir(PreparedStatement statement, T objeto) throws SQLException;

    public final void incluir(T objeto) {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            String sql = getStringSQLIncluir();

            PreparedStatement statement = conn.prepareStatement(sql);
            ormIncluir(statement, objeto);

            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected abstract String getStringSQLListar();

    protected abstract void ormListar(ResultSet result, Set<T> resultado) throws SQLException;

    public final Set<T> listar() {

        var resultado = new HashSet<T>();

        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            String sql = getStringSQLListar();

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            ormListar(result, resultado);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    protected abstract String getStringSQLExcluir();

    public final void excluir(int id) {

        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            String sql = getStringSQLExcluir();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    protected abstract String getStringSQLAlterar();
    protected abstract void ormAlterar(PreparedStatement statement, T objeto) throws SQLException;

    public final void alterar(T objeto) {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            String sql = getStringSQLAlterar();

            PreparedStatement statement = conn.prepareStatement(sql);
            ormAlterar(statement, objeto);
            
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
