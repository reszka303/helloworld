package pl.javastart.divisors.byMe;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/divisors")
public class DivisorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String number = request.getParameter("n");
        sendContentType(response);
        createHtmlResponse(number, response);
    }

    private void sendContentType(HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }

    private void createHtmlResponse(String n, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        int number = Integer.parseInt(n);
        Divisor divisor = new Divisor();
        int[] divisors = divisor.getDivisor(number);
        if (number == 0) {
            writer.println("<html>");
            writer.println("<body");
            writer.printf("<h1>Podzielnik liczby %d</h1>", number);
            writer.println();
            writer.println("<ul>");
            writer.println("<li>Liczba 0 ma nieskończenie wiele dzielników</li>");
            writer.println("</ul>");
            writer.println("</body>");
            writer.println("</html>");
        } else {
            writer.println("<html>");
            writer.println("<body");
            writer.printf("<h1>Podzielnik liczby %d</h1>", number);
            writer.println();
            writer.println("<ul>");
            for (int digit : divisors) {
                writer.printf("<li>%s</li>", digit);
                writer.println();
            }
            writer.println("</ul>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
