package controllers;

import components.*;
import java.awt.*;
import javax.swing.*;

public class AppController {
    private String pageName = "Home";
    private boolean firstTimeAddHomePanel = true;
    private boolean firstTimeAddFacultyManagePanel = true;
    private boolean firstTimeAddStudentManagePanel = true;
    private boolean firstTimeAddProfessorManagePanel = true;

    /* Pages & panels*/
    private MainLayout mainLayout;

    /* Panels */
    private HomePanel homePanel;
    private FacultyManagePanel facultyManagePanel;

    /* Panels in content panel */
    public HomePanel getMainPanel() {
        return this.homePanel;
    }

    public JPanel getContentPanel() { // get main blank jpanel
        return mainLayout.getContentPanel();
    }

    public MainLayout getMainLayout() {
        return this.mainLayout;
    }

    public AppController() {
        /* ------------------ Nav Panel (It is primary page ------------------ */
        mainLayout = new MainLayout(); // Create a home page.
        this.getContentPanel().setLayout(new BorderLayout());
        this.switchToMainPanel();
    }

    public void switchToMainPanel() {
        homePanel = new HomePanel();
        this.disablePage();
        pageName = "Home";
        if(firstTimeAddHomePanel){
            this.getContentPanel().add(homePanel);
        }
        else{
            homePanel.setVisible(true);
        }
    }

    public void switchToFacultyManagePanel() {
        facultyManagePanel = new FacultyManagePanel();
        this.disablePage();
        pageName = "Faculty";
        if(firstTimeAddHomePanel){
            this.getContentPanel().add(facultyManagePanel);
        }
        else{
            facultyManagePanel.setVisible(true);
        }
//        this.getContentPanel().setLayout(new BorderLayout());
        
    }

    public void switchToProfessorManagePanel() {

    }

    public void switchToStudentManagePanel() {

    }
    
    public void switchToSubjectManagePanel() {

    }

    public void switchToSubjectManageBtn() {

    }
    public void disablePage(){
        switch(pageName){
            case "Home" -> {
                homePanel.setVisible(false);
            }
            case "Faculty" -> {
                facultyManagePanel.setVisible(false);
            }
            case "Student" -> {
                facultyManagePanel.setVisible(false);
            }
            case "Professor" -> {
                facultyManagePanel.setVisible(false);
            }
        }
    }

}
