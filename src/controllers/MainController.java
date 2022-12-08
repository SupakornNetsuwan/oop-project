package controllers;

import components.NavPanel;
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
    /* Pages & panels*/
    private NavPanel navPanel;
    private MainPanel mainPanel;

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
        mainPanel = new MainPanel();
        navPanel = new NavPanel(); // Create a home page.

        loginController.getLoginPage().setVisible(false); // Disabled login page
        mainFrame.add(navPanel);
        navPanel.getBlankPanel().setLayout(new BorderLayout());
        navPanel.getBlankPanel().add(mainPanel);

        /* Navbar init */
        navPanel.getMainPageBtn().addActionListener(this);
        navPanel.getStudentManageBtn().addActionListener(this);
        navPanel.getSubjectManageBtn().addActionListener(this);
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

        if (e.getSource().equals(navPanel.getMainPageBtn())) {
            System.out.println("Main page");
        } else if (e.getSource().equals(navPanel.getStudentManageBtn())) {
            System.out.println("Student page");
        } else if (e.getSource().equals(navPanel.getSubjectManageBtn())) {
            System.out.println("Subject page");
        }
    }

}
