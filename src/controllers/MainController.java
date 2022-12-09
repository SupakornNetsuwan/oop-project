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
        loginController = new LoginController();
        this.openLogInPage();
    }

    public void redirectToMainApp() {
        loginController.disablePage(mainFrame); // Disabled login page
        appController = new AppController(mainFrame);
        mainFrame.add(appController.getMainLayout()); // Enable Main Page
        
        appController.switchToMainPanel(); // First, Switch to home page;
        /* Navbar listener */
        appController.getNavPanel().getMainPageBtn().addActionListener(this);
        appController.getNavPanel().getStudentManageBtn().addActionListener(this);
        appController.getNavPanel().getSubjectManageBtn().addActionListener(this);
        appController.getNavPanel().getProfessorManageBtn().addActionListener(this);
        appController.getNavPanel().getFacultyManageBtn().addActionListener(this);
        appController.getNavPanel().getLogOutBtn().addActionListener(this);
    }
    
    public void openLogInPage(){
        mainFrame.getContentPane().removeAll(); //Clear Panel
        /* ------------------ Start Login Controller ------------------  */
        loginController.start(); //Create Login Page
        loginController.getLoginBtn().addActionListener(this); //Login Button Add ActionListener
        /* ------------------ Default frame config ------------------  */
        mainFrame.config(); //MainFrame Visible
        mainFrame.add(loginController.getLoginPage()); //MainFrame Add Login Page
        mainFrame.revalidate();
        mainFrame.repaint();
    } 

    @Override
    public void actionPerformed(ActionEvent e) {

        /* --------------------   Login page   -------------------- */
        if (e.getSource().equals(loginController.getLoginBtn())) {
            if (loginController.checkIsAuthen()) {
                /* User is authened */
                this.redirectToMainApp();
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
            int x = JOptionPane.showConfirmDialog(mainFrame, "Confirm Logout", "Make sure you want to Logout?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png")));
            if (x == 0){
                this.openLogInPage(); 
            }
                 
        }
        
    }

}
