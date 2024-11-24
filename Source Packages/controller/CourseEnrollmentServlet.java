package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import model.UserDAO;
import model.EnrollmentDAO;
import entity.User;

@WebServlet("/enroll-course")
public class Course extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    private EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ session
        HttpSession session = request.getSession();
        User loggedUser = (User) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            response.sendRedirect("login.jsp"); // Chuyển hướng đến đăng nhập nếu chưa đăng nhập
            return;
        }

        int userId = loggedUser.getUserId();
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        boolean isUserUpdated = userDAO.updateUser(userId, name, phone);

        if (isUserUpdated) {
            // Ghi dữ liệu vào bảng enrollments
            boolean isEnrolled = enrollmentDAO.enrollUser(userId, courseId);

            if (isEnrolled) {
                request.setAttribute("message", "Đăng ký khóa học thành công!");
            } else {
                request.setAttribute("message", "Đăng ký khóa học thất bại. Bạn có thể đã đăng ký khóa học này trước đó.");
            }
        } else {
            request.setAttribute("message", "Không thể cập nhật thông tin người dùng.");
        }
}
