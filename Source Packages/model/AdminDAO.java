package model;

import entity.AdminAccount;
import entity.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO extends TKAdmin
{
	public AdminAccount login(String username, String password) {
        AdminAccount a = new AdminAccount();
        String sql = "Select * from admin_account where username = '" + username + "' and password = '" + password + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a.setId(rs.getInt("id"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setName(rs.getString("name"));
                a.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
	public void createCourse(Course course) {
        try {
            PreparedStatement statement = connection.prepareStatement(""
                    + "INSERT INTO courses (id, name, description) "
                    + "VALUES (?, ?, ?)");
            statement.setInt(1, course.getId());
            statement.setString(2, course.getName());
            statement.setString(3, course.getDescription());
            statement.executeUpdate();
        } catch (SQLException ex) {
        }
    }
}
