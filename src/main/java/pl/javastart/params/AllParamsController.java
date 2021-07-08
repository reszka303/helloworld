package pl.javastart.params;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet("/allparams")
public class AllParamsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String key : parameterMap.keySet()) {
            System.out.println(key);
            for (String value : parameterMap.get(key)) {
                System.out.println(" -" + value);
            }
        }
    }
}
