package iuh.fit.se.controller;

import iuh.fit.se.dao.TinTucDAO;
import iuh.fit.se.model.TinTuc;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/TinTucServlet")
public class TinTucServlet extends HttpServlet {
    private TinTucDAO dao = new TinTucDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "delete":
                int maTT = Integer.parseInt(request.getParameter("matt"));
                dao.deleteTinTuc(maTT);
                response.sendRedirect("TinTucServlet?action=list");
                break;
            case "list":
            default:
                List<TinTuc> list = dao.getAllTinTuc();
                request.setAttribute("listTin", list);
                RequestDispatcher rd = request.getRequestDispatcher("listTinTuc.jsp");
                rd.forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tieude = request.getParameter("tieude");
        String noidung = request.getParameter("noidung");
        String lienket = request.getParameter("lienket");
        int madm = Integer.parseInt(request.getParameter("madm"));

        TinTuc t = new TinTuc(0, tieude, noidung, lienket, madm);
        dao.insertTinTuc(t);

        response.sendRedirect("TinTucServlet?action=list");
    }
}

