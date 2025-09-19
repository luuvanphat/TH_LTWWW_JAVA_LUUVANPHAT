<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.se.bai2formmvc.model.User" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h2>Registered Users</h2>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Gender</th><th>Birthday</th></tr>
    <%
        List<User> list = (List<User>) request.getAttribute("userList");
        if (list != null) {
            for (User u : list) {
    %>
    <tr>
        <td><%=u.getId()%></td>
        <td><%=u.getFirstName()%> <%=u.getLastName()%></td>
        <td><%=u.getEmail()%></td>
        <td><%=u.getGender()%></td>
        <td><%=u.getBirthday()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
