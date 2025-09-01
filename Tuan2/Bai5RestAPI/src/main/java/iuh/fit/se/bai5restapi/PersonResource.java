package iuh.fit.se.bai5restapi;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/api/person")
public class PersonResource extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");

        // tạo 1 person demo
        Person p = new Person("Luu Van Phat", 21);

        // trả JSON
        String json = gson.toJson(p);
        resp.getWriter().write(json);
    }
}

