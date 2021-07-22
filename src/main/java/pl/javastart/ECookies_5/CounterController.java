package pl.javastart.ECookies_5;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/counter")
public class CounterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Cookie> visitsCookie = getCookieByName(request, "visits");
        Integer numberOfVisits = visitsCookie
                .map(Cookie::getValue)
                .map(Integer::valueOf)
                .orElse(0);
        numberOfVisits++;
        Cookie cookie = new Cookie("visits", Integer.toString(numberOfVisits));
        cookie.setMaxAge(30 * 24 * 60 * 60);
        response.addCookie(cookie);
        request.setAttribute("numberOfVisits", numberOfVisits);
        request.getRequestDispatcher("/visits.jsp").forward(request, response);
    }

    private Optional<Cookie> getCookieByName(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return Optional.empty();
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return Optional.of(cookie);
            }
        }
        return Optional.empty();
    }
}
