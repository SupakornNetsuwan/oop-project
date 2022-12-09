package controllers;

import java.awt.event.*;
import javax.swing.*;
import frame.MainFrame;

public class MainController implements ActionListener {

    /* Controllers */
    private LoginController loginController;
    private AppController appController;
    /* Primary frame */
    private MainFrame mainFrame;

    public MainController() {
        mainFrame = new MainFrame();
        mainFrame.config(); //MainFrame Visible
        loginControllerInit(); // start with login page
    }

    private void loginControllerInit() {
        loginController = new LoginController(mainFrame); // 1. - create controller
        loginController.openLogInPage(); // 2. - call open page method
        /* Login page listener */
        loginController.getLoginBtn().addActionListener(this); //Login Button Add ActionListener
    }

    private void mainAppControllerInit() {
        appController = new AppController(mainFrame); // 1. - create controller
        appController.openMainApp(); // 2. - call open page method
        appController.switchToMainPanel(); // 3. - Switch to first page
        /* Navbar listener */
        appController.getNavPanel().getMainPageBtn().addActionListener(this);
        appController.getNavPanel().getStudentManageBtn().addActionListener(this);
        appController.getNavPanel().getSubjectManageBtn().addActionListener(this);
        appController.getNavPanel().getProfessorManageBtn().addActionListener(this);
        appController.getNavPanel().getFacultyManageBtn().addActionListener(this);
        appController.getNavPanel().getLogOutBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /* --------------------   Login page   -------------------- */
        if (e.getSource().equals(loginController.getLoginBtn())) {
            if (loginController.checkIsAuthen()) {
                /* User is authened */
                this.mainAppControllerInit();
            } else {
                loginController.handleLoginReject();
            }
        }

        /* -------------------- Sidebar (Navbar) -------------------- */
        if (e.getSource().equals(appController.getNavPanel().getMainPageBtn())) {

            appController.switchToMainPanel();
        } else if (e.getSource().equals(appController.getNavPanel().getStudentManageBtn())) {

            appController.switchToStudentManagePanel();
        } else if (e.getSource().equals(appController.getNavPanel().getSubjectManageBtn())) {

            appController.switchToSubjectManagePanel();
        } else if (e.getSource().equals(appController.getNavPanel().getFacultyManageBtn())) {

            appController.switchToFacultyManagePanel();
        } else if (e.getSource().equals(appController.getNavPanel().getProfessorManageBtn())) {

            appController.switchToProfessorManagePanel();
        } else if (e.getSource().equals(appController.getNavPanel().getLogOutBtn())) {
            System.out.println("Login Page");
            int x = JOptionPane.showConfirmDialog(mainFrame, "Confirm Logout", "Make sure you want to Logout?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/icons/logout2.png")));
            if (x == 0) {
                this.loginControllerInit();
            }

        }

    }

}
