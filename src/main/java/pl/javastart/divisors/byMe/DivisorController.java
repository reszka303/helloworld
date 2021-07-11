package pl.javastart.divisors.byMe;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/divisors")
public class DivisorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String number = request.getParameter("n");
        if (number == null || number.equals("")) {
            response.sendError(400, "Brak parametru N");
        } else {
            sendContentType(response);
            String htmlResponse = createHtmlResponse(number);
            response.getWriter().println(htmlResponse);
        }
    }

    private void sendContentType(HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }

    private String createHtmlResponse(String n) {
        int number = Integer.parseInt(n);
        DivisorFinder divisor = new DivisorFinder();
        int[] divisors = divisor.getDivisor(number);
        int capacity = divisors.length;
        String[] arrayEqualZero = new String[1];
        String[] arrayWithoutZero = new String[capacity];
        if (number == 0) {
            arrayEqualZero[0] = "<li>Liczba 0 ma nieskończenie wiele dzielników</li>";
        } else {
            for (int i = 0; i < divisors.length; i++) {
                arrayWithoutZero[i] = "<li>" + divisors[i] + "</li>";
            }
        }
        String joined;
        if (number == 0) {
            joined = String.join("", arrayEqualZero);
        } else {
            joined = String.join("", arrayWithoutZero);
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
        return String.format(htmlTemplate, number, joined);
    }
}
