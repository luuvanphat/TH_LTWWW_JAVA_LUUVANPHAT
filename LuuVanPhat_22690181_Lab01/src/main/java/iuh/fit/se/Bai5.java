package iuh.fit.se;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bai5")
public class Bai5 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String facebook = request.getParameter("facebook");
        String shortBio = request.getParameter("shortBio");

        String html =
                "<html>" +
                        "<head><title>Kết quả đăng ký</title></head>" +
                        "<body>" +
                        "<h2>Thông tin vừa đăng ký</h2>" +
                        "<p><b>Họ tên:</b> " + name + "</p>" +
                        "<p><b>Email:</b> " + email + "</p>" +
                        "<p><b>Facebook:</b> " + facebook + "</p>" +
                        "<p><b>Mô tả:</b> " + shortBio + "</p>" +
                        "</body></html>";

        out.println(html);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect("bai5.html");
    }
}
