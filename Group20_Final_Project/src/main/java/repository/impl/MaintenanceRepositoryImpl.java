package repository.impl;

import config.DatabaseManager;
import entities.MaintenanceAlert;
import entities.MaintenanceSchedule;
import repository.IMaintenanceRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC implementation for Maintenance repository.
 * 
 * @author Sarthak
 */
public class MaintenanceRepositoryImpl implements IMaintenanceRepository {

    @Override
    public List<MaintenanceAlert> getAllMaintenanceAlerts() {
        List<MaintenanceAlert> alerts = new ArrayList<>();
        String sql = "SELECT * FROM maint_alerts";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) alerts.add(mapAlert(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return alerts;
    }

    @Override
    public List<MaintenanceSchedule> getAllSchedules() {
        List<MaintenanceSchedule> schedules = new ArrayList<>();
        String sql = "SELECT * FROM maint_schedule";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) schedules.add(mapSchedule(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return schedules;
    }

    @Override
    public boolean addAlert(MaintenanceAlert alert) {
        String sql = "INSERT INTO maint_alerts(alert_type_ref, part_ref, alert_date, reported_by, resolved) VALUES(?,?,?,?,?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, alert.getAlertTypeRef());
            ps.setInt(2, alert.getPartRef());
            ps.setString(3, alert.getAlertDate());
            ps.setInt(4, alert.getReportedBy());
            ps.setBoolean(5, alert.isResolved());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean updateAlert(MaintenanceAlert alert) {
        String sql = "UPDATE maint_alerts SET alert_type_ref=?, part_ref=?, alert_date=?, reported_by=?, resolved=? WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, alert.getAlertTypeRef());
            ps.setInt(2, alert.getPartRef());
            ps.setString(3, alert.getAlertDate());
            ps.setInt(4, alert.getReportedBy());
            ps.setBoolean(5, alert.isResolved());
            ps.setInt(6, alert.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean addSchedule(MaintenanceSchedule schedule) {
        String sql = "INSERT INTO maint_schedule(alert_ref, scheduled_date, notes, cost, completed) VALUES(?,?,?,?,?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, schedule.getAlertRef());
            ps.setString(2, schedule.getScheduledDate());
            ps.setString(3, schedule.getNotes());
            ps.setDouble(4, schedule.getCost());
            ps.setBoolean(5, schedule.isCompleted());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean updateSchedule(MaintenanceSchedule schedule) {
        String sql = "UPDATE maint_schedule SET alert_ref=?, scheduled_date=?, notes=?, cost=?, completed=? WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, schedule.getAlertRef());
            ps.setString(2, schedule.getScheduledDate());
            ps.setString(3, schedule.getNotes());
            ps.setDouble(4, schedule.getCost());
            ps.setBoolean(5, schedule.isCompleted());
            ps.setInt(6, schedule.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    private MaintenanceAlert mapAlert(ResultSet rs) throws SQLException {
        return new MaintenanceAlert(
                rs.getInt("id"),
                rs.getInt("alert_type_ref"),
                rs.getInt("part_ref"),
                rs.getString("alert_date"),
                rs.getInt("reported_by"),
                rs.getBoolean("resolved")
        );
    }

    private MaintenanceSchedule mapSchedule(ResultSet rs) throws SQLException {
        return new MaintenanceSchedule(
                rs.getInt("id"),
                rs.getInt("alert_ref"),
                rs.getString("scheduled_date"),
                rs.getString("notes"),
                rs.getDouble("cost"),
                rs.getBoolean("completed")
        );
    }
}
