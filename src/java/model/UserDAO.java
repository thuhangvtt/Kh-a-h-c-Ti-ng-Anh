package model;

import entity.User;
import java.sql.*;

public class UserDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/khta"; // Cập nhật URL database
    private final String jdbcUsername = "root"; // Cập nhật username database
    private final String jdbcPassword = "lovecats21.00"; // Cập nhật mật khẩu database

    private static final String INSERT_USER = "INSERT INTO users (name, email, password) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?;";

    // Lấy kết nối tới database
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver MySQL
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Thêm một người dùng mới vào database
     *
     * @param user Đối tượng User chứa thông tin cần thêm
     */
    public void insertUser(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lỗi để servlet xử lý
        }
    }

    /**
     * Kiểm tra xem email đã tồn tại trong database hay chưa
     *
     * @param email Email cần kiểm tra
     * @return true nếu email tồn tại, false nếu không
     */
    public boolean isEmailRegistered(String email) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                return rs.next(); // Nếu có kết quả, email đã tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Lấy thông tin người dùng dựa trên email
     *
     * @param email Email của người dùng
     * @return Đối tượng User nếu tìm thấy, null nếu không
     */
    public User getUserByEmail(String email) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    // Lấy user_id cùng các thông tin khác
                    int userId = rs.getInt("user_id"); // Lấy user_id từ kết quả truy vấn
                    String name = rs.getString("name");
                    String emailFromDb = rs.getString("email");
                    String passwordFromDb = rs.getString("password");

                    // Tạo đối tượng User và trả về
                    user = new User(userId, name, emailFromDb, passwordFromDb);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Kiểm tra kết nối cơ sở dữ liệu đơn giản
    public void testQuery() {
        String sql = "SELECT 1";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                System.out.println("Truy vấn thành công: " + resultSet.getInt(1));
            }
        } catch (SQLException e) {
            System.err.println("Truy vấn thất bại: " + e.getMessage());
        }
    }

    // Phương thức main chỉ để test kết nối
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Kiểm tra kết nối
        System.out.println("Kiểm tra kết nối...");
        userDAO.testQuery();

        // Thêm một người dùng mới
        System.out.println("Thêm người dùng mới...");
        User user = new User(0, "phuong", "p@gmail.com", "123456"); // userId = 0 vì nó tự tăng
        try {
            userDAO.insertUser(user);
            System.out.println("Người dùng được thêm thành công!");
        } catch (SQLException e) {
            System.err.println("Thêm người dùng thất bại: " + e.getMessage());
        }

        // Kiểm tra email đã đăng ký chưa
        System.out.println("Kiểm tra email đã đăng ký...");
        boolean exists = userDAO.isEmailRegistered("johndoe@example.com");
        System.out.println("Email đã tồn tại: " + exists);
    }
}
