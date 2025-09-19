<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý tin tức</title>
    <style>
        body { font-family: Arial, sans-serif; margin:0; padding:0; }
        .header { display:flex; align-items:center; justify-content:center; }
        .menu { background:#f0f0f0; padding:8px; text-align:center; }
        .menu a { margin:0 10px; text-decoration:none; color:#000; font-weight:bold; }
        .content { min-height:400px; padding:20px; }
        .footer { background:#f0f0f0; padding:8px; text-align:center; font-size:14px; }
        table { border-collapse: collapse; width:100%; }
        th, td { border:1px solid #ccc; padding:8px; text-align:left; }
        th { background:#eaeaea; }
        .btn { padding:4px 8px; text-decoration:none; border:1px solid #333; background:#ddd; border-radius:4px; }
    </style>
</head>
<body>
<!-- Header -->
<div class="header">
    <img src="images/news.jpg" alt="NEWS" style="width:100%; height:120px; object-fit:cover;">
</div>

<!-- Menu -->
<div class="menu">
    <a href="TinTucServlet?action=list&madm=1">Danh sách tin tức</a> |
    <a href="themTinTuc.jsp">Thêm tin tức mới</a> |
    <a href="quanLyTinTuc.jsp">Chức năng quản lý</a>
</div>

<!-- Nội dung -->
<div class="content">
    <jsp:include page="${pageContent}" />
</div>

<!-- Footer -->
<div class="footer">
    LuuVanPhat-22690181
</div>
</body>
</html>
