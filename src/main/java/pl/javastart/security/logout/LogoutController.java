package pl.javastart.security.logout;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.logout(); //usunięcie kontekstu bezpieczeństwa, sesja będzie nadal istnieć
//        request.getSession().invalidate(); //usunięcie sesji wraz z powiązanym kontekstem bezpieczeństwa
        response.sendRedirect(request.getContextPath());

    }
}
