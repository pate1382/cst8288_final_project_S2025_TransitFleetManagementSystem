package service;

import entities.Vehicle;
import repository.IVehicleRepository;
import repository.impl.VehicleRepositoryImpl;

import java.util.List;

/**
 * Handles business logic for Vehicles.
 * 
 * author Sarthak
 */
public class VehicleService {
    private final IVehicleRepository vehicleRepo = new VehicleRepositoryImpl();

    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.getAllVehicles();
    }

    public Vehicle getVehicleById(int id) {
        return vehicleRepo.getVehicleById(id);
    }

    public boolean addVehicle(Vehicle vehicle) {
        return vehicleRepo.addVehicle(vehicle);
    }

    public boolean updateVehicle(Vehicle vehicle) {
        return vehicleRepo.updateVehicle(vehicle);
    }

    public boolean deleteVehicle(int id) {
        return vehicleRepo.deleteVehicle(id);
    }
}
