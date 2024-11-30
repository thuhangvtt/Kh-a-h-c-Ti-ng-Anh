<%-- 
    Document   : index
    Created on : Nov 27, 2024, 9:01:48 PM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Khóa học | Education</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <!-- CSS here -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/slicknav.css">
        <link rel="stylesheet" href="assets/css/flaticon.css">
        <link rel="stylesheet" href="assets/css/progressbar_barfiller.css">
        <link rel="stylesheet" href="assets/css/gijgo.css">
        <link rel="stylesheet" href="assets/css/animate.min.css">
        <link rel="stylesheet" href="assets/css/animated-headline.css">
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/slick.css">
        <link rel="stylesheet" href="assets/css/nice-select.css">
        <link rel="stylesheet" href="assets/css/style.css">

    </head>

    <body>
        <!-- ? Preloader Start -->
        <div id="preloader-active">
            <div class="preloader d-flex align-items-center justify-content-center">
                <div class="preloader-inner position-relative">
                    <div class="preloader-circle"></div>
                    <div class="preloader-img pere-text">
                        <img src="assets/img/logo/loder.png" alt="">
                    </div>
                </div>
            </div>
        </div>
        <!-- Preloader Start -->
        <header>
            <%-- Include Header --%>
            <jsp:include page="header.jsp" />
            <!-- Header End -->
        </header>
        <main>
            <!--? slider Area Start-->
            <section class="slider-area ">
                <div class="slider-active">
                    <!-- Single Slider -->
                    <div class="single-slider slider-height d-flex align-items-center">
                        <div class="container">
                            <div class="row">
                                <div class="col-xl-6 col-lg-7 col-md-12">
                                    <div class="hero__caption">
                                        <h1 data-animation="fadeInLeft" data-delay="0.2s">Nền tảng học<br> Tiếng Anh thông minh</h1>
                                        <p data-animation="fadeInLeft" data-delay="0.4s">Trang web học tiếng Anh của chúng tôi cung cấp khóa học đa dạng ,
                                            giúp bạn nâng cao kỹ năng ngôn ngữ một cách hiệu quả và thú vị.
                                            Hãy bắt đầu hành trình chinh phục tiếng Anh ngay hôm nay!</p>
                                        <a href="course.jsp" class="btn hero-btn" data-animation="fadeInLeft" data-delay="0.7s">Khám phá ngay</a>
                                    </div>
                                </div>
                            </div>
                        </div>          
                    </div>
                </div>
            </section>
            <!-- ? services-area -->
            <div class="services-area">
                <div class="container">
                    <div class="row justify-content-sm-center">
                        <div class="col-lg-4 col-md-6 col-sm-8">
                            <div class="single-services mb-30">
                                <div class="features-icon">
                                    <img src="assets/img/icon/icon1.svg" alt="">
                                </div>
                                <div class="features-caption">
                                    <h3>Tài liệu học phong phú</h3>
                                    <p>Được soạn bởi các thạc sĩ, tiến sĩ đầu ngành.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 col-sm-8">
                            <div class="single-services mb-30">
                                <div class="features-icon">
                                    <img src="assets/img/icon/icon2.svg" alt="">
                                </div>
                                <div class="features-caption">
                                    <h3>Giáo viên chuyên nghiệp</h3>
                                    <p>Nhiều kinh nghiệm và phương pháp học hiệu quả.</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 col-sm-8">
                            <div class="single-services mb-30">
                                <div class="features-icon">
                                    <img src="assets/img/icon/icon3.svg" alt="">
                                </div>
                                <div class="features-caption">
                                    <h3>Thời gian học linh hoạt</h3>
                                    <p>Có thể học bất cứ nơi đâu, bất cứ khi nào.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Courses area start -->
            <div class="course-container">
    <div class="container">
        <div class="row">
            <!-- Lặp qua danh sách các khóa học -->
            <c:forEach var="course" items="${courses}">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="course-card">
                        <div class="course-card-img">
                            <a href="CourseServlet?categoryid=${course.id}">
                                <img src="images/1.png" alt="${course.name}">
                            </a>
                        </div>
                        <div class="course-card-info">
                            <h3><a href="CourseServlet?categoryid=${course.id}">${course.name}</a></h3>
                            <p class="course-description">${course.description}</p>
                            <a href="CourseServlet?categoryid=${course.id}" class="course-btn">Khám phá ngay</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

            <!-- Courses area End -->
            <!--? About Area-1 Start -->
            <section class="about-area1 fix pt-10">
                <div class="support-wrapper align-items-center">
                    <div class="left-content1">
                        <div class="about-icon">
                            <img src="assets/img/icon/about.svg" alt="">
                        </div>
                        <!-- section tittle -->
                        <div class="section-tittle section-tittle2 mb-55">
                            <div class="front-text">
                                <h2 class="">Khóa Học Tiếng Anh – TOEIC, IELTS, Giao Tiếp</h2>
                                <p>Khóa học giúp bạn nâng cao điểm số TOEIC, IELTS và cải thiện kỹ năng giao tiếp tiếng Anh qua các phương pháp học hiệu quả.</p>
                            </div>
                        </div>
                        <div class="single-features">
                            <div class="features-icon">
                                <img src="assets/img/icon/right-icon.svg" alt="">
                            </div>
                            <div class="features-caption">
                                <p> Phát âm, từ vựng và giao tiếp tự nhiên trong công việc, du lịch.</p>
                            </div>
                        </div>
                        <div class="single-features">
                            <div class="features-icon">
                                <img src="assets/img/icon/right-icon.svg" alt="">
                            </div>
                            <div class="features-caption">
                                <p>TOEIC & IELTS: Chuẩn bị kiến thức, kỹ năng làm bài thi và chiến lược đạt điểm cao.</p>
                            </div>
                        </div>

                        <div class="single-features">
                            <div class="features-icon">
                                <img src="assets/img/icon/right-icon.svg" alt="">
                            </div>
                            <div class="features-caption">
                                <p> Giao Tiếp: Luyện tập tiếng Anh trong các tình huống thực tế.</p>
                            </div>
                        </div>
                    </div>
                    <div class="right-content1">
                        <!-- img -->
                        <div class="right-img">
                            <img src="assets/img/gallery/about.png" alt="">

                            <div class="video-icon" >
                                <a class="popup-video btn-icon" href="https://www.youtube.com/watch?v=SAg3mlKHuXU"><i class="fas fa-play"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- About Area End -->
            <!--? top subjects Area Start -->
            <div class="topic-area section-padding40">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-xl-7 col-lg-8">
                            <div class="section-tittle text-center mb-55">
                                <h2>Cảm nhận của học viên</h2>
                            </div>
                        </div>
                    </div>
                    <!-- Review area start -->

                    <!-- Lặp qua danh sách reviews -->
                    <c:if test="${not empty ratings}">
                        <ul>
                            <c:forEach var="rating" items="${ratings}">
                                <li>
                                    <strong>User ${rating.userId}</strong> - 
                                    <em>Posted on ${rating.createdAt}</em>
                                    <p>${rating.reviewText}</p>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>
                    <c:if test="${empty ratings}">
                        <p>Chưa có đánh giá nào.</p>
                    </c:if>


                    <!--? About Area-3 Start -->
                    <section class="about-area3 fix">
                        <div class="support-wrapper align-items-center">
                            <div class="right-content3">
                                <!-- img -->
                                <div class="right-img">
                                    <img src="assets/img/gallery/about3.png" alt="">
                                </div>
                            </div>
                            <div class="left-content3">
                                <!-- section tittle -->
                                <div class="section-tittle section-tittle2 mb-20">
                                    <div class="front-text">
                                        <h2 class="">Bạn nhận được gì khi tham gia khóa học của chúng tôi</h2>
                                    </div>
                                </div>
                                <div class="single-features">
                                    <div class="features-icon">
                                        <img src="assets/img/icon/right-icon.svg" alt="">
                                    </div>
                                    <div class="features-caption">
                                        <p>Các kỹ năng làm bài, giao tiếp hiệu quả với các phương pháp học đổi mới.</p>
                                    </div>
                                </div>
                                <div class="single-features">
                                    <div class="features-icon">
                                        <img src="assets/img/icon/right-icon.svg" alt="">
                                    </div>
                                    <div class="features-caption">
                                        <p>Tham gia cùng hàng triệu người trên thế giới để cùng nhau học tập.</p>
                                    </div>
                                </div>
                                <div class="single-features">
                                    <div class="features-icon">
                                        <img src="assets/img/icon/right-icon.svg" alt="">
                                    </div>
                                    <div class="features-caption">
                                        <p>Tiếng Anh sẽ không còn là trở ngại của bạn.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!-- About Area End -->
                    <!--? Team -->
                    <section class="team-area section-padding40 fix">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="col-xl-7 col-lg-8">
                                    <div class="section-tittle text-center mb-55">
                                        <h2>Giáo Viên</h2>
                                    </div>
                                </div>
                            </div>
                            <div class="team-active">
                                <div class="single-cat text-center">
                                    <div class="cat-icon">
                                        <img src="assets/img/gallery/team1.png" alt="">
                                    </div>
                                    <div class="cat-cap">
                                        <h5><a href="services.html">Mr. Urela</a></h5>
                                        <p>TOIEC 990/990, Speaking TOEIC 180, Writing 190.</p>
                                    </div>
                                </div>
                                <div class="single-cat text-center">
                                    <div class="cat-icon">
                                        <img src="assets/img/gallery/team2.png" alt="">
                                    </div>
                                    <div class="cat-cap">
                                        <h5><a href="services.html">Mr. Uttom</a></h5>
                                        <p>7.5 IELTS, 8.0 Writing; SW TOEIC 360/400.</p>
                                    </div>
                                </div>
                                <div class="single-cat text-center">
                                    <div class="cat-icon">
                                        <img src="assets/img/gallery/team3.png" alt="">
                                    </div>
                                    <div class="cat-cap">
                                        <h5><a href="services.html">Mr. Shakil</a></h5>
                                        <p>TOIEC 965/990, SW TOEIC 350/400.</p>
                                    </div>
                                </div>
                                <div class="single-cat text-center">
                                    <div class="cat-icon">
                                        <img src="assets/img/gallery/team4.png" alt="">
                                    </div>
                                    <div class="cat-cap">
                                        <h5><a href="services.html">Mr. Arafat</a></h5>
                                        <p>TOIEC 975/990, 7.5 IELTS, chứng chỉ TESOL.</p>
                                    </div>
                                </div>
                                <div class="single-cat text-center">
                                    <div class="cat-icon">
                                        <img src="assets/img/gallery/team3.png" alt="">
                                    </div>
                                    <div class="cat-cap">
                                        <h5><a href="services.html">Mr. saiful</a></h5>
                                        <p>2 lần 990/990, 8.0 IELTS.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!-- Services End -->
                    </main>
                    <footer>
                        <%-- Include Header --%>
                        <jsp:include page="footer.jsp" />
                    </footer> 
                    <!-- Scroll Up -->
                    <div id="back-top" >
                        <a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
                    </div>

                    <!-- JS here -->
                    <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
                    <!-- Jquery, Popper, Bootstrap -->
                    <script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
                    <script src="./assets/js/popper.min.js"></script>
                    <script src="./assets/js/bootstrap.min.js"></script>
                    <!-- Jquery Mobile Menu -->
                    <script src="./assets/js/jquery.slicknav.min.js"></script>

                    <!-- Jquery Slick , Owl-Carousel Plugins -->
                    <script src="./assets/js/owl.carousel.min.js"></script>
                    <script src="./assets/js/slick.min.js"></script>
                    <!-- One Page, Animated-HeadLin -->
                    <script src="./assets/js/wow.min.js"></script>
                    <script src="./assets/js/animated.headline.js"></script>
                    <script src="./assets/js/jquery.magnific-popup.js"></script>

                    <!-- Date Picker -->
                    <script src="./assets/js/gijgo.min.js"></script>
                    <!-- Nice-select, sticky -->
                    <script src="./assets/js/jquery.nice-select.min.js"></script>
                    <script src="./assets/js/jquery.sticky.js"></script>
                    <!-- Progress -->
                    <script src="./assets/js/jquery.barfiller.js"></script>

                    <!-- counter , waypoint,Hover Direction -->
                    <script src="./assets/js/jquery.counterup.min.js"></script>
                    <script src="./assets/js/waypoints.min.js"></script>
                    <script src="./assets/js/jquery.countdown.min.js"></script>
                    <script src="./assets/js/hover-direction-snake.min.js"></script>

                    <!-- contact js -->
                    <script src="./assets/js/contact.js"></script>
                    <script src="./assets/js/jquery.form.js"></script>
                    <script src="./assets/js/jquery.validate.min.js"></script>
                    <script src="./assets/js/mail-script.js"></script>
                    <script src="./assets/js/jquery.ajaxchimp.min.js"></script>

                    <!-- Jquery Plugins, main Jquery -->	
                    <script src="./assets/js/plugins.js"></script>
                    <script src="./assets/js/main.js"></script>

                    </body>
                    </html>