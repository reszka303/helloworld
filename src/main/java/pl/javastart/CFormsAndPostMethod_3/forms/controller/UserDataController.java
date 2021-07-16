package pl.javastart.CFormsAndPostMethod_3.forms.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.javastart.CFormsAndPostMethod_3.forms.model.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userdata")
public class UserDataController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = createUserFromRequest(request);
        sendResponse(user, response);
    }

    private User createUserFromRequest(HttpServletRequest request) {
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("pass"));
        user.setGender(request.getParameter("gender"));
        user.setHobby(request.getParameterValues("hobby"));
        return user;
    }

    private void sendResponse(User user, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.print("<h2>Dane odebrano pomyślnie</h2>");
        writer.print("<div>");
        writer.println(user.getUsername() + "<br>");
        writer.println(user.getPassword() + "<br>");
        writer.println(user.getGender() + "<br");
        writer.println("Hobby: <br>");
        if (user.getHobby() != null) {
            writer.print("Hobby: <br>");
            for (String hobby : user.getHobby()) {
                writer.print(" " + hobby + "<br>");
            }
        }
        writer.print("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
