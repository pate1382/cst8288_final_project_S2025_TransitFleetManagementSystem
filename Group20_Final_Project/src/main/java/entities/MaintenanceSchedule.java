package entities;

/**
 * Represents a scheduled maintenance task.
 * Maps to table: maint_schedule
 * 
 * @author Sarthak
 */
public class MaintenanceSchedule {
    private int id;
    private int alertRef;
    private String scheduledDate;
    private String notes;
    private double cost;
    private boolean completed;

    public MaintenanceSchedule() {}

    public MaintenanceSchedule(int id, int alertRef, String scheduledDate, String notes, double cost, boolean completed) {
        this.id = id;
        this.alertRef = alertRef;
        this.scheduledDate = scheduledDate;
        this.notes = notes;
        this.cost = cost;
        this.completed = completed;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAlertRef() { return alertRef; }
    public void setAlertRef(int alertRef) { this.alertRef = alertRef; }

    public String getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(String scheduledDate) { this.scheduledDate = scheduledDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    @Override
    public String toString() {
        return "MaintenanceSchedule{id=" + id + ", scheduledDate=" + scheduledDate + ", cost=" + cost + "}";
    }
}
