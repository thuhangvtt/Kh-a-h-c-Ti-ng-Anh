package model;

import entity.AdminAccount;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/khta";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "lovecats21.00";

    // Kết nối cơ sở dữ liệu
    private Connection getConnection () {
        Connection connection = null;
        try {
            Class.forName ( "com.mysql.cj.jdbc.Driver" );
            connection = DriverManager.getConnection ( jdbcURL , jdbcUsername , jdbcPassword );
        } catch ( ClassNotFoundException | SQLException e ) {
            e.printStackTrace ();
        }
        return connection;
    }

    // Phương thức đăng nhập
    public AdminAccount login ( String email , String password ) {
        AdminAccount admin = null;
        String sql = "SELECT * FROM admin_account WHERE email = ? AND password = ?";

        try ( Connection connection = getConnection ();  PreparedStatement preparedStatement = connection.prepareStatement ( sql ) ) {

            preparedStatement.setString ( 1 , email );
            preparedStatement.setString ( 2 , password );

            ResultSet rs = preparedStatement.executeQuery ();
            if ( rs.next () ) {
                admin = new AdminAccount ();
                admin.setId ( rs.getInt ( "user_id" ) );
                admin.setUsername ( rs.getString ( "username" ) );
                admin.setName ( rs.getString ( "name" ) );
                admin.setEmail ( rs.getString ( "email" ) );
                admin.setPassword ( rs.getString ( "password" ) );
            }
        } catch ( SQLException e ) {
            e.printStackTrace ();
        }
        return admin;
    }

    // Lấy tất cả tài khoản admin
    public List<AdminAccount> getAllAdminAccounts () {
        List<AdminAccount> adminList = new ArrayList<> ();
        String sql = "SELECT * FROM admin_account";

        try ( Connection connection = getConnection ();  PreparedStatement preparedStatement = connection.prepareStatement ( sql ) ) {

            ResultSet rs = preparedStatement.executeQuery ();
            while ( rs.next () ) {
                AdminAccount admin = new AdminAccount ();
                admin.setId ( rs.getInt ( "user_id" ) );
                admin.setUsername ( rs.getString ( "username" ) );
                admin.setName ( rs.getString ( "name" ) );
                admin.setEmail ( rs.getString ( "email" ) );
                admin.setPassword ( rs.getString ( "password" ) );

                adminList.add ( admin );
            }
        } catch ( SQLException e ) {
            e.printStackTrace ();
        }
        return adminList;
    }

    // Thêm tài khoản admin mới
    public boolean addAdmin ( AdminAccount admin ) {
        String sql = "INSERT INTO admin_account (username, name, email, password) VALUES (?, ?, ?, ?)";
        try ( Connection connection = getConnection ();  PreparedStatement preparedStatement = connection.prepareStatement ( sql ) ) {

            preparedStatement.setString ( 1 , admin.getUsername () );
            preparedStatement.setString ( 2 , admin.getName () );
            preparedStatement.setString ( 3 , admin.getEmail () );
            preparedStatement.setString ( 4 , admin.getPassword () );

            int rowsInserted = preparedStatement.executeUpdate ();
            return rowsInserted > 0;
        } catch ( SQLException e ) {
            e.printStackTrace ();
        }
        return false;
    }

    // Cập nhật thông tin admin
    public boolean updateAdmin ( AdminAccount admin ) {
        String sql = "UPDATE admin_account SET username = ?, name = ?, email = ?, password = ? WHERE id = ?";
        try ( Connection connection = getConnection ();  PreparedStatement preparedStatement = connection.prepareStatement ( sql ) ) {

            preparedStatement.setString ( 1 , admin.getUsername () );
            preparedStatement.setString ( 2 , admin.getName () );
            preparedStatement.setString ( 3 , admin.getEmail () );
            preparedStatement.setString ( 4 , admin.getPassword () );
            preparedStatement.setInt ( 5 , admin.getId () );

            int rowsUpdated = preparedStatement.executeUpdate ();
            return rowsUpdated > 0;
        } catch ( SQLException e ) {
            e.printStackTrace ();
        }
        return false;
    }

    // Xóa tài khoản admin
    public boolean deleteAdmin ( int id ) {
        String sql = "DELETE FROM admin_account WHERE id = ?";
        try ( Connection connection = getConnection ();  PreparedStatement preparedStatement = connection.prepareStatement ( sql ) ) {

            preparedStatement.setInt ( 1 , id );
            int rowsDeleted = preparedStatement.executeUpdate ();
            return rowsDeleted > 0;
        } catch ( SQLException e ) {
            e.printStackTrace ();
        }
        return false;
    }

    // Phương thức kiểm tra
    public static void main ( String[] args ) {
        AdminDAO adminDAO = new AdminDAO ();

        // Thử đăng nhập
        AdminAccount admin = adminDAO.login ( "hangv2k@gmail.com" , "12345" );
        if ( admin != null ) {
            System.out.println ( "Login successful: " + admin.getName () );
        } else {
            System.out.println ( "Login failed." );
        }

        // Lấy danh sách admin
        List<AdminAccount> adminList = adminDAO.getAllAdminAccounts ();
        for ( AdminAccount a : adminList ) {
            System.out.println ( a );
        }
    }

}
