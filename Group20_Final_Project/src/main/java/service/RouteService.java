package service;

import entities.Route;
import repository.IRouteRepository;
import repository.impl.RouteRepositoryImpl;

import java.util.List;

/**
 * Handles business logic for Routes.
 * 
 * @author Sarthak
 */
public class RouteService {
    private final IRouteRepository routeRepo = new RouteRepositoryImpl();

    public List<Route> getAllRoutes() {
        return routeRepo.getAllRoutes();
    }

    public Route getRouteById(int id) {
        return routeRepo.getRouteById(id);
    }

    public boolean addRoute(Route route) {
        return routeRepo.addRoute(route);
    }

    public boolean updateRoute(Route route) {
        return routeRepo.updateRoute(route);
    }

    public boolean deleteRoute(int id) {
        return routeRepo.deleteRoute(id);
    }
}
