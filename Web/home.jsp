<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web học tiếng anh</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css?v=${System.currentTimeMillis()}">
</head>

<body>


    <div id="wrapper">
        <%-- Include Header --%>
        <jsp:include page="header.jsp" />
        <div id="banner">
            <div class="box-left">
                <h2>
                    <span>NỀN TẢNG HỌC TIẾNG ANH</span>
                    <br>
                    <span>THÔNG MINH </span>
                </h2>
                <p>Trang web học tiếng Anh của chúng tôi cung cấp khóa học đa dạng ,
                    giúp bạn nâng cao kỹ năng ngôn ngữ một cách hiệu quả và thú vị.
                    Hãy bắt đầu hành trình chinh phục tiếng Anh ngay hôm nay!</p>
                <button>Bắt đầu</button>
            </div>
            <!--<div class="box-right">
                <img src="assets/img_1.png" alt="">s
                <img src="assets/img_2.png" alt="">
                <img src="assets/img_3.png" alt="">
            </div>-->
            <div class="to-bottom">
                <a href="">
                    <img src="image/to_bottom.png" alt="">
                </a>
            </div>
        </div>
        <div id="wp-products">
            <h2>KHÓA HỌC CỦA CHÚNG TÔI</h2>
            <div class="list-products">
                <c:forEach var="course" items="${courses}">
                    <div class="course">
                        <h2>${course.name}</h2>
                        <p>${course.description}</p>
                        <a href="CourseServlet?categoryid=${course.id}" class="btn">Xem Chi Tiết</a>
                    </div>
                </c:forEach>
            </div>
            
        </div>

        <div id="saleoff">
            <h2>Gửi yêu cầu tư vấn miễn phí</h2>
            <p>Vui lòng để lại số điện thoại, chúng tôi sẽ liên hệ tư vấn bạn trong thời gian sớm nhất.</p>
            <form action="#">
                <input type="text" placeholder="Số điện thoại..." required>
                <button type="submit">Đăng Ký &rarr;</button>
            </form>
        </div>

        <div id="comment">
            <h2>NHẬN XÉT CỦA HỌC VIÊN</h2>
            <div id="comment-body">
                <div class="prev">
                    <a href="#">
                        <img src="assets/prev.png" alt="">
                    </a>
                </div>
                <ul id="list-comment">
                    <li class="item">
                        <div class="avatar">
                            <img src="assets/avatar_1.png" alt="">

                        </div>
                        <div class="stars">
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                        </div>
                        <div class="name">Nguyễn Đình Vũ</div>

                        <div class="text">
                            <p>Lorem Ipsum is simply dummy text of the printing and
                                typesetting industry. Lorem Ipsum has been the industry's
                                standard dummy text ever since the 1500s, when an unknown
                                printer took a galley of type and scrambled it to make a type
                                specimen book.</p>
                        </div>
                    </li>
                    <li class="item">
                        <div class="avatar">
                            <img src="assets/avatar_1.png" alt="">

                        </div>
                        <div class="stars">
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                        </div>
                        <div class="name">Trần Ngọc Sơn</div>

                        <div class="text">
                            <p>Lorem Ipsum is simply dummy text of the printing and
                                typesetting industry. Lorem Ipsum has been the industry's
                                standard dummy text ever since the 1500s, when an unknown
                                printer took a galley of type and scrambled it to make a type
                                specimen book.</p>
                        </div>
                    </li>
                    <li class="item">
                        <div class="avatar">
                            <img src="assets/avatar_1.png" alt="">

                        </div>
                        <div class="stars">
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                            <span>
                                <img src="assets/star.png" alt="">
                            </span>
                        </div>
                        <div class="name">Nguyễn Trần Vi</div>

                        <div class="text">
                            <p>Lorem Ipsum is simply dummy text of the printing and
                                typesetting industry. Lorem Ipsum has been the industry's
                                standard dummy text ever since the 1500s, when an unknown
                                printer took a galley of type and scrambled it to make a type
                                specimen book.</p>
                        </div>
                    </li>
                </ul>
                <div class="next">
                    <a href="#">
                        <img src="assets/next.png" alt="">
                    </a>
                </div>
            </div>
        </div>

        <%-- Include Footer --%>
        <jsp:include page="footer.jsp" />
    </div>
    <script src="script.js"></script>
</body>

</html>