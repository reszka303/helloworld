package pl.javastart.AJakartaServerPages_1.divisors.byJavaStart;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/divisorsByJavaStart")
public class DivisorsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nParam = request.getParameter("n");
        if (nParam == null || "".equals(nParam)) {
            response.sendError(400, "Brak parametru N");
        } else {
        int number = Integer.parseInt(request.getParameter("n"));
        String responseBody = createHtmlResponse(number);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(responseBody);
        }
    }

    private String createHtmlResponse(int number) {
        List<Integer> divisors = DivisorsFinder.getDivisors(number);
        String divisorsList = null;

        if (number == 0) {
            divisorsList = "<li>Liczba 0 ma nieskończenie wiele dzielników</li>";
        } else {
            divisorsList = divisors.stream()
                    .map(divisor -> "<li>" + divisor + "</li>")
                    .collect(Collectors.joining());
        }
        String htmlTemplate =
                """
                        <html>
                            <body>
                                <h1>Podzielnik liczby %d</h1>
                                <ul>
                                    %s
                                </ul>
                            </body>
                        </html>
                        """;
        return String.format(htmlTemplate, number, divisorsList);
    }
}
