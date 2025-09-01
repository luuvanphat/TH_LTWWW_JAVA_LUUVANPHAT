package iuh.fit.se.bai4cdi;

import iuh.fit.se.bai4cdi.User;
import iuh.fit.se.bai4cdi.UserService;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        User user = userService.getUser();

        resp.setContentType("application/json;charset=UTF-8");
        String json = new Gson().toJson(user);
        resp.getWriter().write(json);
    }
}

