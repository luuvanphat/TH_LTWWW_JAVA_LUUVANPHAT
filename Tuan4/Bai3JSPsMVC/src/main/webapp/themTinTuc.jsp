<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("pageContent", "themTinTuc_content.jsp");
    RequestDispatcher rd = request.getRequestDispatcher("layout.jsp");
    rd.include(request, response);
%>
