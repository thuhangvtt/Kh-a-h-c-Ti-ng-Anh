<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" />
</head>
<body>
    <!-- Form without bootstrap -->
    <div class="auth-wrapper">
        <div class="auth-container">
            <div class="auth-action-left">
                <div class="auth-form-outer">
                    <h2 class="auth-form-title">
                        Đăng nhập
                    </h2>

                    <form action="LoginServlet" method="post" class="login-form">
                        <!-- Thêm thuộc tính name -->
                        <input type="email" name="email" class="auth-form-input" placeholder="Email" required>
                        <div class="input-icon">
                            <input type="password" name="password" class="auth-form-input" placeholder="Password" required>
                            <i class="fa fa-eye show-password"></i>
                        </div>

                        <div class="footer-action">
                            <input type="submit" value="Đăng nhập" class="auth-submit">
                            <a href="register.jsp" class="auth-btn-direct">Đăng ký</a>
                        </div>
                    </form>

                </div>
            </div>
            <div class="auth-action-right">
                <div class="auth-image">
                    <img src="assets/vector.jpg" alt="login">
                </div>
            </div>
        </div>
    </div>
    <script src="js/common.js"></script>
</body>
</html>
