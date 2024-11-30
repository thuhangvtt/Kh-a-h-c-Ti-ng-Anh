<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

        <div class="header-area header-transparent">
            <div class="main-header ">
                <div class="header-bottom  header-sticky">
                    <div class="container-fluid">
                        <div class="row align-items-center">
                            <!-- Logo -->
                            <div class="col-xl-2 col-lg-2">
                                <div class="logo">
                                    <a href="home.jsp"><img src="assets/img/logo/logo1.jpg" alt=""></a>
                                </div>
                            </div>
                            <div class="col-xl-10 col-lg-10">
                                <div class="menu-wrapper d-flex align-items-center justify-content-end">
                                    <!-- Main-menu -->
                                    <div class="main-menu d-none d-lg-block">
                                        <nav>
                                            <ul id="navigation">                                                                                          
                                                <li class="active" ><a href="home.jsp">Trang chủ</a></li>
                                                <li><a href="#">Khóa học</a>
                                                    <ul class="submenu">
                                                        <li><a href="CourseServlet?categoryid=1">TOEIC</a></li>
                                                        <li><a href="CourseServlet?categoryid=2">IELTS</a></li>
                                                        <li><a href="CourseServlet?categoryid=3">Tiếng Anh Giao Tiếp</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="about.jsp">Về Chúng Tôi</a></li>
                                                <li><a href="blog.jsp">Blog</a>
                                                </li>
                                                <li><a href="contact.jsp">Liên Hệ</a></li>
                                                <!-- Button -->
                                                <li class="button-header margin-left "><a href="lesson.jsp" class="btn">Bắt đầu học</a></li>
                                                <li class="button-header"><a href="#" class="btn btn3">Tôi</a>
                                                    <ul class="submenu">
                                                        <li><a href="CourseServlet?categoryid=1">Khóa học của tôi</a></li>
                                                        <li><a href="logout.jsp">Đăng xuất</a></li>
                                                        
                                                    </ul>
                                                </li>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                            </div> 
                            <!-- Mobile Menu -->
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
