package service.strategy;

/**
 * Hybrid vehicle fuel cost calculation.
 * 
 * @author Sarthak
 */
public class HybridCostStrategy implements CostStrategy {
    @Override
    public double calculateCost(double distance, double rate) {
        return distance * rate; // Standard cost
    }
}
