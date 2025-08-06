package repository;

import entities.Route;
import java.util.List;

/**
 * DAO interface for Route operations.
 * 
 * author Sarthak
 */
public interface IRouteRepository {
    List<Route> getAllRoutes();
    Route getRouteById(int id);
    boolean addRoute(Route route);
    boolean updateRoute(Route route);
    boolean deleteRoute(int id);
}
