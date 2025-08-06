package service.alerts;

import entities.MaintenanceSchedule;
import repository.IMaintenanceRepository;
import repository.impl.MaintenanceRepositoryImpl;

/**
 * Command to create a new maintenance schedule.
 * 
 * @author Sarthak
 */
public class CreateMaintenanceCommand implements MaintenanceCommand {
    private final MaintenanceSchedule schedule;
    private final IMaintenanceRepository repo = new MaintenanceRepositoryImpl();

    public CreateMaintenanceCommand(MaintenanceSchedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public void execute() {
        repo.addSchedule(schedule);
    }
}
