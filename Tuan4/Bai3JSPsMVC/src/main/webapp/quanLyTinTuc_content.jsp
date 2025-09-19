<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, iuh.fit.se.model.TinTuc" %>
<%
    List<TinTuc> listTin = (List<TinTuc>) request.getAttribute("listTin");
%>
<h2>Quản lý tin tức</h2>
<table>
    <tr>
        <th>Mã TT</th>
        <th>Tiêu đề</th>
        <th>Thao tác</th>
    </tr>
    <%
        if (listTin != null) {
            for (TinTuc t : listTin) {
    %>
    <tr>
        <td><%=t.getMaTT()%></td>
        <td><%=t.getTieuDe()%></td>
        <td>
            <a class="btn" href="TinTucServlet?action=delete&matt=<%=t.getMaTT()%>">Xóa</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
