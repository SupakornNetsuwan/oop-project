package controllers;

/* pages for MDI */
import page.SubjectManagePanel;
import page.HomePanel;
import page.ProfessorManagePanel;
import page.StudentManagePanel;
import page.EachStudentManagePanel;
import page.FacultyManagePanel;
import page.EachProfessorManagePanel;
import page.ErrorPanel;

import layout.MainLayout;
import components.*;
import frame.MainFrame;
import java.awt.event.*;
import javax.swing.*;

import model.FacultyModel;
import page.BranchManagePanel;
import page.BranchStudentManagePanel;
import page.EachSubjectManagePanel;

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
    private EachStudentManagePanel eachStudentManagePanel;
    private ErrorPanel errorPanel;

    /* Drill down internal panels*/
    private BranchManagePanel branchManagePanel;
    private BranchStudentManagePanel branchStudentManagePanel;
    private EachSubjectManagePanel eachSubjectManagePanel;

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

    public EachStudentManagePanel getEachStudentManagePanel() {
        return eachStudentManagePanel;
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
        switchTo(homePanel);
    }

    public void switchToFacultyManagePanel() {
        System.out.println("Faculty page");
        facultyManagePanel = new FacultyManagePanel();
        switchTo(facultyManagePanel);
        facultyManagePanel.initTable();
        ////////////////////////////////////////

        /* Faculty Panel listener */
        facultyManagePanel.getAddFacultyBtn().addActionListener(this);
        facultyManagePanel.getDeleteFacultyBtn().addActionListener(this);
        facultyManagePanel.getFacultyTable().addMouseListener(new MouseHandler());
    }

    public void switchToProfessorManagePanel() {
        System.out.println("Professor page");
        professorManagePanel = new ProfessorManagePanel();
        switchTo(professorManagePanel);
        professorManagePanel.initTable();
        ////////////////////////////////////////
        professorManagePanel.getAddProfessorBtn().addActionListener(this);
        professorManagePanel.getDeleteProfessorBtn().addActionListener(this);
        professorManagePanel.getProfessorTable().addMouseListener(new MouseHandler());
    }

    public void switchToEachProfessorManagePanel(String professorFullName) {
        System.out.println("Each professor page");
        EachProfessorManagePanel eachProfessorManagePanel = new EachProfessorManagePanel(professorFullName);
        switchTo(eachProfessorManagePanel);
        ////////////////////////////////////////
        eachProfessorManagePanel.getGoBackLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchToProfessorManagePanel();
            }
        });
    }

    public void switchToStudentManagePanel() {
        System.out.println("Student page");
        studentManagePanel = new StudentManagePanel();
        switchTo(studentManagePanel);
        studentManagePanel.initTable();
        ////////////////////////////////////////

        studentManagePanel.getAddStudentBtn().addActionListener(this);
        studentManagePanel.getDeleteStudentBtn().addActionListener(this);
        studentManagePanel.getStudentTable().addMouseListener(new MouseHandler());
    }

    public void switchToEachStudentManagePanel(String student_id) {
        System.out.println("Each student page");
        eachStudentManagePanel = new EachStudentManagePanel(student_id);
        switchTo(eachStudentManagePanel);
        ////////////////////////////////////////
        eachStudentManagePanel.getGoBackLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchToStudentManagePanel();
            }
        });
    }

    public void switchToSubjectManagePanel() {
        System.out.println("Subject page");
        subjectManagePanel = new SubjectManagePanel();
        switchTo(subjectManagePanel);
        subjectManagePanel.initTable();
        ////////////////////////////////////////

        subjectManagePanel.getAddSubjectBtn().addActionListener(this);
        subjectManagePanel.getDeleteSubjectBtn().addActionListener(this);
        subjectManagePanel.getSubjectTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Drill down to -> switchToEachSubjectPanel;
                int row = subjectManagePanel.getSubjectTable().rowAtPoint(e.getPoint());
                int col = subjectManagePanel.getSubjectTable().columnAtPoint(e.getPoint());

                if (col == 5) {
                    switchToEachSubjectPanel(
                            (String) subjectManagePanel.getSubjectTable().getValueAt(row, 1),
                            (String) subjectManagePanel.getSubjectTable().getValueAt(row, 3),
                            Integer.toString((Integer) subjectManagePanel.getSubjectTable().getValueAt(row, 4)),
                            Integer.toString((Integer) subjectManagePanel.getSubjectTable().getValueAt(row, 5))
                    );
                }
            }
        });
    }

    public void switchToEachSubjectPanel(String subject, String professor, String amount, String subjectId) {
        eachSubjectManagePanel = new EachSubjectManagePanel(subject, professor, amount, subjectId);
        switchTo(eachSubjectManagePanel);
        eachSubjectManagePanel.initTable();

        eachSubjectManagePanel.getAddStudentBtn().addActionListener(this);
        eachSubjectManagePanel.getDeleteStudentBtn().addActionListener(this);
        eachSubjectManagePanel.getGoBackLabel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                switchTo(subjectManagePanel);
                subjectManagePanel.initTable();
            }
        });
    }

    public void switchToBranchManagePanel(String facultyName) {
        System.out.println("Branch page");
        branchManagePanel = new BranchManagePanel(facultyName);
        switchTo(branchManagePanel);
        branchManagePanel.initTable();
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
        branchManagePanel.getBranchTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (branchManagePanel != null && e.getSource().equals(branchManagePanel.getBranchTable())) {
                    int row = branchManagePanel.getBranchTable().rowAtPoint(e.getPoint());
                    int col = branchManagePanel.getBranchTable().columnAtPoint(e.getPoint());

                    if (col == 3) {
                        switchToEachBranchPanel((String) branchManagePanel.getBranchTable().getValueAt(row, 1), facultyName);
                    }
                }
            }
        });
    }

    public void switchToEachBranchPanel(String branch, String facluty) {
        branchStudentManagePanel = new BranchStudentManagePanel(branch, facluty);
        switchTo(branchStudentManagePanel);
        branchStudentManagePanel.initTable();

        branchStudentManagePanel.getAddStudentBtn().addActionListener(this);

        branchStudentManagePanel.getGoBackLabel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                switchTo(branchManagePanel);
                branchManagePanel.initTable();
            }
        });
    }

    public void switchToErrorPanel() {
        errorPanel = new ErrorPanel();
        switchTo(errorPanel);
    }

    private void switchTo(JPanel panelToSwitch) {
        this.getContentPanel().removeAll();
        this.getContentPanel().add(panelToSwitch);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    /* Action methods */
    @Override
    public void actionPerformed(ActionEvent event) {

        if (facultyManagePanel != null && event.getSource().equals(facultyManagePanel.getAddFacultyBtn())) {
            /* --------------------   Facult page   -------------------- */
            // Add a new faculty frame
            facultyManagePanel.createAddNewFacultyFrame();
            facultyManagePanel.configAddNewFacultyFrame();

        } else if (facultyManagePanel != null && event.getSource().equals(facultyManagePanel.getDeleteFacultyBtn())) {
            // Delete a faculty
            facultyManagePanel.deleteFaculty();
        } else if (branchManagePanel != null && event.getSource().equals(branchManagePanel.getAddBranchBtn())) {
            /* --------------------   Faculty -> Branch page   -------------------- */
            branchManagePanel.createAddNewBranchFrame();
            branchManagePanel.configAddNewBranchFrame();

        } else if (branchManagePanel != null && event.getSource().equals(branchManagePanel.getDeleteBranchBtn())) {
            // Delete a branch
            branchManagePanel.deleteBranch();

        } else if (branchStudentManagePanel != null && event.getSource().equals(branchStudentManagePanel.getAddStudentBtn())) {
            /* --------------------   Branch -> Add Student   -------------------- */
            branchStudentManagePanel.createAddNewBranchStudentFrame();
            branchStudentManagePanel.configAddNewBranchStudentFrame();

        } else if (subjectManagePanel != null && event.getSource().equals(subjectManagePanel.getAddSubjectBtn())) {
            /* --------------------   Subject page   -------------------- */
            subjectManagePanel.createAddNewSubjectFrame();
            subjectManagePanel.configAddNewSubjectFrame();

        } else if (subjectManagePanel != null && event.getSource().equals(subjectManagePanel.getDeleteSubjectBtn())) {
            // Delete a subject
            subjectManagePanel.deleteSubject();

        } else if (studentManagePanel != null && event.getSource().equals(studentManagePanel.getAddStudentBtn())) {
            /* --------------------   Subject page   -------------------- */
            studentManagePanel.createAddNewStudentFrame();
            studentManagePanel.configAddNewStudentFrame();

        } else if (studentManagePanel != null && event.getSource().equals(studentManagePanel.getDeleteStudentBtn())) {
            // Delete a subject
            studentManagePanel.deleteStudent();
        } else if (professorManagePanel != null && event.getSource().equals(professorManagePanel.getAddProfessorBtn())) {
            /* --------------------   Professor page   -------------------- */
            professorManagePanel.createAddNewProfessorFrame();
            professorManagePanel.configAddNewProfessorFrame();
        } else if (professorManagePanel != null && event.getSource().equals(professorManagePanel.getDeleteProfessorBtn())) {
            // Delete a professor
            professorManagePanel.deleteProfessor();
        } else if (eachSubjectManagePanel != null && event.getSource().equals(eachSubjectManagePanel.getAddStudentBtn())) {
            /* --------------------   Each subjet page   -------------------- */
            eachSubjectManagePanel.createAddNewStudenntFrame();
            eachSubjectManagePanel.configAddNewStudentFrame();
        } else if (eachSubjectManagePanel != null && event.getSource().equals(eachSubjectManagePanel.getDeleteStudentBtn())) {
            eachSubjectManagePanel.deleteStudent();
        }
    }

    class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (facultyManagePanel != null && e.getSource().equals(facultyManagePanel.getFacultyTable())) {
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
                    switchToBranchManagePanel((String) facultyManagePanel.getFacultyTable().getModel().getValueAt(row, 1));
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
            } else if (studentManagePanel != null && e.getSource().equals(studentManagePanel.getStudentTable())) {
                int row = studentManagePanel.getStudentTable().rowAtPoint(e.getPoint());
                int col = studentManagePanel.getStudentTable().columnAtPoint(e.getPoint());
                if (col == 4) {
                    switchToEachStudentManagePanel((String) studentManagePanel.getStudentTable().getModel().getValueAt(row, 2));
                }
            } else if (professorManagePanel != null && e.getSource().equals(professorManagePanel.getProfessorTable())) {
                int row = professorManagePanel.getProfessorTable().rowAtPoint(e.getPoint());
                int col = professorManagePanel.getProfessorTable().columnAtPoint(e.getPoint());
                if (col == 4) {
                    switchToEachProfessorManagePanel((String) professorManagePanel.getProfessorTable().getModel().getValueAt(row, 1));
                }
            }
        }
    }
}
