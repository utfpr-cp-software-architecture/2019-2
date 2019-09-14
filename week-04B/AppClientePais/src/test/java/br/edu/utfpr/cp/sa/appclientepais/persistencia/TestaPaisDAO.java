package br.edu.utfpr.cp.sa.appclientepais.persistencia;

import br.edu.utfpr.cp.sa.appclientepais.negocio.dominio.Pais;
import br.edu.utfpr.cp.sa.appclientepais.negocio.dominio.SiglaPais;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestaPaisDAO {

    @Test
    public void testaCriarTabela() {
        assertNotNull(new PaisDAO());
    }

    @Test
    public void testaInserir() {
        var dao = new PaisDAO();

        dao.incluir(new Pais(0, "Brasil", SiglaPais.BR));

        assertTrue(dao.listar().stream().anyMatch(p -> p.getNome().equalsIgnoreCase("Brasil")));
    }

    @Test
    public void testaListar() {
        var dao = new PaisDAO();

        dao.incluir(new Pais(0, "Brasil", SiglaPais.BR));
        dao.incluir(new Pais(0, "EUA", SiglaPais.EUA));
        dao.incluir(new Pais(0, "Japão", SiglaPais.JP));

        assertTrue(dao.listar().size() >= 3);
    }

    @Test
    public void testaExcluir() {
        var dao = new PaisDAO();

        dao.incluir(new Pais(0, "Argentina", SiglaPais.BR));

        var argentina = dao.listar().stream().filter(p -> p.getNome().equalsIgnoreCase("Argentina")).findAny().get();

        dao.excluir(argentina.getId());

        assertFalse(dao.listar().stream().anyMatch(p -> p.getNome().equalsIgnoreCase("Argentina")));
    }

    @Test
    public void testaAlterar() {
        var dao = new PaisDAO();

        dao.incluir(new Pais(0, "Bolivia", SiglaPais.BR));

        var bolivia = dao.listar().stream().filter(p -> p.getNome().equalsIgnoreCase("Bolivia")).findAny().get();

        bolivia.setNome("China");
        
        dao.alterar(bolivia);

        assertFalse(dao.listar().stream().anyMatch(p -> p.getNome().equalsIgnoreCase("Bolivia")));
        assertTrue(dao.listar().stream().anyMatch(p -> p.getNome().equalsIgnoreCase("China")));
    }

}
