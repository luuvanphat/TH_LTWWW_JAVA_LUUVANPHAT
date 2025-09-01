package iuh.fit.se.bai5restapi;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/api/number/*")
public class NumberResource extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");

        // URL dạng: /api/number/5
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.getWriter().write("{\"error\":\"Missing number\"}");
            return;
        }

        try {
            int n = Integer.parseInt(pathInfo.substring(1));

            // trả kết quả JSON
            String json = String.format("{\"number\": %d, \"square\": %d}", n, n*n);
            resp.getWriter().write(json);

        } catch (NumberFormatException e) {
            resp.getWriter().write("{\"error\":\"Invalid number\"}");
        }
    }
}

