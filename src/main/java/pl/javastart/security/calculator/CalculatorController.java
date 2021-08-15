package pl.javastart.security.calculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/calculator")
@ServletSecurity(
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "POST", rolesAllowed = "admin_role")
        }
)
public class CalculatorController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double first = Double.parseDouble(request.getParameter("first"));
        double second = Double.parseDouble(request.getParameter("second"));
        String operator = request.getParameter("operator");
        Result result = Calculator.calculate(first, second, operator);
        request.setAttribute("result", result);
        request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
    }
}