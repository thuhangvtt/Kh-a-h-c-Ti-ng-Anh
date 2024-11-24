package model;

import entity.Course_Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoryDAO {
    private static final String SELECT_ALL_CATEGORY = "SELECT * FROM categories";

    private final String jdbcURL = "jdbc:mysql://localhost:3306/hoconline";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "123456";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
        }
        return connection;}
    public List<Course_Category> getAllCategory() {
        List<Course_Category> courses = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                Course_Category course_category = new Course_Category(id, name, description);
                courses.add(course_category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
        List<Course_Category> listC = dao.getAllCategory();
        for(Course_Category x: listC){
            System.out.println(x);
        }
    }
}