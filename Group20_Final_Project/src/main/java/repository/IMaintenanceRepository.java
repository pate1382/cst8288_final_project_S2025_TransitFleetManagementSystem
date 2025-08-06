package repository;

import entities.MaintenanceAlert;
import entities.MaintenanceSchedule;
import java.util.List;

/**
 * DAO interface for Maintenance operations.
 * 
 * @author Sarthak
 */
public interface IMaintenanceRepository {
    List<MaintenanceAlert> getAllMaintenanceAlerts();
    List<MaintenanceSchedule> getAllSchedules();
    boolean addAlert(MaintenanceAlert alert);
    boolean updateAlert(MaintenanceAlert alert);
    boolean addSchedule(MaintenanceSchedule schedule);
    boolean updateSchedule(MaintenanceSchedule schedule);
}
