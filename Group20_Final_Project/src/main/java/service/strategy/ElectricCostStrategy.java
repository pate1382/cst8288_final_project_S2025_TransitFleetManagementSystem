package service.strategy;

/**
 * Electric vehicle energy cost calculation.
 * 
 * @author Sarthak
 */
public class ElectricCostStrategy implements CostStrategy {
    @Override
    public double calculateCost(double distance, double rate) {
        return distance * rate * 0.8; // Electric is cheaper
    }
}
