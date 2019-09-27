package br.edu.utfpr.dv.siacoes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class TemplateDAO<T> {

    protected abstract String getStringSQLFind();

    public final T findByDepartment(int idDepartment) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionDAO.getInstance().getConnection();
            stmt = conn.prepareStatement(getStringSQLFind());

            stmt.setInt(1, idDepartment);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return this.loadObject(rs);
            } else {
                return null;
            }
        } finally {
            if ((rs != null) && !rs.isClosed()) {
                rs.close();
            }
            if ((stmt != null) && !stmt.isClosed()) {
                stmt.close();
            }
            if ((conn != null) && !conn.isClosed()) {
                conn.close();
            }
        }

    }

    protected abstract int getDepartmentId(T config);
    
    protected abstract String getStringSQLInsert();
    protected abstract String getStringSQLUpdate();
    
    protected abstract void ormSave (PreparedStatement stmt, T config) throws SQLException;
    
    public final int save(T config) throws SQLException {
        boolean insert = (this.findByDepartment(getDepartmentId(config)) == null);
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionDAO.getInstance().getConnection();

            if (insert) {
                stmt = conn.prepareStatement(getStringSQLInsert());
            } else {
                stmt = conn.prepareStatement(getStringSQLUpdate());
            }
            
            ormSave (stmt, config);
            
            stmt.execute();

            return getDepartmentId();
        } finally {
            if ((stmt != null) && !stmt.isClosed()) {
                stmt.close();
            }
            if ((conn != null) && !conn.isClosed()) {
                conn.close();
            }
        }
    }

    protected abstract T loadObject(ResultSet rs) throws SQLException;
}
