package web;

import entities.Route;
import service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Handles route management (CRUD).
 * 
 * @author Sarthak
 */
@WebServlet("/routes")
public class RouteServlet extends HttpServlet {
    private final RouteService routeService = new RouteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Route> routes = routeService.getAllRoutes();
        request.setAttribute("routes", routes);
        request.getRequestDispatcher("views/routes.jsp").forward(request, response);
    }
}
