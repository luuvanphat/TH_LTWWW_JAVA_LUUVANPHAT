package iuh.fit.se.controller;

import iuh.fit.se.model.ProductList;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/products")
public class ProductListController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("products", ProductList.getAll());
        req.getRequestDispatcher("ModelList.jsp").forward(req, resp);
    }
}

