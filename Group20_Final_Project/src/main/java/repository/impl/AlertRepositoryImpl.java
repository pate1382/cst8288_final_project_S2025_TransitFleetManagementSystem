package repository.impl;

import config.DatabaseManager;
import entities.AlertType;
import repository.IAlertRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC implementation for AlertType repository.
 * 
 * author Sarthak
 */
public class AlertRepositoryImpl implements IAlertRepository {

    @Override
    public List<AlertType> getAllAlertTypes() {
        List<AlertType> types = new ArrayList<>();
        String sql = "SELECT * FROM maint_alert_types";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) types.add(mapType(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return types;
    }

    @Override
    public AlertType getAlertTypeById(int id) {
        String sql = "SELECT * FROM maint_alert_types WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapType(rs);
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    private AlertType mapType(ResultSet rs) throws SQLException {
        return new AlertType(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description")
        );
    }
}
