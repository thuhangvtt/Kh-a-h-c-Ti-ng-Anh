package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TKAdmin {
    public Connection connection;
    public TKAdmin()
    {
        try {
            String username = "admin24";
            String password = "123456";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=hoconline";//url mysql
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TKAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
