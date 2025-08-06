package entities;

/**
 * Represents an operator’s log for station arrivals and departures.
 * Maps to table: op_station_logs
 * 
 * @author Sarthak
 */
public class StationLog {
    private int id;
    private String logDate;
    private String timeIn;
    private String timeOut;
    private String remarks;
    private int scheduleRef;
    private int userRef;

    public StationLog() {}

    public StationLog(int id, String logDate, String timeIn, String timeOut, String remarks, int scheduleRef, int userRef) {
        this.id = id;
        this.logDate = logDate;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.remarks = remarks;
        this.scheduleRef = scheduleRef;
        this.userRef = userRef;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLogDate() { return logDate; }
    public void setLogDate(String logDate) { this.logDate = logDate; }

    public String getTimeIn() { return timeIn; }
    public void setTimeIn(String timeIn) { this.timeIn = timeIn; }

    public String getTimeOut() { return timeOut; }
    public void setTimeOut(String timeOut) { this.timeOut = timeOut; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public int getScheduleRef() { return scheduleRef; }
    public void setScheduleRef(int scheduleRef) { this.scheduleRef = scheduleRef; }

    public int getUserRef() { return userRef; }
    public void setUserRef(int userRef) { this.userRef = userRef; }

    @Override
    public String toString() {
        return "StationLog{id=" + id + ", logDate=" + logDate + ", remarks='" + remarks + "'}";
    }
}
