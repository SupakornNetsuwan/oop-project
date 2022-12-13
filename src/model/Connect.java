
package model;

import java.sql.*;
import javax.swing.JOptionPane;
import controllers.*;

public class Connect {
    public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost/waido_db";
            Connection con=DriverManager.getConnection(url, "root", "");

            return con;
        } catch(SQLException e) {
            System.out.println("Connect Link Failed");
            JOptionPane.showMessageDialog(MainController.mainFrame, "You're not connect to database. Please open MySQL and Import waido_db.sql before using this application.", "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch(ClassNotFoundException ex){
            System.out.println("Please Install Driver");
        }
        return null;
    }
}