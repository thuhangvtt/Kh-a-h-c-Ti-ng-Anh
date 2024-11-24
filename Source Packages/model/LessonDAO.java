package model;

import entity.Lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDAO {
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
    public String getEmbedLink(String videoLink) {
    if (videoLink.contains("watch?v=")) {
        return videoLink.replace("watch?v=", "embed/");
    } else if (videoLink.contains("/embed/")) {
        return videoLink; // Đã đúng định dạng, giữ nguyên
    } else if (videoLink.contains("youtu.be/")) {
        // Xử lý dạng rút gọn youtu.be/xyz
        return videoLink.replace("youtu.be/", "www.youtube.com/embed/");
    }
    return ""; // Trả về chuỗi rỗng nếu không hợp lệ
}
   
    public List<Lesson> getLessonsByCourseId(String courseId) {
        List<Lesson> lessons = new ArrayList<>();
       String query = """
                      select * from lessons
                      where course_id = ?""";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             preparedStatement.setString(1, courseId);
            ResultSet rs = preparedStatement.executeQuery();
          
            while (rs.next()) {
                lessons.add(new Lesson(
                    rs.getInt("id"),
                    rs.getInt("course_id"),
                    rs.getString("title"),
                    rs.getString("slug"),
                   getEmbedLink(rs.getString("video_link")),
                   new java.util.Date(rs.getTimestamp("created_at").getTime()),
                    rs.getBoolean("is_disabled")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lessons;
    }
    
    public static void main(String[] args) {
       LessonDAO dao = new LessonDAO();
        List<Lesson> listC = dao.getLessonsByCourseId("1");

        for (Lesson o : listC) {
            System.out.println(o);
        }
    }
}
