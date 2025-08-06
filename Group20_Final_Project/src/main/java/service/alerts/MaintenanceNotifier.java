package service.alerts;

import entities.MaintenanceAlert;
import java.util.ArrayList;
import java.util.List;

/**
 * Subject class that notifies observers about new alerts.
 * 
 * @author Sarthak
 */
public class MaintenanceNotifier {
    private final List<AlertObserver> observers = new ArrayList<>();

    public void addObserver(AlertObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(AlertObserver observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(MaintenanceAlert alert) {
        for (AlertObserver obs : observers) {
            obs.update(alert);
        }
    }
}
