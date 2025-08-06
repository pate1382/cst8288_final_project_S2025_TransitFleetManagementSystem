package web;

import entities.AlertType;
import repository.IAlertRepository;
import repository.impl.AlertRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Handles alert type retrieval.
 * 
 * @author Sarthak
 */
@WebServlet("/alerts")
public class AlertServlet extends HttpServlet {
    private final IAlertRepository alertRepo = new AlertRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AlertType> types = alertRepo.getAllAlertTypes();
        request.setAttribute("alertTypes", types);
        request.getRequestDispatcher("views/alerts.jsp").forward(request, response);
    }
}
