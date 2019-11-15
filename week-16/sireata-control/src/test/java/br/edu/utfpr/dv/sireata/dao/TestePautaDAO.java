package br.edu.utfpr.dv.sireata.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import br.edu.utfpr.dv.sireata.model.Ata;
import br.edu.utfpr.dv.sireata.model.Pauta;

public class TestePautaDAO {
    
    @Test
    public void testaSalvar() throws SQLException {
        Pauta pauta = new Pauta();
        pauta.setAta(new Ata());
        pauta.setDescricao("descrição");
        pauta.setOrdem(10);
        pauta.setTitulo("titulo");
        
        PautaDAO dao = new PautaDAO();

        int id = dao.salvar(pauta);

        assertEquals(pauta.getDescricao(), dao.buscarPorId(id).getDescricao());
    }

    @Test
    public void testaExcluir() throws SQLException {
        Pauta pauta = new Pauta();
        pauta.setAta(new Ata());
        pauta.setDescricao("descrição");
        pauta.setOrdem(10);
        pauta.setTitulo("titulo");
        
        PautaDAO dao = new PautaDAO();

        int id = dao.salvar(pauta);

        assertEquals(pauta.getDescricao(), dao.buscarPorId(id).getDescricao());

        dao.excluir(id);

        assertNull(dao.buscarPorId(id));
    }

    @Test
    public void testaBuscarPorId() throws SQLException {
        Pauta pauta = new Pauta();
        pauta.setAta(new Ata());
        pauta.setDescricao("descrição");
        pauta.setOrdem(10);
        pauta.setTitulo("titulo");
        
        PautaDAO dao = new PautaDAO();

        int id = dao.salvar(pauta);

        assertEquals(pauta.getDescricao(), dao.buscarPorId(id).getDescricao());
    }


    @Test
    public void testaListarPorAta() throws SQLException {
        Pauta pauta = new Pauta();
        pauta.setAta(new Ata());
        pauta.setDescricao("descrição");
        pauta.setOrdem(10);
        pauta.setTitulo("titulo");
        
        PautaDAO dao = new PautaDAO();

        int id = dao.salvar(pauta);

        assertTrue(dao.listarPorAta(0).size() > 0);
    }
    
}