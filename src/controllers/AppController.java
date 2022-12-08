package controllers;

import components.*;
import java.awt.*;
import javax.swing.*;

public class AppController {

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
        this.switchToMainPanel();
    }

    public void switchToMainPanel() {
        homePanel = new HomePanel();
        this.getContentPanel().setLayout(new BorderLayout());
        this.getContentPanel().add(homePanel);
    }

    public void switchToFacultyManagePanel() {
        System.out.println("Faculty page");

        this.getContentPanel().removeAll();
        facultyManagePanel = new FacultyManagePanel();
        this.getContentPanel().setLayout(new BorderLayout());
        this.getContentPanel().add(facultyManagePanel);
    }

    public void switchToProfessorManagePanel() {

    }

    public void switchToStudentManagePanel() {

    }

    public void switchToSubjectManageBtn() {

    }

}
