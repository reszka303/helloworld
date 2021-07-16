package pl.javastart.CFormsAndPostMethod_3.task;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/verify")
public class PasswordValidator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = createPasswordFromRequest(request);
        sendResponse(password, response);
    }

    private String createPasswordFromRequest(HttpServletRequest request) {
        return request.getParameter("password");
    }

    private void sendResponse(String password, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.print("<h2>Twoje hasło to: " + password + "</h2>");
        isSafe(password, response);
        writer.println("</body>");
        writer.println("</html>");
    }

    private void isSafe(String password, HttpServletResponse response) throws IOException {
        if (!isRightLength(password)) {
            printLine("<ul>", response);
            printLine("<li>Hasło musi zawierać co najmniej 5 liter</li>", response);
        } if (!isLowerCase(password)) {
            printLine("<li>Hasło musi zawierać co najmniej jedną małą literę</li>", response);
        } if (!isUpperCase(password)) {
            printLine("<li>Hasło musi zawierać co najmniej jedną dużą literę</li>", response);
        } if (!isDigit(password)) {
            printLine("<li>Hasło musi zawierać co najmniej jedną cyfrę</li>", response);
        } if (!isSpecialCharacter(password)) {
            printLine("<li>Hasło musi zawierać co najmniej jeden znak specjalny</li>", response);
            printLine("<ul>", response);
        } else {
            printLine("Hasło spełnia wszystkie kryteria bezpieczeństwa", response);
        }

    }

    private static boolean isSpecialCharacter(String password) {
        String specialCharacter = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        int capacity = password.length();
        int counterSpecialCharacter = 0;
        char currentCharacter;
        for (int i = 0; i < capacity; i++) {
            currentCharacter = password.charAt(i);
            if (specialCharacter.contains(String.valueOf(currentCharacter))) {
                counterSpecialCharacter++;
            }
        }
        return counterSpecialCharacter >= 1;
    }

    private static boolean isDigit(String password) {
        char[] chars = password.toCharArray();
        int counterDigits = 0;
        for (char character : chars) {
            if (Character.isDigit(character))
                counterDigits++;
        }
        return counterDigits >= 1;
    }

    private static boolean isUpperCase(String password) {
        int counterUpperCase = 0;
        char[] chars = password.toCharArray();
        for (char character : chars) {
            if (Character.isUpperCase(character)) {
                counterUpperCase++;
            }
        }
        return counterUpperCase >= 1;
    }

    private static boolean isLowerCase(String password) {
        char[] chars = password.toCharArray();
        int counterLowerCase = 0;
        for (char character : chars) {
            if (Character.isLowerCase(character)) {
                counterLowerCase++;
            }
        }
        return counterLowerCase >= 1;
    }

    private static boolean isRightLength(String password) {
        char[] chars = password.toCharArray();
        return chars.length >= 5;
    }

    private void printLine(String text, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println(text);
    }
}
