package web;

import entities.Vehicle;
import service.VehicleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Handles vehicle management.
 * 
 * @author Sarthak
 */
@WebServlet("/vehicles")
public class VehicleServlet extends HttpServlet {
    private final VehicleService vehicleService = new VehicleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        request.setAttribute("vehicles", vehicles);
        request.getRequestDispatcher("views/vehicles.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vehicle v = new Vehicle();
        v.setVehicleCode(request.getParameter("vehicleCode"));
        v.setFuelRate(Double.parseDouble(request.getParameter("fuelRate")));
        v.setMaxCapacity(Integer.parseInt(request.getParameter("maxCapacity")));
        v.setFuelType(request.getParameter("fuelType"));
        v.setAssignedRoute(Integer.parseInt(request.getParameter("routeRef")));
        v.setSeatingCapacity(Integer.parseInt(request.getParameter("seatingCapacity")));

        vehicleService.addVehicle(v);
        response.sendRedirect("vehicles");
    }
}
