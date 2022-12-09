package controllers;

import frame.MainFrame;
import javax.swing.*;
import java.awt.*;

import page.*;

public class LoginController {

    private LoginPage loginPage; // login page
    private MainFrame mainFrame;
    // SQL connection declaration goes here!

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
        this.start(); //Create Login Page
        /* ------------------ Default frame config ------------------  */
        mainFrame.config(); //MainFrame Visible
        mainFrame.add(this.getLoginPage()); //MainFrame Add Login Page
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void closeLoginPage(MainFrame mainFrame) {
//        this.getLoginPage().setVisible(false); <- deprecated
        mainFrame.getContentPane().removeAll();
    }

    public boolean checkIsAuthen() {
        return true;
        //or
        //return false
    }

    public void handleLoginReject() {
        System.out.println("No permission");
    }

    public void start() {
        /* start application function*/
        loginPage = new LoginPage();
        // SQL instance goes here!
    }

}
