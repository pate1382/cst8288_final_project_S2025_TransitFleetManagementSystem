package repository.impl;

import config.DatabaseManager;
import entities.FuelLog;
import repository.IFuelLogRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC implementation for Fuel Log repository.
 * 
 * author Sarthak
 */
public class FuelLogRepositoryImpl implements IFuelLogRepository {

    @Override
    public List<FuelLog> getFuelLogsByVehicle(int vehicleId) {
        List<FuelLog> logs = new ArrayList<>();
        String sql = "SELECT * FROM fuel_logs WHERE vehicle_ref=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, vehicleId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) logs.add(mapFuelLog(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return logs;
    }

    @Override
    public boolean addFuelLog(FuelLog log) {
        String sql = "INSERT INTO fuel_logs(vehicle_ref, log_date, distance, price_per_unit) VALUES(?,?,?,?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, log.getVehicleRef());
            ps.setString(2, log.getLogDate());
            ps.setDouble(3, log.getDistance());
            ps.setDouble(4, log.getPricePerUnit());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    private FuelLog mapFuelLog(ResultSet rs) throws SQLException {
        return new FuelLog(
                rs.getInt("id"),
                rs.getInt("vehicle_ref"),
                rs.getString("log_date"),
                rs.getDouble("distance"),
                rs.getDouble("price_per_unit")
        );
    }
}
