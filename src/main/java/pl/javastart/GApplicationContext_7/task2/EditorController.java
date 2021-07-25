package pl.javastart.GApplicationContext_7.task2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

// <form action="editor" method="post">
@WebServlet("")
public class EditorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//kod html <textarea id="mytextarea" name="nameFromHTML">
        ServletContext context = getServletContext();
        Object text = context.getAttribute("nameFromHTML");
        forwardRequestWithTextAttribute(request, response, text);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//kod html <textarea id="mytextarea" name="nameFromHTML">
        String text = request.getParameter("nameFromHTML");
        ServletContext context = getServletContext();
        context.setAttribute("nameFromHTML", text);
        forwardRequestWithTextAttribute(request, response, text);
    }

    private void forwardRequestWithTextAttribute(HttpServletRequest request, HttpServletResponse response, Object text) throws ServletException, IOException {
        request.setAttribute("nameFromHTML", text != null ? text : "");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
