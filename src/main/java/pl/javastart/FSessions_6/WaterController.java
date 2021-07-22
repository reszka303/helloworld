package pl.javastart.FSessions_6;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/control")
public class WaterController extends HttpServlet {
    private static final int GLASS_OF_WATER = 250;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");
        HttpSession session = request.getSession();
        if (option.equals("water")) {
            increaseWaterLevel(session);
        } else if (option.equals("clear")) {
            session.removeAttribute("water");
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

    private void increaseWaterLevel(HttpSession session) {
        Object water = session.getAttribute("water");
        int resultWater;
        if (water == null) {
            resultWater = GLASS_OF_WATER;
        } else {
            resultWater = ((int)water) + GLASS_OF_WATER;
        }
        session.setAttribute("water", resultWater);
    }
}
