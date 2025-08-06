package service.alerts;

import entities.MaintenanceAlert;

/**
 * Observer interface for receiving maintenance alert notifications.
 * 
 * @author Sarthak
 */
public interface AlertObserver {
    void update(MaintenanceAlert alert);
}
