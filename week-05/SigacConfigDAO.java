package br.edu.utfpr.dv.siacoes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.utfpr.dv.siacoes.model.SigacConfig;

public class SigacConfigDAO extends TemplateDAO<SigacConfig> {

    @Override
    protected SigacConfig loadObject(ResultSet rs) throws SQLException {
        SigacConfig config = new SigacConfig();

        config.getDepartment().setIdDepartment(rs.getInt("idDepartment"));
        config.setMinimumScore(rs.getDouble("minimumScore"));

        return config;
    }

    @Override
    protected String getStringSQLFind() {
        return "SELECT * FROM sigacconfig WHERE idDepartment = ?";
    }

    @Override
    protected int getDepartmentId(SigacConfig config) {
        return config.getDepartment().getIdDepartment();
    }

    @Override
    protected String getStringSQLInsert() {
        return "INSERT INTO sigacconfig(minimumScore, idDepartment) VALUES(?, ?)";
    }

    @Override
    protected String getStringSQLUpdate() {
        return "UPDATE sigacconfig SET minimumScore=? WHERE idDepartment=?";
    }

    @Override
    protected void ormSave(PreparedStatement stmt, SigacConfig config) throws SQLException {
        stmt.setDouble(1, config.getMinimumScore());
        stmt.setInt(2, config.getDepartment().getIdDepartment());
    }
}
