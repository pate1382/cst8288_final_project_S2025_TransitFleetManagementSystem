package repository;

import entities.FuelLog;
import java.util.List;

/**
 * DAO interface for Fuel Log operations.
 * 
 * @author Sarthak
 */
public interface IFuelLogRepository {
    List<FuelLog> getFuelLogsByVehicle(int vehicleId);
    boolean addFuelLog(FuelLog log);
}
