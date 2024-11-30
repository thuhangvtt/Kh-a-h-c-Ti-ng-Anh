<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Trang chủ | Quản trị viên</title>
    <meta name="description" content="Quản lý khóa học và người dùng">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <!-- CSS here -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <!-- Font từ Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&family=Quicksand:wght@400;500&display=swap" rel="stylesheet">

    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            color: #333;
        }

        .navbar {
            background-color: #FF79C6;
            padding: 15px 30px;
            border-radius: 0 0 15px 15px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .navbar-nav {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
        }

        .navbar-nav li {
            margin-left: 30px;
            position: relative;
            transition: all 0.3s ease;
        }

        .navbar-nav a {
            color: #fff;
            padding: 12px 20px;
            text-decoration: none;
            font-weight: 500;
            border-radius: 8px;
            position: relative;
            overflow: hidden;
            transition: background-color 0.3s ease, color 0.3s ease, transform 0.3s ease;
        }

        .navbar-nav a:hover {
            background-color: #FF3E97;
            color: #fff;
            transform: scale(1.05);
        }

        .navbar-nav a::before {
            content: '';
            position: absolute;
            width: 0;
            height: 2px;
            background-color: #fff;
            left: 50%;
            bottom: 0;
            transition: width 0.3s ease, left 0.3s ease;
        }

        .navbar-nav a:hover::before {
            width: 100%;
            left: 0;
        }

        .container {
            padding: 30px 50px;
        }

        h2 {
            font-size: 2.5rem;
            color: #FF79C6;
            text-align: center;
            margin-bottom: 30px;
        }

        .card {
            border: none;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
            background: #fff;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.15);
        }

        .card-body {
            padding: 25px;
        }

        .card-title {
            font-size: 1.6rem;
            color: #FF79C6;
            margin-bottom: 20px;
        }

        .btn-primary, .btn-success, .btn-info {
            font-weight: 600;
            border-radius: 25px;
            padding: 10px 25px;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .btn-primary:hover {
            background-color: #FF3E97;
            transform: scale(1.05);
        }

        .btn-success:hover {
            background-color: #00D9B1;
            transform: scale(1.05);
        }

        .btn-info:hover {
            background-color: #00C1FF;
            transform: scale(1.05);
        }

        footer {
            background-color: #FF79C6;
            color: white;
            padding: 40px 0;
            font-size: 0.9rem;
        }

        .footer-widget h5 {
            margin-bottom: 20px;
        }

        .footer-widget ul {
            list-style-type: none;
            padding: 0;
        }

        .footer-widget ul li {
            margin: 8px 0;
        }

        .footer-bottom {
            text-align: center;
            margin-top: 20px;
        }

        .footer-bottom a {
            color: #FFCC00;
            text-decoration: none;
        }

        .footer-bottom a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

    <!-- Header Start -->
    <header>
        <div class="navbar">
            <div class="container">
                <ul class="navbar-nav">
                    <li><a href="adminhome.jsp">Trang chủ</a></li>
                    <li><a href="admin-courses.jsp">Quản lý khóa học</a></li>
                    <li><a href="admin-enrollments.jsp">Quản lý người dùng</a></li>
                    <li><a href="logout.jsp">Đăng xuất</a></li>
                </ul>
            </div>
        </div>
    </header>
    <!-- Header End -->

    <!-- Main Content Start -->
    <main>
        <div class="container mt-5">
            <h2>Chào mừng bạn đến với trang quản trị</h2>
            <p class="text-center">Quản lý khóa học, người dùng và các thông tin quan trọng khác từ đây.</p>

            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="card-title">Tổng quan khóa học</h5>
                            <p class="card-text">Xem tất cả các khóa học đang được cung cấp, thêm mới, sửa đổi hoặc xóa các khóa học.</p>
                            <a href="admin-courses.jsp" class="btn btn-primary">Quản lý khóa học</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="card-title">Quản lý người dùng</h5>
                            <p class="card-text">Quản lý người dùng, xem thông tin, thay đổi quyền hạn hoặc xóa tài khoản.</p>
                            <a href="admin-enrollments.jsp" class="btn btn-success">Quản lý người dùng</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="card-title">Báo cáo thống kê</h5>
                            <p class="card-text">Xem thống kê về số lượng người dùng, khóa học và hoạt động của hệ thống.</p>
                            <a href="statistics.jsp" class="btn btn-info">Xem báo cáo</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <!-- Main Content End -->

    <!-- Footer Start -->
    <footer>
        <div class="footer-wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="footer-widget">
                            <h5>Về chúng tôi</h5>
                            <p>Chúng tôi cung cấp các khóa học chất lượng cho người học từ mọi nơi trên thế giới.</p>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="footer-widget">
                            <h5>Liên kết nhanh</h5>
                            <ul>
                                <li><a href="adminHome.jsp">Trang chủ</a></li>
                                <li><a href="admin-course.jsp">Quản lý khóa học</a></li>
                                <li><a href="admin-enrollments.jsp">Quản lý người dùng</a></li>
                                <li><a href="contact.jsp">Liên hệ</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="footer-widget">
                            <h5>Thông tin liên hệ</h5>
                            <ul>
                                <li><i class="fas fa-map-marker-alt"></i> Địa chỉ: TP.HN, Việt Nam</li>
                                <li><i class="fas fa-phone-alt"></i> Điện thoại: (+84) 971 397 361</li>
                                <li><i class="fas fa-envelope"></i> Email: vuthithuhang24cv@gmail.com</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer End -->

    <!-- JS here -->
    <script src="assets/js/jquery-3.5.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
