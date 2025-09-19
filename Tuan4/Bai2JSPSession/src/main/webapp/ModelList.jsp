<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/8/2025
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="iuh.fit.se.model.Product" %>
<%@ page import="java.util.List" %>
<html>
<head><title>Danh sách sản phẩm</title></head>
<body>
<h2>Danh sách sản phẩm</h2>
<%
  List<Product> products = (List<Product>) request.getAttribute("products");
  for (Product p : products) {
%>
<form action="cart" method="post">
  <%= p.getName() %> - <%= p.getPrice() %> $
  <input type="hidden" name="id" value="<%= p.getId() %>"/>
  <input type="hidden" name="action" value="add"/>
  Số lượng: <input type="number" name="qty" value="1" min="1"/>
  <input type="submit" value="Thêm vào giỏ"/>
</form>
<br/>
<% } %>
<a href="ShoppingCart.jsp">Xem giỏ hàng</a>
</body>
</html>

