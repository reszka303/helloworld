package pl.javastart.secret;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/save")
public class NoteSaveController extends HttpServlet {
    private final NoteDao noteDao = new NoteDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Note note = getNoteFromParameters(request);
        noteDao.save(note);
        request.setAttribute("note", note);
        request.getRequestDispatcher("/WEB-INF/confirm.jsp").forward(request, response);
    }

    private Note getNoteFromParameters(HttpServletRequest request) {
        String title = request.getParameter("title");
        String password = request.getParameter("password");
        String content = request.getParameter("content");
        return new Note(title, content, password);
    }
}
