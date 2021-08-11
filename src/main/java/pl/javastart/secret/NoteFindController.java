package pl.javastart.secret;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/note")
public class NoteFindController extends HttpServlet {
    private final NoteDao noteDao = new NoteDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("title") == null)
            response.sendError(404);
        request.getRequestDispatcher("/WEB-INF/accessform.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String noteTitle = request.getParameter("title");
        String password = request.getParameter("password");
        Optional<Note> note = noteDao.findByTitleAndPassword(noteTitle, password);
        note.ifPresent(n -> request.setAttribute("note", n));
        note.map(n -> request.getRequestDispatcher("/WEB-INF/note.jsp"))
                .orElseGet(() -> request.getRequestDispatcher("/WEB-INF/accessdenied.jsp"))
                .forward(request, response);
    }
}
