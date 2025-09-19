package iuh.fit.se.controller;


import iuh.fit.se.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartBean();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");
        String id = req.getParameter("id");

        if ("add".equals(action)) {
            int qty = 1;
            try {
                qty = Integer.parseInt(req.getParameter("qty"));
            } catch (Exception ignored) {}
            Product p = ProductList.getById(id);
            if (p != null) {
                cart.addProduct(p, qty);
            }
        } else if ("remove".equals(action)) {
            cart.removeProduct(id);
        } else if ("update".equals(action)) {
            int qty = Integer.parseInt(req.getParameter("qty"));
            cart.updateProduct(id, qty);
        }

        resp.sendRedirect("ShoppingCart.jsp");
    }
}

