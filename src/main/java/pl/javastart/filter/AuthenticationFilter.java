package pl.javastart.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebFilter("/secret")
public class AuthenticationFilter implements Filter {
    private static final String PASS = "h@rdPass";

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String pass = request.getParameter("pass");
        if (pass != null && pass.equals(PASS))
            chain.doFilter(request, response);
        else
            ((HttpServletResponse)response).sendError(403, "Wrong password");
    }
}
