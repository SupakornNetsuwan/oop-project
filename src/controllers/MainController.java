package controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import page.*;
import components.*;
import frame.*;

public class MainController implements ActionListener {

    private MainFrame mainFrame;
    private LoginPanel loginPanel; // login page
    private HomePanel homePanel; // Home page
    private Sidebar sidebar;


    public MainController() {
        mainFrame = new MainFrame();
        loginPanel = new LoginPanel();
        /* start application function*/
        init();
    }

    public void init() {
        // start application, start with login!
        mainFrame.config();
        mainFrame.add(loginPanel);
        loginPanel.getLoginBtn().addActionListener(this);

    }

    public void changeToMainApp() {
        sidebar = new Sidebar();
        homePanel = new HomePanel(); // Create a home page.
        loginPanel.setVisible(false); // Disabled login page
        mainFrame.add(homePanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginPanel.getLoginBtn())) {
            changeToMainApp();
        }
    }
}
