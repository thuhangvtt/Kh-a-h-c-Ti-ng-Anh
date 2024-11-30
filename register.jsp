<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" />
</head>
<body>
    <!-- Registration Form -->
    <div class="auth-wrapper">
        <div class="auth-container">
            <div class="auth-action-left">
                <div class="auth-form-outer">
                    <h2 class="auth-form-title">Đăng ký ngay</h2>
                    <form action="RegisterServlet" method="post" class="login-form">
                        <!-- Error message section -->
                        <div id="error-message" style="color: red; font-size: 14px;">
                            <!-- Servlet có th? g?n l?i qua URL -->
                            <script>
                                const urlParams = new URLSearchParams(window.location.search);
                                const error = urlParams.get('error');
                                if (error) {
                                    document.getElementById('error-message').textContent =
                                        error === 'password_mismatch' ? 'Passwords do not match!' :
                                        error === 'email_exists' ? 'Email already exists!' :
                                        error === 'signup_failed' ? 'Signup failed. Please try again.' :
                                        'An unknown error occurred.';
                                }
                            </script>
                        </div>
                        <!-- Form inputs -->
                        <input type="text" name="name" class="auth-form-input" placeholder="Name" required>
                        <input type="email" name="email" class="auth-form-input" placeholder="Email" required>
                        <div class="input-icon">
                            <input type="password" name="password" class="auth-form-input" placeholder="Password" required>
                            <i class="fa fa-eye show-password"></i>
                        </div>
                        <input type="password" name="confirmPassword" class="auth-form-input" placeholder="Confirm Password" required>
                        <label class="btn active">
                            <input type="checkbox" name="agree" checked required>
                            <i class="fa fa-square-o"></i><i class="fa fa-check-square-o"></i>
                            <span>Tôi đồng ý <a href="#">Điều khoản</a> và <a href="#">Chính sách bảo mật</a>.</span>
                        </label>
                        <div class="footer-action">
                            <input type="submit" value="Sign Up" class="auth-submit">
                            <a href="login.jsp" class="auth-btn-direct">Đăng Nhập</a>
                        </div>
                    </form>
                </div>
            </div>
            <div class="auth-action-right">
                <div class="auth-image">
                    <img src="assets/vector.jpg" alt="Registration">
                </div>
            </div>
        </div>
    </div>

    <!-- JavaScript -->
    <script>
        // Toggle password visibility
        document.querySelectorAll('.show-password').forEach(icon => {
            icon.addEventListener('click', () => {
                const input = icon.previousElementSibling;
                if (input.type === 'password') {
                    input.type = 'text';
                    icon.classList.replace('fa-eye', 'fa-eye-slash');
                } else {
                    input.type = 'password';
                    icon.classList.replace('fa-eye-slash', 'fa-eye');
                }
            });
        });
    </script>
</body>
</html>
