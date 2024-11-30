<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Khóa học</title>
</head>
<body>
    <h2>Danh sách Khóa học</h2>

    <!-- Hiển thị thông báo thành công hoặc lỗi -->
    <c:if test="${not empty param.message}">
        <p style="color: green;">${param.message}</p>
    </c:if>
    <c:if test="${not empty param.error}">
        <p style="color: red;">${param.error}</p>
    </c:if>

    <!-- Liên kết đến trang thêm mới khóa học -->
    <a href="AdminServlet?action=edit" style="margin-bottom: 15px; display: inline-block;">Thêm khóa học mới</a>

    <!-- Bảng hiển thị danh sách khóa học -->
    <table border="1" cellspacing="0" cellpadding="5" style="width: 100%; text-align: left;">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên khóa học</th>
                <th>Mô tả</th>
                <th>Danh mục</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${not empty courses}">
                    <c:forEach var="course" items="${courses}">
                        <tr>
                            <td>${course.id}</td>
                            <td>${course.name}</td>
                            <td>${course.description}</td>
                            <td>${course.categoryId}</td>
                            <td>
                                <a href="AdminServlet?action=edit&id=${course.id}">Sửa</a> |
                                <a href="AdminServlet?action=delete&id=${course.id}" onclick="return confirm('Bạn chắc chắn muốn xóa khóa học này?')">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="5" style="text-align: center;">Không có khóa học nào được tìm thấy.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</body>
</html>
