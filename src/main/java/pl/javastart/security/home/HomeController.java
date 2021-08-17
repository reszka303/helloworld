package pl.javastart.security.home;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.security.Principal;

@WebServlet("")
@ServletSecurity(
        @HttpConstraint(rolesAllowed = {"user_role", "admin_role"})
)
public class HomeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Principal userPrincipal = request.getUserPrincipal();
        System.out.println(userPrincipal.getName());
        System.out.println(request.isUserInRole("user_role"));
        System.out.println(request.isUserInRole("admin_role"));
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}