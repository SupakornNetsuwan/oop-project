package controllers;

import frame.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import page.*;
import model.*;

public class LoginController {

    private LoginPage loginPage; // login page
    private UserModel user;
    private MainFrame mainFrame;
    // SQL connection declaration goes here!
    private final Connection con = Connect.ConnectDB();
    private ResultSet result = null;
    private PreparedStatement statement = null;
    private String sql;

    public LoginPage getLoginPage() {
        return this.loginPage;
    }

    public JButton getLoginBtn() {
        return loginPage.getLoginBtn();
    }

    public LoginController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void openLogInPage() {
        mainFrame.getContentPane().removeAll(); //Clear Panel
        /* ------------------ Start Login Controller ------------------  */
        loginPage = new LoginPage(); //Create Login Page
        /* ------------------ Default frame config ------------------  */
        mainFrame.config(); //MainFrame Visible
        mainFrame.add(this.getLoginPage()); //MainFrame Add Login Page
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void closeLoginPage(MainFrame mainFrame) {
//        this.getLoginPage().setVisible(false); <- deprecated
        mainFrame.getContentPane().removeAll();
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public boolean loginCheck(String username, String password) {
        sql = "SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=?";

        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            result = statement.executeQuery();
            if (result != null && result.next()) {
                System.out.println("login successful");
                System.out.println("ID : " + result.getInt("ID"));
                System.out.println("USERNAME : " + result.getString("USERNAME"));
                System.out.println("Password : " + result.getString("Password"));
                System.out.println("LEVEL : " + result.getInt("LEVEL"));
                user = new UserModel(result.getInt("ID"), result.getString("USERNAME"), result.getString("Password"), result.getInt("LEVEL"));
                return true;
            } else {
                System.out.println("your username or password are wrong");
                
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void handleLoginReject() {
        JOptionPane.showMessageDialog(mainFrame,"Your username or password is incorrect.", "Error!", JOptionPane.ERROR_MESSAGE);
        clearLoginTextField();
        System.out.println("No permission");
    }
    
    public void clearLoginTextField(){
        loginPage.getUsernameField1().setText("");
        loginPage.getPaswordField1().setText("");
    }



}
