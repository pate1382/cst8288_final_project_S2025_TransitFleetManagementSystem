package service.strategy;

/**
 * Strategy interface for fuel/energy cost calculation.
 * 
 * @author Sarthak
 */
public interface CostStrategy {
    double calculateCost(double distance, double rate);
}
