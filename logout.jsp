<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logout</title>
</head>
<body>
    <%
        // Xóa tất cả các thuộc tính trong session
        session.invalidate(); // Hủy session hiện tại

        // Chuyển hướng về trang đăng nhập
        response.sendRedirect("login.jsp");
    %>
</body>
</html>
