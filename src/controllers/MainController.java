package controllers;

import components.MainLayout;
import java.awt.event.*;
import java.awt.*;

import page.*;
import components.*;
import frame.*;

public class MainController implements ActionListener {

    /* Controllers */
    private LoginController loginController;
    private AppController appController;
    /* Primary frame */
    private MainFrame mainFrame;

    public MainController() {
        mainFrame = new MainFrame();
        loginController = new LoginController();

        /* ------------------ Login controller ------------------  */
        loginController.start();
        loginController.getLoginBtn().addActionListener(this);
        /* ------------------ Default frame config ------------------  */
        mainFrame.config();
        mainFrame.add(loginController.getLoginPage());
    }

    public void redirectToMainApp() {
        loginController.disablePage(); // Disabled login page
        appController = new AppController();
        mainFrame.add(appController.getMainLayout()); // Enable Main Page
        /* Navbar init */
        appController.getMainLayout().getMainPageBtn().addActionListener(this);
        appController.getMainLayout().getStudentManageBtn().addActionListener(this);
        appController.getMainLayout().getSubjectManageBtn().addActionListener(this);
        appController.getMainLayout().getProfessorManageBtn().addActionListener(this);
        appController.getMainLayout().getFacultyManageBtn().addActionListener(this);
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
        if (e.getSource().equals(appController.getMainLayout().getMainPageBtn())) {
            System.out.println("Main page");
        } else if (e.getSource().equals(appController.getMainLayout().getStudentManageBtn())) {
            System.out.println("Student page");
        } else if (e.getSource().equals(appController.getMainLayout().getSubjectManageBtn())) {
            System.out.println("Subject page");
        } else if (e.getSource().equals(appController.getMainLayout().getFacultyManageBtn())) {

            appController.switchToFacultyManagePanel();
        } else if (e.getSource().equals(appController.getMainLayout().getProfessorManageBtn())) {
            System.out.println("Professor page");
        }
    }

}
