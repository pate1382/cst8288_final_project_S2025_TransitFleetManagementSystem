package web;

import entities.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handles user registration for the Transit Fleet Management System.
 *
 * Ensures correct DB insertion into system_users table.
 * Redirects to login.jsp upon success, or stays on register.jsp on failure.
 *
 * @author Sarthak
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // ✅ Retrieve form inputs
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String routeRefParam = request.getParameter("route_ref");

        // ✅ Handle route_ref safely (allow NULL)
        int routeRef = 0;
        if (routeRefParam != null && !routeRefParam.trim().isEmpty()) {
            try {
                routeRef = Integer.parseInt(routeRefParam);
            } catch (NumberFormatException ignored) {}
        }

        // ✅ Validate minimal required fields
        if (fullname == null || email == null || password == null || role == null ||
            fullname.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty()) {
            request.setAttribute("error", "All fields except Route Reference are required.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // ✅ Create User object
        User user = new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setRouteRef(routeRef);

        // ✅ Debug log
        System.out.println("DEBUG: Attempting registration for email=" + email);

        // ✅ Attempt registration
        boolean success = userService.registerUser(user);

        if (success) {
            System.out.println("DEBUG: Registration SUCCESS for user=" + email);
            request.setAttribute("message", "Registration successful! Please log in.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            System.err.println("DEBUG: Registration FAILED for user=" + email);
            request.setAttribute("error", "Registration failed! Email may already exist or DB error occurred.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // ✅ Redirect GET requests to registration page
        response.sendRedirect("register.jsp");
    }
}
