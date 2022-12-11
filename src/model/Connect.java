
package model;

import java.sql.*;

public class Connect {
    public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost/waido_db";
            Connection con=DriverManager.getConnection(url, "root", "");

            return con;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}