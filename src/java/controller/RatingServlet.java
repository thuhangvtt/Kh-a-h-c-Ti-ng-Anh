package controller;

import model.RatingDAO;
import entity.Rating;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RatingServlet extends HttpServlet {

    // Phương thức xử lý GET request: Hiển thị đánh giá
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/khta?serverTimezone=UTC", "root", "lovecats21.00")) {
            // Lấy courseId từ request (có thể lấy từ tham số URL hoặc form gửi lên)
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            
            // Khởi tạo RatingDAO và lấy danh sách đánh giá theo khóa học
            RatingDAO ratingDAO = new RatingDAO(connection);
            List<Rating> ratings = ratingDAO.getRatingsByCourse(courseId); // Sử dụng khóa học ID từ request

            // Đưa danh sách đánh giá vào request
            request.setAttribute("ratings", ratings);

            // Chuyển tiếp đến trang home.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }

    // Phương thức xử lý POST request: Nhận đánh giá mới từ người dùng và lưu vào cơ sở dữ liệu
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reviewText = request.getParameter("reviewText");
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        int userId = Integer.parseInt(request.getParameter("userId")); // Lấy ID người dùng từ session hoặc form

        Rating newRating = new Rating(0, userId, courseId, reviewText, new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/khta?serverTimezone=UTC", "root", "lovecats21.00")) {
            RatingDAO ratingDAO = new RatingDAO(connection);
            boolean isAdded = ratingDAO.addRating(newRating);
            if (isAdded) {
                // Redirect hoặc chuyển tiếp về trang danh sách đánh giá
                response.sendRedirect("ratings?courseId=" + courseId); // Trả về danh sách đánh giá của khóa học đã chọn
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add rating");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }

    @Override
    public String getServletInfo() {
        return "Handles the display and submission of course ratings.";
    }
}
