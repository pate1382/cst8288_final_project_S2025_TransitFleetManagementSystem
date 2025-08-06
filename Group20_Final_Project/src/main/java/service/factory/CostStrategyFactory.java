package service.factory;

import service.strategy.CostStrategy;
import service.strategy.DieselCostStrategy;
import service.strategy.ElectricCostStrategy;
import service.strategy.HybridCostStrategy;

/**
 * Simple Factory to return appropriate CostStrategy based on fuel type.
 * 
 * @author Sarthak
 */
public class CostStrategyFactory {
    public static CostStrategy getStrategy(String fuelType) {
        switch (fuelType.toLowerCase()) {
            case "diesel":
                return new DieselCostStrategy();
            case "electric":
                return new ElectricCostStrategy();
            case "hybrid":
                return new HybridCostStrategy();
            default:
                throw new IllegalArgumentException("Unknown fuel type: " + fuelType);
        }
    }
}
