<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/7/2025
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="iuh.fit.se.bai1jspform.Student" %>
<%@ page import="iuh.fit.se.bai1jspform.Qualification" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả đăng ký</title>
</head>
<body>

<%
    Student student = (Student) request.getAttribute("student");
    List<Qualification> qualifications = student.getQualifications();
%>
<h2>Thông tin sinh viên đã đăng ký:</h2>
<ul>
    <li>Họ tên: <%= student.getFirstName() + " " + student.getLastName() %></li>
    <li>Email: <%= student.getEmail() %></li>
    <li>Giới tính: <%= student.getGender() %></li>
    <li>Ngày sinh: <%= student.getBirthdate() %></li>
    <li>Số điện thoại: <%= student.getMobileNumber() %></li>
    <li>Địa chỉ: <%= student.getAddress() + ", " + student.getCity() + ", " + student.getState() + ", " + student.getCountry() + " - " + student.getPincode() %></li>
    <li>Khóa học: <%= student.getCourse() %></li>
    <li>Sở thích: <%= student.getHobbies() %></li>

</ul>
<h2>Qualification</h2>
<table border="1">
    <tr>
        <th>Examination</th>
        <th>Board</th>
        <th>Percentage</th>
        <th>Year of Passing</th>
    </tr>
    <% for (Qualification q : qualifications) { %>
    <tr>
        <td><%= q.getExam() %></td>
        <td><%= q.getBoard() %></td>
        <td><%= q.getPercentage() %></td>
        <td><%= q.getYear() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>

