
package model;

import java.sql.*;

public class Connect {
    public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://remotemysql.com/XqR8DNCjzT";
            Connection con=DriverManager.getConnection(url, "XqR8DNCjzT", "4e8h8G8TGy");
            return con;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
