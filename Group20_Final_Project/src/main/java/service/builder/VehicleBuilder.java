package service.builder;

import entities.Vehicle;

/**
 * Builder pattern for constructing Vehicle objects step-by-step.
 * 
 * @author Sarthak
 */
public abstract class VehicleBuilder {
    protected Vehicle vehicle;

    public void createNewVehicle() {
        vehicle = new Vehicle();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public abstract void buildCode(String code);
    public abstract void buildFuelRate(double rate);
    public abstract void buildCapacity(int capacity);
    public abstract void buildFuelType(String type);
    public abstract void assignRoute(int routeId);
    public abstract void buildSeating(int seating);
}
