package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.Document;

public class CourseDAO {
    private Connection conn;
    private DocumentDAO documentDAO;
    
    public CourseDAO(Connection conn) {
        this.conn = conn;
        this.documentDAO = new DocumentDAO(conn);
    }
    
    public void createCourse(Course course) throws SQLException {
        String sql = "INSERT INTO courses (name, description) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getDescription());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                course.setId(rs.getInt(1));
            }
        }
    }
    
    public List<Course> getAllCourses() throws SQLException {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setDescription(rs.getString("description"));
                course.setDocuments(documentDAO.getDocumentsByCourse(course.getId()));
                courses.add(course);
            }
        }
        return courses;
    }
}
