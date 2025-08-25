package iuh.fit.se;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        urlPatterns = {"/bai4Anno"},
        initParams = {
                @WebInitParam(name = "adminEmail", value = "admin@annotation.com")
        }
)
public class Bai4Anno extends HttpServlet {
    private String adminEmail;
    private String appName;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        adminEmail = config.getInitParameter("adminEmail");

        ServletContext context = config.getServletContext();
        // context-param này vẫn đọc từ web.xml (nếu có)
        appName = context.getInitParameter("appName");
        if (appName == null) {
            appName = "Ứng dụng Bai4 (Annotation)";
        }
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

