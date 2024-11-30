<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm / Sửa Khóa học</title>
</head>
<body>
    <h2><c:if test="${empty course.id}">Thêm khóa học</c:if><c:if test="${not empty course.id}">Sửa khóa học</c:if></h2>

    <form action="AdminServlet" method="post">
        <input type="hidden" name="action" value="<c:if test="${empty course.id}">add<else/>edit</c:if>">
        <c:if test="${not empty course.id}">
            <input type="hidden" name="id" value="${course.id}">
        </c:if>

        <label for="name">Tên khóa học:</label>
        <input type="text" id="name" name="name" value="${course.name}" required><br><br>

        <label for="description">Mô tả:</label>
        <textarea id="description" name="description" required>${course.description}</textarea><br><br>

        <label for="categoryId">Danh mục:</label>
        <input type="text" id="categoryId" name="categoryId" value="${course.categoryId}" required><br><br>

        <input type="submit" value="<c:if test="${empty course.id}">Thêm mới</c:if><c:if test="${not empty course.id}">Cập nhật</c:if>">
    </form>

    <br>
    <a href="AdminServlet?action=list">Quay lại danh sách</a>
</body>
</html>
