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
    private NavPanel navPanel; // Home page
    private MainPanel mainPanel;


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
        mainPanel = new MainPanel();
        navPanel = new NavPanel(); // Create a home page.
        
        loginPanel.setVisible(false); // Disabled login page
        mainFrame.add(navPanel);
        navPanel.getBlankPanel().setLayout(new BorderLayout());
        navPanel.getBlankPanel().add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loginPanel.getLoginBtn())) {
            changeToMainApp();
        }
    }
}
