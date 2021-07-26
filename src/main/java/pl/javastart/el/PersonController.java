package pl.javastart.el;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/")
public class PersonController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstNameServlet");
        String lastName = request.getParameter("lastNameServlet");
        int age = Integer.parseInt(request.getParameter("ageServlet"));
        Person person = new Person(firstName, lastName, age);
        request.setAttribute("person", person);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
