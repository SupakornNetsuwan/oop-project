package controllers;

/* pages for MDI */
import page.SubjectManagePanel;
import page.HomePanel;
import page.ProfessorManagePanel;
import page.StudentManagePanel;
import page.FacultyManagePanel;

import layout.MainLayout;
import components.*;
import frame.MainFrame;
import javax.swing.*;

public class AppController {

    /* Pages & panels*/
    private MainLayout mainLayout;
    private MainFrame mainFrame;

    public MainLayout getMainLayout() {
        return this.mainLayout;
    }

    public ContentPanel getContentPanel() {
        return mainLayout.getContentPanel();
    }

    public NavPanel getNavPanel() {
        return mainLayout.getNavPanel();
    }

    /* Panels ------------------------------------------------------------------*/
    private HomePanel homePanel;
    private FacultyManagePanel facultyManagePanel;
    private SubjectManagePanel subjectManagePanel;
    private StudentManagePanel studentManagePanel;
    private ProfessorManagePanel professorManagePanel;

    /* Panels getter in content panel */
    public HomePanel getHomePanel() {
        return this.homePanel;
    }

    public FacultyManagePanel getFacultyManagePanel() {
        return this.facultyManagePanel;
    }

    public SubjectManagePanel getSubjectManagePanel() {
        return subjectManagePanel;
    }

    public StudentManagePanel getStudentManagePanel() {
        return studentManagePanel;
    }

    public ProfessorManagePanel getProfessorManagePanel() {
        return professorManagePanel;
    }

    /* -------------------------------------------------------------------------*/
    public AppController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void openMainApp() {
        mainFrame.getContentPane().removeAll(); //Clear Panel
        /* ------------------ Start Login Controller ------------------  */
        this.mainLayout = new MainLayout();
        /* ------------------ Default frame config ------------------  */
        mainFrame.config(); //MainFrame Visible
        mainFrame.add(this.getMainLayout()); // Mainframe add mainApp page
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void closeMainApp() {
        mainFrame.getContentPane().removeAll(); //Clear Panel
    }

    public void switchToMainPanel() {
        System.out.println("Main page");
        homePanel = new HomePanel();
        swtichTo(homePanel);
    }

    public void switchToFacultyManagePanel() {
        System.out.println("Faculty page");
        facultyManagePanel = new FacultyManagePanel();
        swtichTo(facultyManagePanel);
    }

    public void switchToProfessorManagePanel() {
        System.out.println("Professor page");
        professorManagePanel = new ProfessorManagePanel();
        swtichTo(professorManagePanel);
    }

    public void switchToStudentManagePanel() {
        System.out.println("Student page");
        studentManagePanel = new StudentManagePanel();
        swtichTo(studentManagePanel);
    }

    public void switchToSubjectManagePanel() {
        System.out.println("Subject page");
        subjectManagePanel = new SubjectManagePanel();
        swtichTo(subjectManagePanel);
    }

    private void swtichTo(JPanel panelToSwitch) {
        this.getContentPanel().removeAll();
        this.getContentPanel().add(panelToSwitch);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
