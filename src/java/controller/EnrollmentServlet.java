package controller;

import entity.Course;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.EnrollmentDAO;
import model.CourseDAO;
import entity.Enrollment;
import entity.User;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EnrollmentServlet", urlPatterns = {"/EnrollmentServlet"})
public class EnrollmentServlet extends HttpServlet {

    private EnrollmentDAO enrollmentDAO;

    @Override
    public void init() throws ServletException {
        this.enrollmentDAO = new EnrollmentDAO();
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("user") == null) {
        System.out.println("User not logged in.");
        response.sendRedirect("login.jsp");
        return;
    }

    User user = (User) session.getAttribute("user");
    int userId = user.getId();
    String courseId = request.getParameter("courseId");

    // Kiểm tra giá trị courseId
    if (courseId == null || courseId.trim().isEmpty()) {
        System.out.println("Invalid course ID.");
        response.sendRedirect("enrollFail.jsp");
        return;
    }

    // Lấy thời gian hiện tại làm ngày đăng ký
    java.sql.Date enrolledAt = new java.sql.Date(System.currentTimeMillis());

    // Gọi DAO để thêm bản ghi
    EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
    boolean success = enrollmentDAO.insertEnrollmentWithPendingStatus(userId, Integer.parseInt(courseId), enrolledAt);

    if (success) {
            // Kiểm tra lại trạng thái của enrollment sau khi thêm
            Enrollment enrollment = enrollmentDAO.getEnrollment(userId, Integer.parseInt(courseId));
            String userEnrolledStatus = (enrollment != null) ? enrollment.getStatus() : "none";

            // Log giá trị của userEnrolledStatus
            System.out.println("User Enrolled Status: " + userEnrolledStatus); // Đây là câu lệnh log

            // Truyền giá trị vào request để hiển thị trong JSP
            request.setAttribute("userEnrolledStatus", userEnrolledStatus);

            response.sendRedirect("enrollSuccess.jsp");
        } else {
            response.sendRedirect("enrollFail.jsp");
        }
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Lấy userId và courseId từ request
    int userId = Integer.parseInt(request.getParameter("userId"));
    int courseId = Integer.parseInt(request.getParameter("courseId"));

    // Lấy thông tin enrollment dựa trên userId và courseId
    Enrollment enrollment = enrollmentDAO.getEnrollment(userId, courseId);

    // Nếu có thông tin enrollment, lấy trạng thái đăng ký
    if (enrollment != null) {
        request.setAttribute("userEnrolledStatus", enrollment.getStatus());
    } else {
        // Nếu không có enrollment, mặc định là "none"
        request.setAttribute("userEnrolledStatus", "none");
    }

    // Truyền dữ liệu vào request và chuyển tiếp đến detail.jsp
    RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
    dispatcher.forward(request, response);
}

}