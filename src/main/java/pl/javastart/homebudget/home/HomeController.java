package pl.javastart.homebudget.home;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pl.javastart.homebudget.budget.BudgetItem;
import pl.javastart.homebudget.budget.BudgetItemDao;
import pl.javastart.homebudget.budget.BudgetItemType;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private BudgetItemDao budgetItemDao = new BudgetItemDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BudgetItem> incomes = budgetItemDao.findAllItemsByType(BudgetItemType.INCOME);
        List<BudgetItem> expenses = budgetItemDao.findAllItemsByType(BudgetItemType.EXPENSE);
        BigDecimal incomesSum = getSum(incomes);
        BigDecimal expensesSum = getSum(expenses);
        BigDecimal balance = incomesSum.subtract(expensesSum);
        request.setAttribute("incomes", incomes);
        request.setAttribute("expenses", expenses);
        request.setAttribute("incomesSum", incomesSum);
        request.setAttribute("expensesSum", expensesSum);
        request.setAttribute("balance", balance);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    private BigDecimal getSum(List<BudgetItem> items) {
        return items.stream()
                .map(BudgetItem::getValue)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
