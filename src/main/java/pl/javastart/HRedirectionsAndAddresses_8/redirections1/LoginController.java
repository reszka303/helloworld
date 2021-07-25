package pl.javastart.HRedirectionsAndAddresses_8.redirections1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("usernameServlet");
        String password = request.getParameter("passwordServlet");
        if ("admin".equals(username) && "admin".equals(password)) {
            request.getSession().setAttribute("usernameServlet", username);
//            request.getRequestDispatcher("adminPage.jsp").forward(request, response);
            response.sendRedirect("adminPage.jsp");
        } else {
//            request.getRequestDispatcher("error.jsp").forward(request, response);
            response.sendRedirect("error.jsp");
        }
    }
}
