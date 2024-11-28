package model;

import entity.AdminAccount;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                a.setPhone(rs.getString("phone"));
                a.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
	
}
