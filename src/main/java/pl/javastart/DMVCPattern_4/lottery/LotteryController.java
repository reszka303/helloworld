package pl.javastart.DMVCPattern_4.lottery;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.*;

@WebServlet("/lottery")
public class LotteryController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (validateParameter(request)) {
            successDispatch(request, response);
        } else {
            errorDispatch(request, response);
        }
    }

    private boolean validateParameter(HttpServletRequest request) {
        String[] numbersParam = request.getParameterValues("number");
        if (!LotteryManager.checkEqualElements(numbersParam)) {
            request.setAttribute("message", "Kupon utracił ważność, nie możesz" +
                    " podać tych samych cyfr w jednym kuponie");
            return false;
        }
        return true;
    }

    private void successDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] numbersParam = request.getParameterValues("number");
        List<Integer> playerNumbers = LotteryManager.convertToListInteger(numbersParam);
        List<Integer> lotteryNumbers = LotteryManager.lottery();
        List<Integer> hitList = LotteryManager.checkIfVoucherContainsTheSameNumbers(lotteryNumbers, playerNumbers);
        LotteryResult lotteryResult = new LotteryResult(lotteryNumbers, playerNumbers, hitList);
        request.setAttribute("result", lotteryResult);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result.jsp");
        requestDispatcher.forward(request, response);
    }

    private void errorDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("error.jsp").forward(request, response);
    }
}
