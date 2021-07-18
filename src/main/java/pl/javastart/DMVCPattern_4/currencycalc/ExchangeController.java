package pl.javastart.DMVCPattern_4.currencycalc;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

//W serwlecie ustawiam mapowanie na taki sam adres jak w pliku html w <form action="convert"
@WebServlet("/convert")
public class ExchangeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (validateParameters(request)) {
            successDispatch(request, response);
        } else {
            errorDispatch(request, response);
        }

    }

    private boolean validateParameters(HttpServletRequest request) {
        String exchangeParam = request.getParameter("exchange");
        if (exchangeParam == null || "".equals(exchangeParam)) {
            request.setAttribute("message", "Typ wymiany nie został określony");
            return false;
        } else {
            ExchangeType[] values = ExchangeType.values();
            boolean invalidExchangeType = Arrays.stream(values)
                    .map(Enum::toString)
                    .noneMatch(exchangeType -> exchangeType.equals(exchangeParam));
            if (invalidExchangeType) {
                request.setAttribute("message", "Nieznany typ wymiany " + exchangeParam);
                return false;
            }
        }
        String value = request.getParameter("value");
        if (value == null || "".equals(value)) {
            request.setAttribute("message", "Kwota nie została określona");
            return false;
        } else if (!value.matches("-?\\d+(\\.\\d+)?")) {
            request.setAttribute("message", "Nieprawidłowy numerek");
            return false;
        }
        return true;
    }

    private void successDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //pierwszy parametr w naszym pliku html nazywa się "value"
        String valueString = request.getParameter("value");
        BigDecimal value = new BigDecimal(valueString);
//drugi parametr w naszym pliku html nazywa się "exchange"
        String exchangeString = request.getParameter("exchange");
        ExchangeType exchangeType = ExchangeType.valueOf(exchangeString);
//teraz obliczamy wynik wymiany waluty poprzez kalkulator
        ExchangeResult exchangeResult = ExchangeCalculator.exchange(value, exchangeType);
//teraz korzystając ze wzorca MVC przekazujemy obiekt exchangeResult do result.jsp
//w jaki sposób przekazać obiekt exchangeResult do result.jsp?
//aby to zrobić posługujemy się atrybutami,
        request.setAttribute("result", exchangeResult);
//pod nazwą atrybutu "result" będziemy się odwyływać w pliku result.jsp
//do setAttribute(String, Object) drugiego argumentu możemy wstawiać dowolny obiekt
//aby przekazać żądanie do strony jsp musimy wykorzystać dyspozytora żądań
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");
        requestDispatcher.forward(request, response);
    }

    private void errorDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }
}
