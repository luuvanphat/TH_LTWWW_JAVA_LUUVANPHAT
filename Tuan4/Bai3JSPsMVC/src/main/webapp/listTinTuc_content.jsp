<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, iuh.fit.se.model.TinTuc" %>
<%
    List<TinTuc> listTin = (List<TinTuc>) request.getAttribute("listTin");
%>
<h2>Danh sách tin tức</h2>
<table>
    <tr>
        <th>Mã TT</th>
        <th>Tiêu đề</th>
        <th>Nội dung</th>
        <th>Liên kết</th>
        <th>Danh mục</th>
    </tr>
    <%
        if (listTin != null) {
            for (TinTuc t : listTin) {
    %>
    <tr>
        <td><%=t.getMaTT()%></td>
        <td><%=t.getTieuDe()%></td>
        <td><%=t.getNoiDungTT()%></td>
        <td><a href="<%=t.getLienKet()%>" target="_blank">Xem</a></td>
        <td><%=t.getMaDM()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
