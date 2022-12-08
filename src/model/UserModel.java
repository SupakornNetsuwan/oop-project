package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserModel {

    private User user;
    private final Connection con = Connect.ConnectDB();
    private ResultSet rs = null;
    private PreparedStatement pst = null ;
    private String sql;

    public UserModel() {
        user = new User(0, "", "", 0);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void loginCheck(String username, String password) {
        sql = "SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                System.out.println("login successful");
            }
            else {
                System.out.println("your username or password are wrong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
}
