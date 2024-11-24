package model;
import entity.Enrollment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {
    private Connection connection;

    public EnrollmentDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean enrollUser(int userId, int courseId) {
        String query = "INSERT INTO enrollments (user_id, course_id, enrolled_at) VALUES (?, ?, GETDATE())";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, courseId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    // Lấy danh sách tất cả đăng ký
    public List<Enrollment> getAllEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM Enrollments";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Enrollment enrollment = new Enrollment();
                enrollment.setUserId(rs.getInt("user_id"));
                enrollment.setCourseId(rs.getInt("course_id"));
                enrollment.setEnrolledAt(rs.getDate("enrolled_at"));
                enrollments.add(enrollment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }

    // Xóa thông tin đăng ký
    public boolean deleteEnrollment(int userId, int courseId) {
        String sql = "DELETE FROM Enrollments WHERE user_id = ? AND course_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, courseId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
