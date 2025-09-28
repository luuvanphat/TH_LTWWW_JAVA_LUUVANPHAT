<%--<%@ page contentType="text/html; charset=UTF-8" %>--%>
<%--<%@ page import="iuh.fit.se.model.Product" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<html>--%>
<%--<head><title>Danh sách sản phẩm</title></head>--%>
<%--<body>--%>
<%--<h2>Danh sách sản phẩm</h2>--%>
<%--<%--%>
<%--  List<Product> products = (List<Product>) request.getAttribute("products");--%>
<%--  for (Product p : products) {--%>
<%--%>--%>
<%--<form action="cart" method="post">--%>
<%--  <%= p.getName() %> - <%= p.getPrice() %> $--%>
<%--  <input type="hidden" name="id" value="<%= p.getId() %>"/>--%>
<%--  <input type="hidden" name="action" value="add"/>--%>
<%--  Số lượng: <input type="number" name="qty" value="1" min="1"/>--%>
<%--  <input type="submit" value="Thêm vào giỏ"/>--%>
<%--</form>--%>
<%--<br/>--%>
<%--<% } %>--%>
<%--<a href="ShoppingCart.jsp">Xem giỏ hàng</a>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="iuh.fit.se.model.Product" %>
<%@ page import="java.util.List" %>
<html>
<head>
  <title>Danh sách sản phẩm</title>
  <style>
    body { font-family: Arial, sans-serif; }
    .product-grid {
      display: grid;
      grid-template-columns: repeat(3, 1fr);
      gap: 20px;
      margin: 20px;
    }
    .product-card {
      border: 1px solid #ccc;
      border-radius: 8px;
      padding: 15px;
      text-align: center;
      box-shadow: 2px 2px 5px rgba(0,0,0,0.1);
    }
    .product-card img {
      max-width: 120px;
      height: auto;
      margin-bottom: 10px;
    }
    .product-card h3 {
      margin: 5px 0;
    }
    .product-card p {
      margin: 5px 0;
      font-weight: bold;
      color: #333;
    }
    .product-card input[type=number] {
      width: 50px;
      text-align: center;
    }
    .product-card input[type=submit] {
      margin-top: 10px;
      padding: 5px 10px;
      border: none;
      background-color: #28a745;
      color: white;
      border-radius: 4px;
      cursor: pointer;
    }
    .product-card input[type=submit]:hover {
      background-color: #218838;
    }
    .cart-link {
      margin: 20px;
      display: inline-block;
    }
  </style>
</head>
<body>
<a class="cart-link" href="ShoppingCart.jsp">View Cart</a>
<h2>Danh sách sản phẩm</h2>
<div class="product-grid">
  <%
    List<Product> products = (List<Product>) request.getAttribute("products");
    for (Product p : products) {
  %>
  <div class="product-card">
    <img src="images/<%= p.getId() %>.jpg" alt="<%= p.getName() %>"/>
    <h3><%= p.getName() %></h3>
    <p>Price: <%= p.getPrice() %></p>

    <form action="cart" method="post">
      <input type="hidden" name="id" value="<%= p.getId() %>"/>
      <input type="hidden" name="action" value="add"/>
      <input type="number" name="qty" value="1" min="1"/>
      <br/>
      <input type="submit" value="Add To Cart"/>
    </form>
  </div>
  <% } %>
</div>
</body>
</html>

