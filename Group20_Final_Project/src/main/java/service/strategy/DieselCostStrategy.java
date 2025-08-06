package service.strategy;

/**
 * Diesel fuel cost calculation.
 * 
 * @author Sarthak
 */
public class DieselCostStrategy implements CostStrategy {
    @Override
    public double calculateCost(double distance, double rate) {
        return distance * rate * 1.1; // Diesel has extra surcharge
    }
}
