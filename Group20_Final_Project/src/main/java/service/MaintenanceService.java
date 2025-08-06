package service;

import entities.MaintenanceAlert;
import entities.MaintenanceSchedule;
import repository.IMaintenanceRepository;
import repository.impl.MaintenanceRepositoryImpl;
import service.alerts.AlertObserver;
import service.alerts.MaintenanceCommand;


import java.util.List;

/**
 * Handles business logic for Maintenance operations.
 * Uses Observer + Command Patterns for scheduling alerts.
 * 
 * @author Sarthak
 */
public class MaintenanceService {
    private final IMaintenanceRepository maintRepo = new MaintenanceRepositoryImpl();

    public List<MaintenanceAlert> getAllAlerts() {
        return maintRepo.getAllMaintenanceAlerts();
    }

    public List<MaintenanceSchedule> getAllSchedules() {
        return maintRepo.getAllSchedules();
    }

    public boolean addAlert(MaintenanceAlert alert) {
        return maintRepo.addAlert(alert);
    }

    public boolean updateAlert(MaintenanceAlert alert) {
        return maintRepo.updateAlert(alert);
    }

    public boolean addSchedule(MaintenanceSchedule schedule) {
        return maintRepo.addSchedule(schedule);
    }

    public boolean updateSchedule(MaintenanceSchedule schedule) {
        return maintRepo.updateSchedule(schedule);
    }

    /**
     * Uses Observer Pattern to notify managers when a new alert is added.
     */
    public void notifyMaintenance(AlertObserver observer, MaintenanceAlert alert) {
        observer.update(alert);
    }

    /**
     * Executes a command for scheduling maintenance.
     */
    public void executeCommand(MaintenanceCommand command) {
        command.execute();
    }
}
