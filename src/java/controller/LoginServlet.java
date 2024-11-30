package controller;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet ( name = "LoginServlet" , urlPatterns = { "/LoginServlet" } )
public class LoginServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/khta";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "lovecats21.00";

    @Override
    protected void doPost ( HttpServletRequest request , HttpServletResponse response )
            throws ServletException , IOException {
        String email = request.getParameter ( "email" );
        String password = request.getParameter ( "password" );

        try {
            // Kết nối cơ sở dữ liệu
            Class.forName ( "com.mysql.cj.jdbc.Driver" );
            Connection connection = DriverManager.getConnection ( DB_URL , DB_USERNAME , DB_PASSWORD );

            // Kiểm tra thông tin đăng nhập
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement ( query );
            statement.setString ( 1 , email );
            statement.setString ( 2 , password );

            System.out.println ( "Executing query: " + statement.toString () );

            ResultSet resultSet = statement.executeQuery ();

            if ( resultSet.next () ) {
                // Tạo session cho người dùng
                HttpSession session = request.getSession ();
                session.setAttribute ( "user_name" , resultSet.getString ( "name" ) );
                session.setAttribute ( "email" , resultSet.getString ( "email" ) );
                int userId = resultSet.getInt ( "user_id" ); // Lấy user_id từ bảng 'users'
                String name = resultSet.getString ( "name" );
                String emailFromDb = resultSet.getString ( "email" );

                // Tạo đối tượng User
                User user = new User ( userId , name , emailFromDb , password );

                // Lưu thông tin người dùng vào session
                session.setAttribute ( "user" , user ); // Lưu toàn bộ đối tượng User
                session.setAttribute ( "userId" , userId ); // Lưu riêng userId nếu cần

                // Chuyển hướng đến trang chính
                request.getRequestDispatcher ( "home.jsp" ).forward ( request , response );

            } else {
                System.out.println ( "No matching user found for email: " + email + " and password: " + password );
                response.sendRedirect ( "login.jsp?error=1" );
            }

            resultSet.close ();
            statement.close ();
            connection.close ();
        } catch ( Exception e ) {
            e.printStackTrace ();
            response.sendRedirect ( "login.jsp?error=2" );
        }
    }

    @Override
    protected void doGet ( HttpServletRequest request , HttpServletResponse response )
            throws ServletException , IOException {
        response.sendRedirect ( "login.jsp" );
    }
}
