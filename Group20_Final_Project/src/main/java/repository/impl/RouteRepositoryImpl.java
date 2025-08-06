package repository.impl;

import config.DatabaseManager;
import entities.Route;
import repository.IRouteRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC implementation for Route repository.
 * 
 * author Sarthak
 */
public class RouteRepositoryImpl implements IRouteRepository {

    @Override
    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        String sql = "SELECT * FROM fleet_routes";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                routes.add(new Route(rs.getInt("id"), rs.getString("code"), rs.getString("details")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return routes;
    }

    @Override
    public Route getRouteById(int id) {
        String sql = "SELECT * FROM fleet_routes WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Route(rs.getInt("id"), rs.getString("code"), rs.getString("details"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public boolean addRoute(Route route) {
        String sql = "INSERT INTO fleet_routes(code, details) VALUES(?,?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, route.getCode());
            ps.setString(2, route.getDetails());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean updateRoute(Route route) {
        String sql = "UPDATE fleet_routes SET code=?, details=? WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, route.getCode());
            ps.setString(2, route.getDetails());
            ps.setInt(3, route.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean deleteRoute(int id) {
        String sql = "DELETE FROM fleet_routes WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}
