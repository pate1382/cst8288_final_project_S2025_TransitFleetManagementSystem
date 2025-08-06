package web;

import entities.MaintenanceAlert;
import entities.MaintenanceSchedule;
import service.MaintenanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Handles maintenance alerts and schedules.
 * 
 * author Sarthak
 */
@WebServlet("/maintenance")
public class MaintenanceServlet extends HttpServlet {
    private final MaintenanceService maintenanceService = new MaintenanceService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MaintenanceAlert> alerts = maintenanceService.getAllAlerts();
        List<MaintenanceSchedule> schedules = maintenanceService.getAllSchedules();
        request.setAttribute("alerts", alerts);
        request.setAttribute("schedules", schedules);
        request.getRequestDispatcher("views/maintenance.jsp").forward(request, response);
    }
}
