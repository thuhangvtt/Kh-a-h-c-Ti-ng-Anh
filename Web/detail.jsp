<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết khóa học</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Chi tiết khóa học</h1>
    <h2>${course.name}</h2>
    <p>${course.description}</p>

    <h3>Danh sách bài học:</h3>
    <c:choose>
        <c:when test="${not empty lessons}">
            <ul>
                <c:forEach var="lesson" items="${lessons}">
                    <li>
                        <h4>${lesson.title}</h4>
                        <p>Ngày tạo: ${lesson.createdAt}</p>
                        <p>
                        <!-- Nhúng video YouTube -->
                            <iframe width="560" height="315" 
                                src="${lesson.videoLink}" 
                                title="YouTube video player" 
                                frameborder="0" 
                                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
                                allowfullscreen>
                            </iframe>
                        </p>
                    </li>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <p>Không có bài học nào trong khóa học này.</p>
        </c:otherwise>
    </c:choose>


    <a href="home.jsp">Quay lại trang chủ</a>
</body>
</html>
