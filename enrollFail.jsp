<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông báo</title>
        <style>
            /* Đặt màu nền hồng cho toàn trang */
            body {
                background-color: #FF79C6;
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                height: 100vh;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                color: white;
            }

            /* Căn giữa nội dung trong trang */
            .content {
                text-align: center;
                margin-bottom: 50px;
            }

            /* Định dạng cho các tiêu đề */
            h1 {
                font-size: 2rem;
                margin: 10px 0;
            }

            /* Liên kết quay lại trang chủ ở góc dưới cùng */
            .back-home {
                position: absolute;
                bottom: 20px;
                font-weight: bold;
                font-size: 18px;
                background-color: #FF3E97;
                color: white;
                padding: 12px 30px;
                border-radius: 25px;
                text-decoration: none;
                text-align: center;
                transition: background-color 0.3s ease;
            }

            /* Thêm hiệu ứng hover cho nút */
            .back-home:hover {
                background-color: #FF1493;
            }
        </style>
    </head>
    <body>
        <div class="content">
            <h1>Bạn đã đăng ký thất bại!</h1>
            <h1>Do bạn đã đăng ký khóa học rồi.</h1>
        </div>

        <!-- Liên kết quay lại trang chủ -->
        <a href="home.jsp" class="back-home">Quay lại trang chủ</a>
    </body>
</html>
