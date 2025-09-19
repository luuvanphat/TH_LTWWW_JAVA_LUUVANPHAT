<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/8/2025
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="iuh.fit.se.model.CartBean, iuh.fit.se.model.CartItemBean" %>
<%@ page import="java.util.*" %>
<html>
<head><title>Giỏ hàng</title></head>
<body>
<h2>Giỏ hàng</h2>
<%
    CartBean cart = (CartBean) session.getAttribute("cart");
    if (cart == null || cart.isEmpty()) {
%>
<p>Giỏ hàng trống!</p>
<% } else { %>
<table border="1">
    <tr><th>Tên SP</th><th>SL</th><th>Giá</th><th>Thành tiền</th><th>Action</th></tr>
    <%
        for (CartItemBean item : cart.getItems()) {
    %>
    <tr>
        <td><%= item.getProduct().getName() %></td>
        <td>
            <form action="cart" method="post" style="display:inline;">
                <input type="number" name="qty" value="<%= item.getQuantity() %>"/>
                <input type="hidden" name="id" value="<%= item.getProduct().getId() %>"/>
                <input type="hidden" name="action" value="update"/>
                <input type="submit" value="Cập nhật"/>
            </form>
        </td>
        <td><%= item.getProduct().getPrice() %></td>
        <td><%= item.getProduct().getPrice() * item.getQuantity() %></td>
        <td>
            <form action="cart" method="post" style="display:inline;">
                <input type="hidden" name="id" value="<%= item.getProduct().getId() %>"/>
                <input type="hidden" name="action" value="remove"/>
                <input type="submit" value="Xóa"/>
            </form>
        </td>
    </tr>
    <% } %>
</table>
<p>Tổng cộng: <%= cart.getTotal() %> $</p>
<% } %>
<a href="products">Quay lại danh sách sản phẩm</a>
</body>
</html>

