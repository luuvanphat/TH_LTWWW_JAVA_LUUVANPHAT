<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, iuh.fit.se.model.TinTuc" %>
<%
    List<TinTuc> listTin = (List<TinTuc>) request.getAttribute("listTin");
    request.setAttribute("pageContent", "quanLyTinTuc_content.jsp");
    RequestDispatcher rd = request.getRequestDispatcher("layout.jsp");
    rd.include(request, response);
%>
