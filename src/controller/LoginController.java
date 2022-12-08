package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author windows
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import page.*;
import frame.*;


public class LoginController implements ActionListener{
    private MainFrame mainframe;
    private LoginPanel login;
    private Test test;
    public LoginController(){
        mainframe = new MainFrame();
        login = new LoginPanel();
        
        login.getLoginBtn().addActionListener(this);
        mainframe.setLayout(new BorderLayout());
        mainframe.add(login);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setVisible(true);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(login.getLoginBtn())){
            test = new Test();
            login.setVisible(false);
            mainframe.add(test);
        }
    }
    public static void main(String[] args){
        new LoginController();
    }
}
