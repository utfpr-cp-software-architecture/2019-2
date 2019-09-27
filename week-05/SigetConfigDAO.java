package br.edu.utfpr.dv.siacoes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.utfpr.dv.siacoes.model.SigetConfig;
import br.edu.utfpr.dv.siacoes.model.SigetConfig.SupervisorFilter;

public class SigetConfigDAO extends TemplateDAO<SigetConfig> {

    @Override
    protected SigetConfig loadObject(ResultSet rs) throws SQLException {
        SigetConfig config = new SigetConfig();

        config.getDepartment().setIdDepartment(rs.getInt("idDepartment"));
        config.setMinimumScore(rs.getDouble("minimumScore"));
        config.setRegisterProposal(rs.getInt("registerProposal") == 1);
        config.setShowGradesToStudent(rs.getInt("showgradestostudent") == 1);
        config.setSupervisorFilter(SupervisorFilter.valueOf(rs.getInt("supervisorFilter")));
        config.setCosupervisorFilter(SupervisorFilter.valueOf(rs.getInt("cosupervisorFilter")));

        return config;
    }

    @Override
    protected String getStringSQLFind() {
        return "SELECT * FROM sigetconfig WHERE idDepartment = ?";
    }

    @Override
    protected int getDepartmentId(SigetConfig config) {
        return config.getDepartment().getIdDepartment();
    }

    @Override
    protected String getStringSQLInsert() {
        return "INSERT INTO sigetconfig(minimumScore, registerProposal, showgradestostudent, supervisorfilter, cosupervisorfilter, idDepartment) VALUES(?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getStringSQLUpdate() {
        return "UPDATE sigetconfig SET minimumScore=?, registerProposal=?, showgradestostudent=?, supervisorfilter=?, cosupervisorfilter=? WHERE idDepartment=?";
    }

    @Override
    protected void ormSave(PreparedStatement stmt, SigetConfig config) throws SQLException {
        stmt.setDouble(1, config.getMinimumScore());
        stmt.setInt(2, (config.isRegisterProposal() ? 1 : 0));
        stmt.setInt(3, config.isShowGradesToStudent() ? 1 : 0);
        stmt.setInt(4, config.getSupervisorFilter().getValue());
        stmt.setInt(5, config.getCosupervisorFilter().getValue());
        stmt.setInt(6, config.getDepartment().getIdDepartment());

    }

}
