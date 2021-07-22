package pl.javastart.ECookies_5;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/remove")
public class RemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie removeVisitCookie = new Cookie("visits", "");
        removeVisitCookie.setMaxAge(0);
        response.addCookie(removeVisitCookie);
        request.getRequestDispatcher("/removeConfirm.jsp").forward(request, response);
    }
}
