package iuh.fit.se.bai2formmvc.controller;

import iuh.fit.se.bai2formmvc.model.User;
import iuh.fit.se.bai2formmvc.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("year") + "-" +
                request.getParameter("month") + "-" +
                request.getParameter("day");

        User user = new User(firstName, lastName, email, password, gender, birthday);
        userDAO.insertUser(user);

        request.setAttribute("userList", userDAO.getAllUsers());
        request.getRequestDispatcher("listUsers.jsp").forward(request, response);
    }
}

