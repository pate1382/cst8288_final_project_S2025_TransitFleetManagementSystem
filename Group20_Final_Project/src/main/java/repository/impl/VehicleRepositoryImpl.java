package repository.impl;

import config.DatabaseManager;
import entities.Vehicle;
import repository.IVehicleRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC implementation for Vehicle repository.
 * 
 * author Sarthak
 */
public class VehicleRepositoryImpl implements IVehicleRepository {

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM fleet_vehicles";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) vehicles.add(mapVehicle(rs));
        } catch (SQLException e) { e.printStackTrace(); }
        return vehicles;
    }

    @Override
    public Vehicle getVehicleById(int id) {
        String sql = "SELECT * FROM fleet_vehicles WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapVehicle(rs);
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO fleet_vehicles(vehicle_code, fuel_rate, max_capacity, fuel_type, assigned_route, seating_capacity) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, vehicle.getVehicleCode());
            ps.setDouble(2, vehicle.getFuelRate());
            ps.setInt(3, vehicle.getMaxCapacity());
            ps.setString(4, vehicle.getFuelType());
            ps.setInt(5, vehicle.getAssignedRoute());
            ps.setInt(6, vehicle.getSeatingCapacity());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE fleet_vehicles SET vehicle_code=?, fuel_rate=?, max_capacity=?, fuel_type=?, assigned_route=?, seating_capacity=? WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, vehicle.getVehicleCode());
            ps.setDouble(2, vehicle.getFuelRate());
            ps.setInt(3, vehicle.getMaxCapacity());
            ps.setString(4, vehicle.getFuelType());
            ps.setInt(5, vehicle.getAssignedRoute());
            ps.setInt(6, vehicle.getSeatingCapacity());
            ps.setInt(7, vehicle.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean deleteVehicle(int id) {
        String sql = "DELETE FROM fleet_vehicles WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    private Vehicle mapVehicle(ResultSet rs) throws SQLException {
        return new Vehicle(
                rs.getInt("id"),
                rs.getString("vehicle_code"),
                rs.getDouble("fuel_rate"),
                rs.getInt("max_capacity"),
                rs.getString("fuel_type"),
                rs.getInt("assigned_route"),
                rs.getInt("seating_capacity")
        );
    }
}
