package web;

import entities.FuelLog;
import service.FuelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handles fuel logging and cost calculation.
 * 
 * @author Sarthak
 */
@WebServlet("/fuel")
public class FuelServlet extends HttpServlet {
    private final FuelService fuelService = new FuelService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FuelLog log = new FuelLog();
        log.setVehicleRef(Integer.parseInt(request.getParameter("vehicleRef")));
        log.setLogDate(request.getParameter("logDate"));
        log.setDistance(Double.parseDouble(request.getParameter("distance")));
        log.setPricePerUnit(Double.parseDouble(request.getParameter("pricePerUnit")));

        fuelService.logFuel(log);
        response.sendRedirect("vehicles");
    }
}
