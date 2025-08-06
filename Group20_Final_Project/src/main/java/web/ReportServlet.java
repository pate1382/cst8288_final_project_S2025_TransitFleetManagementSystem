package web;

import entities.MaintenanceAlert;
import entities.FuelLog;
import service.MaintenanceService;
import service.FuelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Generates reports for fuel usage and maintenance.
 * 
 * @author Sarthak
 */
@WebServlet("/reports")
public class ReportServlet extends HttpServlet {
    private final FuelService fuelService = new FuelService();
    private final MaintenanceService maintenanceService = new MaintenanceService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FuelLog> logs = fuelService.getLogsByVehicle(1); // example
        List<MaintenanceAlert> alerts = maintenanceService.getAllAlerts();

        request.setAttribute("fuelLogs", logs);
        request.setAttribute("alerts", alerts);
        request.getRequestDispatcher("views/reports.jsp").forward(request, response);
    }
}
