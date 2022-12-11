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
import page.BranchManagePanel;

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

    /* Drill down internal panels*/
    private BranchManagePanel branchManagePanel;

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

        /* Faculty Panel listener */
        facultyManagePanel.getAddFacultyBtn().addActionListener(this);
        facultyManagePanel.getDeleteFacultyBtn().addActionListener(this);
        facultyManagePanel.getFacultyTable().addMouseListener(new MouseHandler());
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
        ////////////////////////////////////////
        
        studentManagePanel.getAddStudentBtn().addActionListener(this);
        studentManagePanel.getDeleteStudentBtn().addActionListener(this);
        studentManagePanel.getStudentTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Drill down to -> switchToEachStudentPanel;
            }
        });
    }

    public void switchToSubjectManagePanel() {
        System.out.println("Subject page");
        subjectManagePanel = new SubjectManagePanel();
        swtichTo(subjectManagePanel);
        ////////////////////////////////////////
        
        subjectManagePanel.getAddSubjectBtn().addActionListener(this);
        subjectManagePanel.getDeleteSubjectBtn().addActionListener(this);
        subjectManagePanel.getSubjectTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Drill down to -> switchToEachSubjectPanel;
            }
        });
    }

    public void switchToBranchManagePanel(String facultyName) {
        System.out.println("Branch page");
        branchManagePanel = new BranchManagePanel(facultyName);
        swtichTo(branchManagePanel);
        ////////////////////////////////////////
        
        /* Branch Panel listener */
        branchManagePanel.getAddBranchBtn().addActionListener(this);
        branchManagePanel.getDeleteBranchBtn().addActionListener(this);
        branchManagePanel.getGoBackLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchToFacultyManagePanel();
            }
        });
    }

    private void swtichTo(JPanel panelToSwitch) {
        this.getContentPanel().removeAll();
        this.getContentPanel().add(panelToSwitch);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    /* Action methods */
    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource().equals(facultyManagePanel.getAddFacultyBtn())) {
            /* --------------------   Facult page   -------------------- */
            // Add a new faculty frame
            facultyManagePanel.createAddNewFacultyFrame();
            facultyManagePanel.configAddNewFacultyFrame();
           
        } else if (event.getSource().equals(facultyManagePanel.getDeleteFacultyBtn())) {
            // Delete a faculty
          
        }else if (branchManagePanel != null && event.getSource().equals(branchManagePanel.getAddBranchBtn())) {
            /* --------------------   Faculty -> Branch page   -------------------- */
            branchManagePanel.createAddNewBranchFrame();
            branchManagePanel.configAddNewBranchFrame();
          
        } else if (branchManagePanel != null && event.getSource().equals(branchManagePanel.getDeleteBranchBtn())) {
            // Delete a branch
            
        } else if (subjectManagePanel != null && event.getSource().equals(subjectManagePanel.getAddSubjectBtn())) {
             /* --------------------   Subject page   -------------------- */
            subjectManagePanel.createAddNewSubjectFrame();
            subjectManagePanel.configAddNewSubjectFrame();
           
        } else if (subjectManagePanel != null && event.getSource().equals(subjectManagePanel.getDeleteSubjectBtn())) {
            // Delete a subject
            
        } else if (studentManagePanel != null && event.getSource().equals(studentManagePanel.getAddStudentBtn())) {
             /* --------------------   Subject page   -------------------- */
            studentManagePanel.createAddNewSubjectFrame();
            studentManagePanel.configAddNewSubjectFrame();
           
        } else if (studentManagePanel != null && event.getSource().equals(studentManagePanel.getDeleteStudentBtn())) {
            // Delete a subject
            
        }
    }

    class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource().equals(facultyManagePanel.getFacultyTable())) {
                // Obtain row and column indexes the user clicked.
                int row = facultyManagePanel.getFacultyTable().rowAtPoint(e.getPoint());
                int col = facultyManagePanel.getFacultyTable().columnAtPoint(e.getPoint());

                if (col == 3) {
                    // Check if user clicks the cell that the JButton is located,
                    // then show the data of that row in JOptionPane.
                    
                    

//                            System.out.println("Clicked a button. [" + row + ", " + col + "]");
//                            String str = "isSelected: " + facultyManagePanel.getFacultyTable().getModel().getValueAt(row, 0) + "\n"
//                                    + "name: " + facultyManagePanel.getFacultyTable().getModel().getValueAt(row, 1) + "\n"
//                                    + "amount: " + facultyManagePanel.getFacultyTable().getModel().getValueAt(row, 2);
//                            JOptionPane.showMessageDialog(null, str);

                    
                    switchToBranchManagePanel((String)facultyManagePanel.getFacultyTable().getModel().getValueAt(row, 1));
//                    branchManagePanel.setNameFaculty();
                    System.out.println(branchManagePanel.getNameFaculty());
                    

                } else {
                    // When user ticks JCheckBox, print all row names that has
                    // JCheckBox ticked on console.
                    String toShow = "selected:";
                    for (int i = 0; i < facultyManagePanel.getFacultyTable().getRowCount(); i++) {
                        Boolean selected = (Boolean) facultyManagePanel.getFacultyTable().getModel().getValueAt(i, 0);
                        if (selected == null) {
                            selected = false;
                        }
                        String name = facultyManagePanel.getFacultyTable().getModel().getValueAt(i, 1).toString();
                        if (selected) {
                            toShow += " " + name;
                        }
                    }
                    System.out.println(toShow);
                }
            }
        }
    }
}
