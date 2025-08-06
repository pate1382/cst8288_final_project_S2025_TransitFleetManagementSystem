package service;

import entities.MaintenanceAlert;
import entities.FuelLog;

import java.util.List;

/**
 * Provides reports for fuel usage, maintenance, and performance.
 * 
 * @author Sarthak
 */
public class ReportingService {

    public void generateFuelReport(List<FuelLog> logs) {
        System.out.println("=== Fuel Report ===");
        logs.forEach(log -> System.out.println(log));
    }

    public void generateMaintenanceReport(List<MaintenanceAlert> alerts) {
        System.out.println("=== Maintenance Alerts ===");
        alerts.forEach(alert -> System.out.println(alert));
    }
}
