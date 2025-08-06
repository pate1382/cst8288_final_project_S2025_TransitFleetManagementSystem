package service.builder;

import entities.Vehicle;

/**
 * Director class to use VehicleBuilder for creating vehicles.
 * 
 * @author Sarthak
 */
public class VehicleDirector {
    private VehicleBuilder builder;

    public void setBuilder(VehicleBuilder builder) {
        this.builder = builder;
    }

    public Vehicle constructVehicle(String code, double rate, int capacity, String fuelType, int route, int seating) {
        builder.createNewVehicle();
        builder.buildCode(code);
        builder.buildFuelRate(rate);
        builder.buildCapacity(capacity);
        builder.buildFuelType(fuelType);
        builder.assignRoute(route);
        builder.buildSeating(seating);
        return builder.getVehicle();
    }
}
