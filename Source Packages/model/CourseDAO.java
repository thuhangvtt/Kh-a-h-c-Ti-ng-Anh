package model;

import entity.Course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CourseDAO {
    private static final String SELECT_ALL_COURSES = "SELECT * FROM courses";


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
    public List<Course> getAllCourses(String categoryid) {
        List<Course> courses = new ArrayList<>();
       String query = """
                      select * from courses
                      where category_id = ?""";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setString(1, categoryid);
            ResultSet rs = preparedStatement.executeQuery();
          
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
               
                Course course = new Course(id, name, description);
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }
    
    public static void main(String[] args) {
       CourseDAO dao = new CourseDAO();
        List<Course> listC = dao.getAllCourses("2");

        for (Course o : listC) {
            System.out.println(o);
        }
    }
}