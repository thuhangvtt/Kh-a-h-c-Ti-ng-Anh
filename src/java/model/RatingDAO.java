package model;

import entity.Rating;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RatingDAO {
    private Connection connection;

    // Constructor
    public RatingDAO(Connection connection) {
        this.connection = connection;
    }

    // Lấy danh sách đánh giá của khóa học theo courseId
    public List<Rating> getRatingsByCourse(int courseId) throws SQLException {
        List<Rating> ratings = new ArrayList<>();
        String sql = "SELECT * FROM Ratings WHERE course_id = ?";

        // In ra câu lệnh SQL để debug
        System.out.println("Executing SQL: " + sql);

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                // Kiểm tra xem có bất kỳ đánh giá nào không
                if (!rs.isBeforeFirst()) {
                    System.out.println("No ratings found for course_id " + courseId);
                }

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int userId = rs.getInt("user_id");
                    String reviewText = rs.getString("review_text");
                    String createdAt = rs.getString("created_at");

                    // In ra các giá trị lấy từ cơ sở dữ liệu để kiểm tra
                    System.out.println("Rating ID: " + id);
                    System.out.println("User ID: " + userId);
                    System.out.println("Course ID: " + courseId);
                    System.out.println("Review Text: " + reviewText);
                    System.out.println("Created At: " + createdAt);

                    // Thêm vào danh sách các đánh giá
                    ratings.add(new Rating(id, userId, courseId, reviewText, createdAt));
                }
            }
        }
        return ratings;
    }

    // Thêm mới một đánh giá
    public boolean addRating(Rating rating) throws SQLException {
        String sql = "INSERT INTO Ratings (user_id, course_id, review_text, created_at) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, rating.getUserId());
            stmt.setInt(2, rating.getCourseId());
            stmt.setString(3, rating.getReviewText());
            stmt.setString(4, rating.getCreatedAt());

            // Thực thi câu lệnh INSERT và kiểm tra số dòng bị ảnh hưởng
            int rowsAffected = stmt.executeUpdate();

            // In ra kết quả để kiểm tra
            if (rowsAffected > 0) {
                System.out.println("Rating added successfully.");
                return true;
            } else {
                System.out.println("Failed to add rating.");
                return false;
            }
        }
    }

    // Phương thức main để kiểm tra các phương thức DAO
    public static void main(String[] args) {
        // Kết nối đến cơ sở dữ liệu
        String url = "jdbc:mysql://localhost:3306/khta"; // URL cơ sở dữ liệu
        String username = "root"; // Tên người dùng
        String password = "lovecats21.00"; // Mật khẩu

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Khởi tạo RatingDAO với kết nối
            RatingDAO ratingDAO = new RatingDAO(connection);

            // Kiểm tra lấy danh sách đánh giá của khóa học có ID = 1
            System.out.println("Fetching ratings for course ID 1...");
            List<Rating> ratings = ratingDAO.getRatingsByCourse(1);

            // In ra kết quả đánh giá
            for (Rating rating : ratings) {
                System.out.println("Rating ID: " + rating.getId());
                System.out.println("User ID: " + rating.getUserId());
                System.out.println("Course ID: " + rating.getCourseId());
                System.out.println("Review: " + rating.getReviewText());
                System.out.println("Created At: " + rating.getCreatedAt());
                System.out.println("------");
            }

            // Thêm một đánh giá mới
            System.out.println("Adding a new rating...");
            Rating newRating = new Rating(0, 1, 1, "Excellent course!", "2024-11-30 10:00:00");
            boolean isAdded = ratingDAO.addRating(newRating);
            if (isAdded) {
                System.out.println("New rating added successfully.");
            } else {
                System.out.println("Failed to add new rating.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
