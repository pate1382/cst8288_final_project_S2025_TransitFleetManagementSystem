package repository.impl;

import entities.User;
import repository.IUserRepository;
import config.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {

    @Override
    public User authenticate(String email, String password) {
        String sql = "SELECT * FROM system_users WHERE email=? AND passwd=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (conn == null) return null;

            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapUser(rs);
        } catch (Exception e) {
            System.err.println("❌ Login SQL Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        String sql = "INSERT INTO system_users(fullname,email,passwd,role,route_ref) VALUES(?,?,?,?,?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (conn == null) return false;

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            if (user.getRouteRef() <= 0) ps.setNull(5, Types.INTEGER);
            else ps.setInt(5, user.getRouteRef());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("❌ Registration SQL Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM system_users")) {
            if (conn == null) return list;
            while (rs.next()) list.add(mapUser(rs));
        } catch (Exception e) {
            System.err.println("❌ getAllUsers SQL Error: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "UPDATE system_users SET fullname=?,email=?,passwd=?,role=?,route_ref=? WHERE id=?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (conn == null) return false;

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            if (user.getRouteRef() <= 0) ps.setNull(5, Types.INTEGER);
            else ps.setInt(5, user.getRouteRef());
            ps.setInt(6, user.getId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("❌ updateUser SQL Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM system_users WHERE id=?")) {
            if (conn == null) return false;
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("❌ deleteUser SQL Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public User getUserById(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM system_users WHERE id=?")) {
            if (conn == null) return null;
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapUser(rs);
        } catch (Exception e) {
            System.err.println("❌ getUserById SQL Error: " + e.getMessage());
        }
        return null;
    }

    private User mapUser(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setFullname(rs.getString("fullname"));
        u.setEmail(rs.getString("email"));
        u.setPassword(rs.getString("passwd"));
        u.setRole(rs.getString("role"));
        u.setRouteRef(rs.getInt("route_ref"));
        return u;
    }
}
