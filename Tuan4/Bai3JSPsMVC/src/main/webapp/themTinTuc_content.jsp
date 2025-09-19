<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Thêm tin tức mới</h2>
<form action="TinTucServlet" method="post">
    <label>Tiêu đề:</label><br>
    <input type="text" name="tieude" required><br><br>

    <label>Nội dung:</label><br>
    <textarea name="noidung" rows="5" cols="50" required></textarea><br><br>

    <label>Liên kết:</label><br>
    <input type="text" name="lienket"><br><br>

    <label>Mã danh mục:</label><br>
    <input type="number" name="madm" required><br><br>

    <input type="submit" value="Thêm tin">
</form>
