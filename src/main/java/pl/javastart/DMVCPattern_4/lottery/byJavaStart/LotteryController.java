package pl.javastart.DMVCPattern_4.lottery.byJavaStart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/lotteryByJavaStart")
public class LotteryController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Integer> userNumbers = getNumbers(request);
        List<Integer> lotteryNumbers = Lottery.getRandomNumbers();
        List<Integer> winnerNumbers = Lottery.getCommonElements(lotteryNumbers, userNumbers);
        LotteryResult lotteryResult = new LotteryResult(userNumbers, lotteryNumbers, winnerNumbers);
        request.setAttribute("lotteryResult", lotteryResult);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    private List<Integer> getNumbers(HttpServletRequest request) {
        String[] numbersParam = request.getParameterValues("numbers");
        return Arrays.stream(numbersParam)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
