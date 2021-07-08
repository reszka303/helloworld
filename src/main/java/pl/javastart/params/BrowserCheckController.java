package pl.javastart.params;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

@WebServlet("/browser")
public class BrowserCheckController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printUserAgent(request);
        System.out.println("-----");
        printAllHeaders(request);
    }

    private void printAllHeaders(HttpServletRequest request) {
        System.out.println("Wszystkie nagłówki:");
        Enumeration<String> headerNames = request.getHeaderNames();
        Collections.list(headerNames).stream()
                .map(name -> name + " " +request.getHeader(name))
                .forEach(System.out::println);

        //staszy sposób zapisu
//        while (headerNames.hasMoreElements()) {
//            String nextHeaderName = headerNames.nextElement();
//            System.out.println(nextHeaderName + " " + request.getHeader(nextHeaderName));
//        }

    }

    private void printUserAgent(HttpServletRequest request) {
        String header = request.getHeader("user-agent");
        System.out.println("Przeglądarka klienta: " + header);
    }
}
