package web;

import entities.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Handles user login and session management for Transit Fleet Management System.
 * Redirects to dashboard.jsp if successful, else stays on login.jsp with an error message.
 * 
 * @author Sarthak
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // ✅ Retrieve user input
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // ✅ Basic validation before hitting DB
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("error", "Email and password are required.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // ✅ Debug log
        System.out.println("DEBUG: Attempting login for email=" + email);

        // ✅ Authenticate using service layer
        User user = userService.login(email, password);

        if (user != null) {
            System.out.println("DEBUG: Login SUCCESS for user=" + email + ", role=" + user.getRole());

            // ✅ Create session for logged-in user
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(1800); // 30 min session timeout

            // ✅ Redirect to dashboard.jsp
            response.sendRedirect("dashboard.jsp");

        } else {
            System.err.println("DEBUG: Login FAILED for email=" + email);

            // ❌ Show error and stay on login.jsp
            request.setAttribute("error", "Invalid email or password!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // ✅ Redirect GET requests to login.jsp
        response.sendRedirect("login.jsp");
    }
}
