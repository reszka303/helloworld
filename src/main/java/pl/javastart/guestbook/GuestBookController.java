package pl.javastart.guestbook;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class GuestBookController extends HttpServlet {

    private BookEntryDao bookEntryDao = new BookEntryDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookEntry> entries = bookEntryDao.findAll();
        request.setAttribute("entries", entries);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BookEntry bookEntry = getBookEntry(request);
        bookEntryDao.save(bookEntry);
        response.sendRedirect(request.getContextPath());
    }

    private BookEntry getBookEntry(HttpServletRequest request) {
        String author = request.getParameter("author");
        String message = request.getParameter("message");
        return new BookEntry(author, message);
    }
}
