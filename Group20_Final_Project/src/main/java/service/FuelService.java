package service;

import entities.FuelLog;
import repository.IFuelLogRepository;
import repository.impl.FuelLogRepositoryImpl;
import service.strategy.CostStrategy;


import java.util.List;

/**
 * Handles business logic for Fuel Logs.
 * Implements Strategy Pattern for fuel cost calculation.
 * 
 * @author Sarthak
 */
public class FuelService {
    private final IFuelLogRepository fuelRepo = new FuelLogRepositoryImpl();

    public List<FuelLog> getLogsByVehicle(int vehicleId) {
        return fuelRepo.getFuelLogsByVehicle(vehicleId);
    }

    public boolean logFuel(FuelLog log) {
        return fuelRepo.addFuelLog(log);
    }

    /**
     * Uses Strategy Pattern to calculate cost.
     */
    public double calculateFuelCost(double distance, double rate, CostStrategy strategy) {
        return strategy.calculateCost(distance, rate);
    }
}
