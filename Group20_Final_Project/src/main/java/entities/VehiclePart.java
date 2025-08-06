package entities;

/**
 * Represents a vehicle part and its usage details.
 * Maps to table: vehicle_parts
 * 
 * @author Sarthak
 */
public class VehiclePart {
    private int id;
    private String name;
    private int vehicleRef;
    private int hoursUsed;
    private int hoursLimit;

    public VehiclePart() {}

    public VehiclePart(int id, String name, int vehicleRef, int hoursUsed, int hoursLimit) {
        this.id = id;
        this.name = name;
        this.vehicleRef = vehicleRef;
        this.hoursUsed = hoursUsed;
        this.hoursLimit = hoursLimit;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getVehicleRef() { return vehicleRef; }
    public void setVehicleRef(int vehicleRef) { this.vehicleRef = vehicleRef; }

    public int getHoursUsed() { return hoursUsed; }
    public void setHoursUsed(int hoursUsed) { this.hoursUsed = hoursUsed; }

    public int getHoursLimit() { return hoursLimit; }
    public void setHoursLimit(int hoursLimit) { this.hoursLimit = hoursLimit; }

    @Override
    public String toString() {
        return "VehiclePart{id=" + id + ", name='" + name + "', hoursUsed=" + hoursUsed + "}";
    }
}
