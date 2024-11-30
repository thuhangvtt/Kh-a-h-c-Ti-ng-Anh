<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết khóa học</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            max-width: 900px;
            margin: 50px auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        h1 {
            font-size: 2.5rem;
            color: #FF79C6;
            text-align: center;
            margin-bottom: 20px;
        }
        h2 {
            font-size: 1.8rem;
            color: #FF79C6;
            margin-bottom: 20px;
        }
        p {
            font-size: 1.2rem;
            line-height: 1.6;
            margin-bottom: 20px;
        }
        .btn-learn {
            background-color: #FF79C6;
            color: white;
            padding: 12px 30px;
            border-radius: 25px;
            font-weight: 600;
            text-decoration: none;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        .btn-learn:hover {
            background-color: #FF3E97;
            transform: scale(1.05);
        }
        .btn-back {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #00C1FF;
            color: white;
            border-radius: 20px;
            text-decoration: none;
            font-weight: 600;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        .btn-back:hover {
            background-color: #00A3CC;
            transform: scale(1.05);
        }
        .status {
            background-color: #e0e0e0;
            padding: 10px;
            border-radius: 8px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .status.approved {
            background-color: #00C1FF;
            color: white;
        }
        .status.pending {
            background-color: #FFCC00;
            color: white;
        }
        .status.not-enrolled {
            background-color: #FF79C6;
            color: white;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Chi tiết khóa học</h1>

        <p><strong>Course ID:</strong> ${courseId}</p>
        <p><strong>User ID:</strong> ${userId}</p>

        <h2>Trạng thái đăng ký</h2>
        <c:choose>
            <c:when test="${userEnrolledStatus == 'approved'}">
                <div class="status approved">
                    <p>Trạng thái: đã phê duyệt</p>
                </div>
                <a href="LessonServlet?courseId=${4}" class="btn-learn">Vào học</a>
            </c:when>
            <c:when test="${userEnrolledStatus == 'pending'}">
                <div class="status pending">
                    <p>Trạng thái: Chờ phê duyệt</p>
                </div>
            </c:when>
            <c:otherwise>
                <div class="status not-enrolled">
                    <p>Trạng thái: Chưa đăng ký</p>
                </div>
            </c:otherwise>
        </c:choose>

        <a href="home.jsp" class="btn-back">Quay lại trang chủ</a>
    </div>

</body>
</html>
