package pl.javastart.el;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class PersonController extends HttpServlet {
    public void init() {
        getServletContext().setAttribute("people", new ArrayList<Person>());
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstNameServlet");
        String lastName = request.getParameter("lastNameServlet");
        int age = Integer.parseInt(request.getParameter("ageServlet"));
        Gender gender = Gender.valueOf(request.getParameter("genderServlet"));
        Person person = new Person(firstName, lastName, age, gender);
        List<Person> peopleList = (List<Person>) getServletContext().getAttribute("people");
        peopleList.add(person);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
