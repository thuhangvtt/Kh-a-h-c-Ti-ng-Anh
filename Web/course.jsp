<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>course</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css"> <!-- Kết nối CSS của bạn -->
</head>
<body>
    <div id="wrapper">
        <%-- Include Header --%>
        <jsp:include page="header.jsp" />
        <div id="wp-products">
            <h2>KHÓA HỌC CỦA CHÚNG TÔI</h2>
            <div class="list-products">
                <c:forEach var="course" items="${product}">
                    <div class="course">
                        <h2>${course.name}</h2>
                        <p>${course.description}</p>
                        <a href="LessonServlet?courseId=${course.id}" class="btn">Xem Chi Tiết</a>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div id="saleoff">
            <div class="form-box">
                <div class="full-screen-bg">
                    <img src="image/anhnen_rounded.png" alt="Tư vấn miễn phí">
                </div>
                <h2>Gửi yêu cầu tư vấn miễn phí</h2>
                <p>Vui lòng để lại số điện thoại, chúng tôi sẽ liên hệ tư vấn bạn trong thời gian sớm nhất.</p>
                <form action="#">
                    <input type="text" placeholder="Số điện thoại..." required>
                    <button type="submit">Đăng Ký &rarr;</button>
                </form>
            </div>
        </div>
        <%-- Include Footer --%>
        <jsp:include page="footer.jsp" />
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>