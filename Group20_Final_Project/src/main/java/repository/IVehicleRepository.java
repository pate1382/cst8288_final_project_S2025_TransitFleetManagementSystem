package repository;

import entities.Vehicle;
import java.util.List;

/**
 * DAO interface for Vehicle operations.
 * 
 * @author Sarthak
 */
public interface IVehicleRepository {
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(int id);
    boolean addVehicle(Vehicle vehicle);
    boolean updateVehicle(Vehicle vehicle);
    boolean deleteVehicle(int id);
}
