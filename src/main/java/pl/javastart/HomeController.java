package pl.javastart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> products = List.of("sukienki", "torebki", "spodnie", "buty");
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
