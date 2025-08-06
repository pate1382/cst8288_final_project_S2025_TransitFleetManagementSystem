package service.alerts;

import entities.MaintenanceSchedule;
import repository.IMaintenanceRepository;
import repository.impl.MaintenanceRepositoryImpl;

/**
 * Command to update an existing maintenance schedule.
 * 
 * @author Sarthak
 */
public class UpdateMaintenanceCommand implements MaintenanceCommand {
    private final MaintenanceSchedule schedule;
    private final IMaintenanceRepository repo = new MaintenanceRepositoryImpl();

    public UpdateMaintenanceCommand(MaintenanceSchedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public void execute() {
        repo.updateSchedule(schedule);
    }
}
