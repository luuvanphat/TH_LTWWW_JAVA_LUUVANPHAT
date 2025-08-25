package iuh.fit.se;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

public class Bai4 extends HttpServlet {
    private String adminEmail;
    private String appName;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        adminEmail = config.getInitParameter("adminEmail");

        ServletContext context = config.getServletContext();
        appName = context.getInitParameter("appName");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h2>GET Request</h2>");
        resp.getWriter().println("<p>Application: " + appName + "</p>");
        resp.getWriter().println("<p>Contact admin: " + adminEmail + "</p>");
        resp.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");

        resp.getWriter().println("<html><body>");
        resp.getWriter().println("<h2>POST Request</h2>");
        resp.getWriter().println("<p>Xin chào, " + username + "</p>");
        resp.getWriter().println("<p>Ứng dụng: " + appName + "</p>");
        resp.getWriter().println("</body></html>");
    }
}
