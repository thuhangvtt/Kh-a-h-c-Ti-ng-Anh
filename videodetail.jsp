<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết bài giảng</title>
    <link rel="stylesheet" href="style.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fc;
            margin: 0;
            padding: 0;
            color: #333;
        }

        /* Trung tâm nội dung trang */
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            min-height: 100vh;
            padding: 20px;
        }

        h1 {
            color: #00C1FF;
            font-size: 2rem;
            margin-bottom: 20px;
        }

        h2 {
            color: #333;
            font-size: 1.5rem;
            margin-bottom: 20px;
        }

        /* Căn giữa video */
        .video-container {
            display: flex;
            justify-content: center;
            width: 100%;
            max-width: 1200px; /* Giới hạn chiều rộng tối đa */
            margin-top: 20px;
        }

        iframe {
            width: 100%; /* Chiếm 100% chiều rộng */
            height: 600px; /* Tăng chiều cao */
            max-width: 1000px; /* Giới hạn chiều rộng tối đa của video */
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 30px;
            background-color: #FF79C6;
            color: white;
            text-decoration: none;
            border-radius: 25px;
            font-weight: 600;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        a:hover {
            background-color: #FF3E97;
            transform: scale(1.05);
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Chi tiết bài giảng</h1>

        <c:if test="${not empty param.lessonId}">
            <h2>Bài giảng: ${param.lessonId}</h2>
            <p>Video:</p>

            <!-- Hiển thị video từ URL truyền vào -->
            <div class="video-container">
                <iframe src="${param.videoLink}" 
                        title="YouTube video player" 
                        frameborder="0" 
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
                        allowfullscreen>
                </iframe>
            </div>
        </c:if>

        <a href="home.jsp">Quay lại khóa học</a>
    </div>

</body>
</html>
