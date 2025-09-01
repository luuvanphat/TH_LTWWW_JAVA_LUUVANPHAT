package iuh.fit.se.bai1filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if ("admin".equals(user) && "123".equals(pass)) {
            out.println("<h2>Login successful! Welcome " + user + "</h2>");
        } else {
            out.println("<h2>Login failed. Invalid username or password.</h2>");
        }
    }
}
