package pl.javastart.chat;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chat")
public class ChatController extends HttpServlet {
    public void init() {
        getServletContext().setAttribute("listChat", new ArrayList<Chat>());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("messageServlet");
        String nickname = request.getParameter("nicknameServlet");
        Chat chat = new Chat(nickname, message);
        List<Chat> chats = (List<Chat>) getServletContext().getAttribute("listChat");
        chats.add(chat);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
