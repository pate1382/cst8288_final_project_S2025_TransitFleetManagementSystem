package entities;

/**
 * Represents an alert triggered for vehicle maintenance.
 * Maps to table: maint_alerts
 * 
 * @author Sarthak
 */
public class MaintenanceAlert {
    private int id;
    private int alertTypeRef;
    private int partRef;
    private String alertDate;
    private int reportedBy;
    private boolean resolved;

    public MaintenanceAlert() {}

    public MaintenanceAlert(int id, int alertTypeRef, int partRef, String alertDate, int reportedBy, boolean resolved) {
        this.id = id;
        this.alertTypeRef = alertTypeRef;
        this.partRef = partRef;
        this.alertDate = alertDate;
        this.reportedBy = reportedBy;
        this.resolved = resolved;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAlertTypeRef() { return alertTypeRef; }
    public void setAlertTypeRef(int alertTypeRef) { this.alertTypeRef = alertTypeRef; }

    public int getPartRef() { return partRef; }
    public void setPartRef(int partRef) { this.partRef = partRef; }

    public String getAlertDate() { return alertDate; }
    public void setAlertDate(String alertDate) { this.alertDate = alertDate; }

    public int getReportedBy() { return reportedBy; }
    public void setReportedBy(int reportedBy) { this.reportedBy = reportedBy; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }

    @Override
    public String toString() {
        return "MaintenanceAlert{id=" + id + ", alertDate=" + alertDate + ", resolved=" + resolved + "}";
    }
}
