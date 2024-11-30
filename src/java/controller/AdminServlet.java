package controller;

import entity.Enrollment;
import jakarta.servlet.RequestDispatcher;
import model.EnrollmentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {
    private final EnrollmentDAO enrollmentDAO = new EnrollmentDAO();


    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");

    try {
        if ("approve".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            int courseId = Integer.parseInt(request.getParameter("courseId"));

            boolean success = enrollmentDAO.updateEnrollmentStatus(userId, courseId, "approved");
            if (success) {
                request.setAttribute("message", "Đã phê duyệt thành công!");
            } else {
                request.setAttribute("error", "Không thể phê duyệt đơn đăng ký.");
            }
            
        } else if ("reject".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            int courseId = Integer.parseInt(request.getParameter("courseId"));

            boolean success = enrollmentDAO.updateEnrollmentStatus(userId, courseId, "rejected");
            if (success) {
                request.setAttribute("message", "Đã từ chối đơn đăng ký.");
            } else {
                request.setAttribute("error", "Không thể từ chối đơn đăng ký.");
            }
        }

        // Lấy danh sách đăng ký sau khi cập nhật
        List<Enrollment> enrollments = enrollmentDAO.getPendingEnrollments();
        request.setAttribute("enrollments", enrollments);

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-enrollments.jsp");
        dispatcher.forward(request, response);
    } catch (Exception e) {
        e.printStackTrace();
        request.setAttribute("error", "Đã xảy ra lỗi khi xử lý hành động.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-enrollments.jsp");
        dispatcher.forward(request, response);
    }
}
private void approveEnrollment(HttpServletRequest request, HttpServletResponse response) throws IOException {
    int userId = Integer.parseInt(request.getParameter("userId"));
    int courseId = Integer.parseInt(request.getParameter("courseId"));
    
    boolean isUpdated = enrollmentDAO.updateEnrollmentStatus(userId, courseId, "approved");
    if (isUpdated) {
        response.sendRedirect("AdminServlet?action=viewEnrollments&message=Phê duyệt thành công!");
    } else {
        response.sendRedirect("AdminServlet?action=viewEnrollments&errorMessage=Có lỗi xảy ra!");
    }
}
}


    