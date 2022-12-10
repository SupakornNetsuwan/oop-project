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
import java.awt.event.*;
import javax.swing.*;

import model.FacultyModel;

public class AppController implements ActionListener {

    /* Pages & panels*/
    private MainLayout mainLayout;
    private MainFrame mainFrame;
    private FacultyModel facultyModel = new FacultyModel();

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
        mainFrame.revalidate();
        mainFrame.repaint();
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
        ////////////////////////////////////////
        Table facultyTable = facultyManagePanel.getTable();
        Object tableRows[][] = facultyModel.getRecordsForTableContent();
        //String tableHeader[] = {"การเลือก", "ชื่อคณะ", "จำนวนสาขา", "ดูข้อมูล"};

        for (int i = 0; i < tableRows.length; i++) {
            facultyTable.addRow(tableRows[i]);
        }

         /* Faculty Panel listener */
        facultyManagePanel.getAddFacultyBtn().addActionListener(this);
        facultyManagePanel.getDeleteFacultyBtn().addActionListener(this);

        facultyTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Obtain row and column indexes the user clicked.
                int row = facultyTable.rowAtPoint(e.getPoint());
                int col = facultyTable.columnAtPoint(e.getPoint());

                if (col == 3) {
                    // Check if user clicks the cell that the JButton is located,
                    // then show the data of that row in JOptionPane.
                    System.out.println("Clicked a button. [" + row + ", " + col + "]");
                    String str = "isSelected: " + facultyTable.getModel().getValueAt(row, 0) + "\n"
                            + "name: " + facultyTable.getModel().getValueAt(row, 1) + "\n"
                            + "amount: " + facultyTable.getModel().getValueAt(row, 2);
                    JOptionPane.showMessageDialog(null, str);
                } else {
                    // When user ticks JCheckBox, print all row names that has
                    // JCheckBox ticked on console.
                    String toShow = "selected:";
                    for (int i = 0; i < facultyTable.getRowCount(); i++) {
                        Boolean selected = (Boolean) facultyTable.getModel().getValueAt(i, 0);
                        if (selected == null) {
                            selected = false;
                        }
                        String name = facultyTable.getModel().getValueAt(i, 1).toString();
                        if (selected) {
                            toShow += " " + name;
                        }
                    }
                    System.out.println(toShow);
                }
            }
        });

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

    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(facultyManagePanel.getAddFacultyBtn())) {
            // Add a new faculty frame
            facultyManagePanel.createAddNewFacultyFrame();
            facultyManagePanel.configAddNewFacultyFrame();
        } else if (event.getSource().equals(facultyManagePanel.getDeleteFacultyBtn())) {
            // Delete a faculty
        }

    }
}
