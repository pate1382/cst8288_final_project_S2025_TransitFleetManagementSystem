package entities;

/**
 * Represents a vehicle in the transit fleet.
 * Maps to table: fleet_vehicles
 * 
 * @author Sarthak
 */
public class Vehicle {
    private int id;
    private String vehicleCode;
    private double fuelRate;
    private int maxCapacity;
    private String fuelType;
    private int assignedRoute;
    private int seatingCapacity;

    public Vehicle() {}

    public Vehicle(int id, String vehicleCode, double fuelRate, int maxCapacity, String fuelType, int assignedRoute, int seatingCapacity) {
        this.id = id;
        this.vehicleCode = vehicleCode;
        this.fuelRate = fuelRate;
        this.maxCapacity = maxCapacity;
        this.fuelType = fuelType;
        this.assignedRoute = assignedRoute;
        this.seatingCapacity = seatingCapacity;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getVehicleCode() { return vehicleCode; }
    public void setVehicleCode(String vehicleCode) { this.vehicleCode = vehicleCode; }

    public double getFuelRate() { return fuelRate; }
    public void setFuelRate(double fuelRate) { this.fuelRate = fuelRate; }

    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }

    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public int getAssignedRoute() { return assignedRoute; }
    public void setAssignedRoute(int assignedRoute) { this.assignedRoute = assignedRoute; }

    public int getSeatingCapacity() { return seatingCapacity; }
    public void setSeatingCapacity(int seatingCapacity) { this.seatingCapacity = seatingCapacity; }

    @Override
    public String toString() {
        return "Vehicle{id=" + id + ", code='" + vehicleCode + "', fuelType='" + fuelType + "'}";
    }
}
