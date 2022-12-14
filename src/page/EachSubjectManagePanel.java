package page;

import components.*;
import frame.AddNewSubjectStudentFrame;
import frame.AlertFrame;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import model.Student;
import model.StudentInSubjectModel;
import model.Subject;
import model.SubjectModel;

public class EachSubjectManagePanel extends JPanel implements ActionListener {

    private AddNewSubjectStudentFrame addNewSubjectStudentFrame; // Internal frame
    private StudentInSubjectModel studentInSubjectModel = new StudentInSubjectModel();
    private Subject subject = new Subject();
    private SubjectModel subjectModel = new SubjectModel();
    /* Local variable */
    private String subjectId;

    public EachSubjectManagePanel(String subjectId) {
        this.subjectId = subjectId;
        initComponents();
        initSubjectDetail();
        initTable();
    }

    public void initSubjectDetail() {
        this.setSubject(subjectModel.getSubject(this.subjectId));
        this.subjectNameHeader.setText(subject.getName());
        this.professorName.setText(subject.getProfessorName());
        this.studentAmount.setText(subject.getQuantityStudent() + "");
        this.subjectDetail.setText(subject.getDetail());
    }
    
    public void initTable() {
        ArrayList<Student> students = studentInSubjectModel.studentInSubjectList(this.subjectId);
        getStudentTable().setViewDataBtnColumn(5);
        this.getStudentTable().clearTable();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            Object[] object = {null, student.getFullname(), student.getStudentId(), student.getFaculty() + "/" + student.getBranch(), student.getGender()};
            if ((String.valueOf(object[1]).contains(this.getFindStudent().getText())) || (String.valueOf(object[2]).contains(this.getFindStudent().getText()))
                    || (String.valueOf(object[3]).contains(this.getFindStudent().getText())) || (String.valueOf(object[4]).contains(this.getFindStudent().getText()))) {
                this.getStudentTable().addRow(object);
            }
        }
        initSubjectDetail();
    }

    public Table getStudentTable() {
        return this.studentTable;
    }

    public JButton getAddStudentBtn() {
        return this.addStudent;
    }

    public JButton getDeleteStudentBtn() {
        return this.deleteStudent;
    }

    public JTextField getFindStudent() {
        return findStudent;
    }

    public JLabel getGoBackLabel() {
        return this.goBackLabel;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }
 
    public void createAddNewStudenntFrame() {
        this.addNewSubjectStudentFrame = new AddNewSubjectStudentFrame();
        addNewSubjectStudentFrame.getAddStudentBtn().addActionListener(this);
    }

    public void configAddNewStudentFrame() {
        this.addNewSubjectStudentFrame.config();
    }

    public void deleteStudent() {
        for (int i = 0; i < this.getStudentTable().getRowCount(); i++) {
            Boolean selected = (Boolean) this.getStudentTable().getModel().getValueAt(i, 0);
            if (selected == null) {
                selected = false;
            }
            String studentId = this.getStudentTable().getModel().getValueAt(i, 2).toString();
            
            
            if (selected) {
                studentInSubjectModel.deleteStudentFromSubject(subjectId, studentId);
            }
        }
        this.initTable();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(addNewSubjectStudentFrame.getAddStudentBtn())) {
            String studentName = (String) addNewSubjectStudentFrame.getStudentNameComboBox().getSelectedItem();
            String[] studentNameSplit = studentName.split("\\(", 2);

            StringBuffer sliceLastChar = new StringBuffer(studentNameSplit[1]);
            String studentId = sliceLastChar.deleteCharAt(sliceLastChar.length() - 1).toString();

            if (!studentInSubjectModel.addStudentToSubject(subjectId, studentId)) {
                new AlertFrame(addNewSubjectStudentFrame, "?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????", "???????????????????????????????????????????????????????????????????????????");
                return;
            }
            this.initTable();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        northPanel = new javax.swing.JPanel();
        northPanelWrapper = new javax.swing.JPanel();
        goBackLabel = new javax.swing.JLabel();
        nameHeader = new javax.swing.JPanel();
        subjectNameHeader = new javax.swing.JLabel();
        headerSeparator = new javax.swing.JSeparator();
        centerPanel = new javax.swing.JPanel();
        actionWrapper = new javax.swing.JPanel();
        buttonsWrapper = new javax.swing.JPanel();
        deleteStudent = new javax.swing.JButton();
        addStudent = new javax.swing.JButton();
        findStudent = new javax.swing.JTextField();
        subjectDetails = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectDetail = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        professorName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        studentAmount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tableScrollPane = new javax.swing.JScrollPane();
        studentTable = new components.Table();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new java.awt.Dimension(1000, 720));
        setLayout(new java.awt.BorderLayout(0, 5));

        northPanel.setBackground(new java.awt.Color(255, 255, 255));
        northPanel.setLayout(new javax.swing.BoxLayout(northPanel, javax.swing.BoxLayout.PAGE_AXIS));

        northPanelWrapper.setBackground(new java.awt.Color(255, 255, 255));
        northPanelWrapper.setLayout(new java.awt.BorderLayout());

        goBackLabel.setBackground(new java.awt.Color(255, 137, 47));
        goBackLabel.setFont(new java.awt.Font("Prompt Medium", 0, 20)); // NOI18N
        goBackLabel.setForeground(new java.awt.Color(255, 137, 47));
        goBackLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        goBackLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        goBackLabel.setText("????????????");
        goBackLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        goBackLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        goBackLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goBackLabel.setMaximumSize(new java.awt.Dimension(73, 31));
        goBackLabel.setPreferredSize(new java.awt.Dimension(63, 50));
        northPanelWrapper.add(goBackLabel, java.awt.BorderLayout.LINE_START);

        nameHeader.setBackground(new java.awt.Color(255, 255, 255));

        subjectNameHeader.setFont(new java.awt.Font("Prompt", 1, 28)); // NOI18N
        subjectNameHeader.setForeground(new java.awt.Color(93, 93, 93));
        subjectNameHeader.setText("???????????? OOP");
        subjectNameHeader.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        subjectNameHeader.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        javax.swing.GroupLayout nameHeaderLayout = new javax.swing.GroupLayout(nameHeader);
        nameHeader.setLayout(nameHeaderLayout);
        nameHeaderLayout.setHorizontalGroup(
            nameHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nameHeaderLayout.createSequentialGroup()
                .addContainerGap(785, Short.MAX_VALUE)
                .addComponent(subjectNameHeader))
        );
        nameHeaderLayout.setVerticalGroup(
            nameHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nameHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(subjectNameHeader))
        );

        northPanelWrapper.add(nameHeader, java.awt.BorderLayout.CENTER);

        northPanel.add(northPanelWrapper);

        headerSeparator.setForeground(new java.awt.Color(193, 193, 193));
        headerSeparator.setPreferredSize(new java.awt.Dimension(950, 2));
        northPanel.add(headerSeparator);

        add(northPanel, java.awt.BorderLayout.PAGE_START);

        centerPanel.setBackground(new java.awt.Color(249, 249, 249));

        actionWrapper.setBackground(new java.awt.Color(249, 249, 249));
        actionWrapper.setLayout(new java.awt.BorderLayout());

        buttonsWrapper.setLayout(new java.awt.BorderLayout(5, 0));

        deleteStudent.setBackground(new java.awt.Color(249, 249, 249));
        deleteStudent.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        deleteStudent.setForeground(new java.awt.Color(230, 63, 63));
        deleteStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        deleteStudent.setText("??????????????????????????????????????????????????????");
        deleteStudent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 63, 63), 2, true));
        deleteStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteStudent.setMargin(new java.awt.Insets(2, 5, 3, 5));
        deleteStudent.setPreferredSize(new java.awt.Dimension(140, 40));
        deleteStudent.setRequestFocusEnabled(false);
        deleteStudent.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        deleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentActionPerformed(evt);
            }
        });
        buttonsWrapper.add(deleteStudent, java.awt.BorderLayout.LINE_START);

        addStudent.setBackground(new java.awt.Color(255, 137, 47));
        addStudent.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        addStudent.setForeground(new java.awt.Color(255, 255, 255));
        addStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addStudent.setText("???????????????????????????????????????");
        addStudent.setBorder(null);
        addStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addStudent.setMargin(new java.awt.Insets(2, 5, 3, 5));
        addStudent.setPreferredSize(new java.awt.Dimension(120, 40));
        addStudent.setRequestFocusEnabled(false);
        addStudent.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        addStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentActionPerformed(evt);
            }
        });
        buttonsWrapper.add(addStudent, java.awt.BorderLayout.EAST);

        actionWrapper.add(buttonsWrapper, java.awt.BorderLayout.EAST);

        findStudent.setColumns(20);
        findStudent.setFont(new java.awt.Font("Prompt", 1, 14)); // NOI18N
        findStudent.setForeground(new java.awt.Color(93, 93, 93));
        findStudent.setToolTipText("");
        findStudent.setActionCommand("<Not Set>");
        findStudent.setAutoscrolls(false);
        findStudent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "???????????????????????????????????????", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Prompt", 0, 12), new java.awt.Color(149, 149, 149))); // NOI18N
        findStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        findStudent.setMargin(new java.awt.Insets(2, 24, 2, 24));
        findStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findStudentActionPerformed(evt);
            }
        });
        actionWrapper.add(findStudent, java.awt.BorderLayout.LINE_START);

        subjectDetails.setBackground(new java.awt.Color(249, 249, 249));

        jLabel3.setFont(new java.awt.Font("Prompt", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(93, 93, 93));
        jLabel3.setText("??????????????????????????????????????????");

        subjectDetail.setEditable(false);
        subjectDetail.setBackground(new java.awt.Color(249, 249, 249));
        subjectDetail.setColumns(20);
        subjectDetail.setFont(new java.awt.Font("Prompt", 1, 18)); // NOI18N
        subjectDetail.setRows(5);
        jScrollPane1.setViewportView(subjectDetail);

        jLabel1.setFont(new java.awt.Font("Prompt", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(93, 93, 93));
        jLabel1.setText("??????????????????");

        professorName.setFont(new java.awt.Font("Prompt", 1, 18)); // NOI18N
        professorName.setForeground(new java.awt.Color(93, 93, 93));
        professorName.setText("??????.??????. ???????????????????????? ?????????????????????");

        jLabel2.setFont(new java.awt.Font("Prompt", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(134, 134, 134));
        jLabel2.setText("??????????????????????????????????????????????????????");

        studentAmount.setFont(new java.awt.Font("Prompt", 1, 14)); // NOI18N
        studentAmount.setForeground(new java.awt.Color(134, 134, 134));
        studentAmount.setText("9999");

        jLabel4.setFont(new java.awt.Font("Prompt", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(134, 134, 134));
        jLabel4.setText("??????");

        tableScrollPane.setBorder(null);

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "????????????????????????", "????????????-?????????????????????", "????????????????????????????????????", "?????????/????????????", "?????????"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableScrollPane.setViewportView(studentTable);
        if (studentTable.getColumnModel().getColumnCount() > 0) {
            studentTable.getColumnModel().getColumn(0).setMinWidth(80);
            studentTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            studentTable.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        javax.swing.GroupLayout subjectDetailsLayout = new javax.swing.GroupLayout(subjectDetails);
        subjectDetails.setLayout(subjectDetailsLayout);
        subjectDetailsLayout.setHorizontalGroup(
            subjectDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
            .addGroup(subjectDetailsLayout.createSequentialGroup()
                .addGroup(subjectDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subjectDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(professorName))
                    .addGroup(subjectDetailsLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentAmount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(jLabel3))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        subjectDetailsLayout.setVerticalGroup(
            subjectDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subjectDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(professorName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subjectDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(studentAmount)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                    .addComponent(subjectDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actionWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subjectDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void findStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findStudentActionPerformed

    private void deleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteStudentActionPerformed

    private void addStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStudentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionWrapper;
    private javax.swing.JButton addStudent;
    private javax.swing.JPanel buttonsWrapper;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton deleteStudent;
    private javax.swing.JTextField findStudent;
    private javax.swing.JLabel goBackLabel;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel nameHeader;
    private javax.swing.JPanel northPanel;
    private javax.swing.JPanel northPanelWrapper;
    private javax.swing.JLabel professorName;
    private javax.swing.JLabel studentAmount;
    private components.Table studentTable;
    private javax.swing.JTextArea subjectDetail;
    private javax.swing.JPanel subjectDetails;
    private javax.swing.JLabel subjectNameHeader;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
