package controllers;

import frame.MainFrame;
import javax.swing.*;
import java.awt.*;

import page.*;

public class LoginController {

    private LoginPage loginPage; // login page
    // SQL connection declaration goes here!

    public LoginPage getLoginPage() {
        return this.loginPage;
    }

    public JButton getLoginBtn() {
        return loginPage.getLoginBtn();
    }

    public boolean checkIsAuthen() {
        return true;
        //or
        //return false
    }

    public void disablePage(MainFrame mainFrame) {
//        this.getLoginPage().setVisible(false);
        mainFrame.getContentPane().removeAll();
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
