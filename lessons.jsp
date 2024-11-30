<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết khóa học</title>
    <link rel="stylesheet" href="style.css">
    <style>
        /* Thiết lập bố cục cơ bản */
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f7fc;
            color: #333;
        }

        .container {
            display: flex;
            justify-content: space-between;
            padding: 30px;
            max-width: 1200px;
            margin: 0 auto;
        }

        /* Cột Danh sách bài giảng */
        .lesson-list {
            width: 75%;
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .lesson-item {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            transition: transform 0.3s ease;
            border-left: 5px solid #00C1FF;
        }

        .lesson-item:hover {
            transform: translateY(-5px);
        }

        .lesson-item h4 {
            margin: 0;
            font-size: 1.4rem;
            color: #333;
        }

        .lesson-item p.lesson-date {
            font-size: 1rem;
            color: #888;
        }

        .lesson-item .btn-learn {
            margin-top: 15px;
            background-color: #00C1FF;
        }

        .lesson-item .btn-learn:hover {
            background-color: #009BCC;
        }

        /* Cột Menu bên phải */
        .sidebar {
            width: 20%;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        .sidebar h3 {
            font-size: 1.6rem;
            color: #00C1FF;
            margin-top: 0;
        }

        .sidebar a {
            display: block;
            font-size: 1.2rem;
            color: #333;
            text-decoration: none;
            padding: 12px;
            margin: 10px 0;
            border-radius: 5px;
            background-color: #f0f8ff;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .sidebar a:hover {
            background-color: #00C1FF;
            color: white;
            transform: scale(1.05);
        }

        /* Style cho nút quay lại trang chủ */
        .back-to-home {
            display: inline-block;
            margin-top: 30px;
            padding: 12px 30px;
            background-color: #FF79C6;
            color: white;
            border-radius: 25px;
            text-decoration: none;
            font-weight: 600;
            text-align: center;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .back-to-home:hover {
            background-color: #FF3E97;
            transform: scale(1.05);
        }

    </style>
</head>
<body>

    <div class="container">
        <!-- Danh sách bài giảng -->
        <div class="lesson-list">
            <h2 style="color: #00C1FF;">Danh sách bài giảng</h2>
            <c:choose>
                <c:when test="${not empty lessons}">
                    <c:forEach var="lesson" items="${lessons}">
                        <div class="lesson-item">
                            <h4>${lesson.title}</h4>
                            <p class="lesson-date">Ngày tạo: ${lesson.createdAt}</p>
                            <a href="videodetail.jsp?lessonId=${lesson.id}&videoLink=${lesson.videoLink}" class="btn-learn">Vào học</a>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p>Không có bài học nào trong khóa học này.</p>
                </c:otherwise>
            </c:choose>
        </div>

        <!-- Thanh điều hướng bên phải (Menu) -->
        <div class="sidebar">
            <h3>Menu</h3>
            <a href="home.jsp">Trang chủ</a>
            <a href="CourseServlet?categoryid=1">Khóa học của tôi</a>
            <a href="logout.jsp">Đăng xuất</a>
        </div>
    </div>

    <a href="home.jsp" class="back-to-home">Quay lại trang chủ</a>

</body>
</html>
