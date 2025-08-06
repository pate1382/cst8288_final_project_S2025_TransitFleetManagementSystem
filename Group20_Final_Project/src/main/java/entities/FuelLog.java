package entities;

/**
 * Represents a fuel log entry for a vehicle.
 * Maps to table: fuel_logs
 * 
 * @author Sarthak
 */
public class FuelLog {
    private int id;
    private int vehicleRef;
    private String logDate;
    private double distance;
    private double pricePerUnit;

    public FuelLog() {}

    public FuelLog(int id, int vehicleRef, String logDate, double distance, double pricePerUnit) {
        this.id = id;
        this.vehicleRef = vehicleRef;
        this.logDate = logDate;
        this.distance = distance;
        this.pricePerUnit = pricePerUnit;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getVehicleRef() { return vehicleRef; }
    public void setVehicleRef(int vehicleRef) { this.vehicleRef = vehicleRef; }

    public String getLogDate() { return logDate; }
    public void setLogDate(String logDate) { this.logDate = logDate; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    public double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }

    @Override
    public String toString() {
        return "FuelLog{id=" + id + ", date=" + logDate + ", distance=" + distance + "}";
    }
}
