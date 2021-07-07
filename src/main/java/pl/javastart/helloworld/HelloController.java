package pl.javastart.helloworld;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class HelloController extends HttpServlet {
    public HelloController() {
        System.out.println("Konstruktor()");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Metoda init()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Metoda doGet()");
    }

    @Override
    public void destroy() {
        System.out.println("Metoda destroy()");
    }
}
