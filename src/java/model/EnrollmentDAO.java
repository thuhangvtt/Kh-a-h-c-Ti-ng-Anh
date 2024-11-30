package model;

import entity.Enrollment;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnrollmentDAO {

    private static final Logger LOGGER = Logger.getLogger(EnrollmentDAO.class.getName());
    private final String jdbcURL = "jdbc:mysql://localhost:3306/khta";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "lovecats21.00";

    /**
     * Kết nối cơ sở dữ liệu.
     */
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Database connection error", e);
        }
        return connection;
    }

    /**
     * Lấy danh sách tất cả bản ghi đăng ký.
     */
    public List<Enrollment> getAllEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM enrollments";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Enrollment enrollment = mapResultSetToEnrollment(rs);
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error in getAllEnrollments", e);
        }
        return enrollments;
    }

    /**
     * Lấy danh sách các yêu cầu đăng ký chờ phê duyệt.
     */
    public List<Enrollment> getPendingEnrollments() {
    List<Enrollment> enrollments = new ArrayList<>();
    String sql = "SELECT * FROM enrollments WHERE status = 'pending'";
    try (Connection connection = getConnection();
         PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Enrollment enrollment = mapResultSetToEnrollment(rs);
            enrollments.add(enrollment);
        }
    } catch (SQLException e) {
        LOGGER.log(Level.SEVERE, "Error in getPendingEnrollments", e);
    }
    return enrollments;
}


    /**
     * Lấy thông tin đăng ký của một người dùng trong một khóa học.
     */
    public Enrollment getEnrollment(int userId, int courseId) {
        String sql = "SELECT * FROM enrollments WHERE user_id = ? AND course_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, courseId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEnrollment(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error in getEnrollment", e);
        }
        return null;
    }



    /**
     * Xóa bản ghi đăng ký theo user_id và course_id.
     */
    public void deleteEnrollment(int userId, int courseId) {
        String sql = "DELETE FROM enrollments WHERE user_id = ? AND course_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error in deleteEnrollment", e);
        }
    }

    /**
     * Cập nhật trạng thái của bản ghi đăng ký.
     */
    public boolean updateEnrollmentStatus(int userId, int courseId, String status) {
        String sql = "UPDATE enrollments SET status = ? WHERE user_id = ? AND course_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, userId);
            ps.setInt(3, courseId);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error in updateEnrollmentStatus", e);
            return false;
        }
    }

    /**
     * Kiểm tra quyền truy cập của người dùng vào khóa học.
     */
    public boolean isUserApprovedForCourse(int userId, int courseId) {
        String sql = "SELECT status FROM enrollments WHERE user_id = ? AND course_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, courseId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return "approved".equals(rs.getString("status"));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error in isUserApprovedForCourse", e);
        }
        return false;
    }

    /**
     * Kiểm tra xem người dùng có tồn tại không.
     */
    public boolean checkIfUserExists(int userId) {
        String sql = "SELECT COUNT(*) FROM users WHERE user_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error in checkIfUserExists", e);
        }
        return false;
    }

    /**
     * Kiểm tra xem khóa học có tồn tại không.
     */
    public boolean checkIfCourseExists(int courseId) {
        String sql = "SELECT COUNT(*) FROM courses WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, courseId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error in checkIfCourseExists", e);
        }
        return false;
    }

    /**
     * Chuyển ResultSet thành đối tượng Enrollment.
     */
    private Enrollment mapResultSetToEnrollment(ResultSet rs) throws SQLException {
        Enrollment enrollment = new Enrollment();
        enrollment.setUserId(rs.getInt("user_id"));
        enrollment.setCourseId(rs.getInt("course_id"));
        enrollment.setEnrolledAt(rs.getDate("enrolled_at"));
        enrollment.setStatus(rs.getString("status"));
        return enrollment;
    }
    public boolean insertEnrollmentWithPendingStatus(int userId, int courseId, java.sql.Date enrolledAt) {
    String sql = "INSERT INTO enrollments (user_id, course_id, enrolled_at, status) VALUES (?, ?, ?, 'pending')";
    try (Connection connection = getConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {
        
        ps.setInt(1, userId);
        ps.setInt(2, courseId);
        ps.setDate(3, enrolledAt);
        
        int rowsInserted = ps.executeUpdate();
        return rowsInserted > 0;  // Trả về true nếu thêm thành công
    } catch (SQLException e) {
        LOGGER.log(Level.SEVERE, "Error in insertEnrollmentWithPendingStatus", e);
        return false;  // Nếu có lỗi, trả về false
    }
}
    // Cập nhật trạng thái phê duyệt trong EnrollmentDAO
private void approveEnrollment(HttpServletRequest request, HttpServletResponse response) throws IOException {
    int userId = Integer.parseInt(request.getParameter("userId"));
    int courseId = Integer.parseInt(request.getParameter("courseId"));
    EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
    boolean isUpdated = enrollmentDAO.updateEnrollmentStatus(userId, courseId, "approved");
    if (isUpdated) {
        response.sendRedirect("AdminServlet?action=viewEnrollments&message=Phê duyệt thành công!");
    } else {
        response.sendRedirect("AdminServlet?action=viewEnrollments&errorMessage=Có lỗi xảy ra!");
    }
}
public String getEnrollmentStatus(int userId, int courseId) {
    String sql = "SELECT status FROM enrollments WHERE user_id = ? AND course_id = ?";
    try (Connection connection = getConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, userId);
        ps.setInt(2, courseId);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("status"); // Trả về trạng thái phê duyệt
            }
        }
    } catch (SQLException e) {
        LOGGER.log(Level.SEVERE, "Error in getEnrollmentStatus", e);
    }
    return null; // Nếu không tìm thấy
}
public boolean approveEnrollment(int userId, int courseId) {
    String sql = "UPDATE enrollments SET status = 'approved' WHERE user_id = ? AND course_id = ?";
    try (Connection connection = getConnection();
         PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, userId);
        ps.setInt(2, courseId);
        int rowsUpdated = ps.executeUpdate();
        return rowsUpdated > 0; // Thành công nếu có ít nhất 1 hàng được cập nhật
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public static void main(String[] args) {
        EnrollmentDAO e= new EnrollmentDAO();
        List<Enrollment> x= e.getPendingEnrollments();
        for(Enrollment a :x){
            System.out.println(a);
        }
        EnrollmentDAO dao = new EnrollmentDAO();
boolean result = dao.updateEnrollmentStatus(2, 4, "approved"); // Thay 1 và 101 bằng user_id và course_id thực tế.
System.out.println("Cập nhật trạng thái thành công: " + result);
        System.out.println(e.getEnrollmentStatus(2, 4));
    }
}
