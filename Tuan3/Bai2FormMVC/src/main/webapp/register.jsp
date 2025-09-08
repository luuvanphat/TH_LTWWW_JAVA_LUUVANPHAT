<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/8/2025
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User Registration Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow-lg p-4" style="max-width: 500px; margin: auto;">
        <h3 class="text-center mb-4">User Registration Form</h3>
        <form action="register" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="text" class="form-control" name="firstName" placeholder="First Name" required>
                </div>
                <div class="form-group col-md-6">
                    <input type="text" class="form-control" name="lastName" placeholder="Last Name" required>
                </div>
            </div>

            <div class="form-group">
                <input type="email" class="form-control" name="email" placeholder="Your Email" required>
            </div>

            <div class="form-group">
                <input type="email" class="form-control" name="reemail" placeholder="Re-enter Email" required>
            </div>

            <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="New Password" required>
            </div>

            <label>Birthday</label>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <select class="form-control" name="month">
                        <option>Month</option>
                        <% for(int i=1;i<=12;i++){ %>
                        <option value="<%=i%>"><%=i%></option>
                        <% } %>
                    </select>
                </div>
                <div class="form-group col-md-4">
                    <select class="form-control" name="day">
                        <option>Day</option>
                        <% for(int i=1;i<=31;i++){ %>
                        <option value="<%=i%>"><%=i%></option>
                        <% } %>
                    </select>
                </div>
                <div class="form-group col-md-4">
                    <select class="form-control" name="year">
                        <option>Year</option>
                        <% for(int i=2025;i>=1950;i--){ %>
                        <option value="<%=i%>"><%=i%></option>
                        <% } %>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label>Gender</label><br>
                <input type="radio" name="gender" value="Female"> Female
                <input type="radio" name="gender" value="Male"> Male
            </div>

            <button type="submit" class="btn btn-primary btn-block">Sign Up</button>
        </form>
    </div>
</div>
</body>
</html>
