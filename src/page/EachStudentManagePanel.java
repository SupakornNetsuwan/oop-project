package page;

import javax.swing.*;
import model.StudentModel;
import model.Student;

public class EachStudentManagePanel extends JPanel {

    private StudentModel studentModel = new StudentModel();
    private Student student;

    public EachStudentManagePanel(String studentId) {

        initComponents();
        this.setStudent(studentModel.getStudent(studentId));
        this.studentDetailInit();
    }

    public void studentDetailInit() {
        this.getStudentHeaderLabel().setText("จัดการนักศึกษา (" + student.getFullname() + ")");
        this.getFullnameLabel().setText(student.getFullname());
        this.getStudentIdLabel().setText(student.getStudentId());
        this.getGenderLabel().setText(student.getGender());
        this.getAgeLabel().setText(student.getAge());
        this.getPhoneLabel().setText(student.getPhone());
        this.getFacultyLabel().setText(student.getFaculty());
        this.getBranchLabel().setText(student.getBranch());
    }

    public JLabel getStudentIdLabel() {
        return studentId;
    }

    public JLabel getAgeLabel() {
        return age;
    }

    public JLabel getBranchLabel() {
        return branch;
    }

    public JLabel getFacultyLabel() {
        return faculty;
    }

    public JLabel getFullnameLabel() {
        return fullname;
    }

    public JLabel getGenderLabel() {
        return gender;
    }

    public JList<String> getSubjectList() {
        return subjectList;
    }

    public JLabel getStudentHeaderLabel() {
        return studentHeader;
    }

    public JLabel getPhoneLabel() {
        return phone;
    }

    public StudentModel getStudentModel() {
        return studentModel;
    }

    public JLabel getGoBackLabel() {
        return this.goBackLabel;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return this.student;
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
        studentHeader = new javax.swing.JLabel();
        headerSeparator = new javax.swing.JSeparator();
        centerPanel = new javax.swing.JPanel();
        studentDetailWrapper = new javax.swing.JPanel();
        fullnameLabel = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        studentidLabel = new javax.swing.JLabel();
        studentId = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        facultyLabel = new javax.swing.JLabel();
        faculty = new javax.swing.JLabel();
        branchLabel = new javax.swing.JLabel();
        branch = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        studentSubjectsWrapper = new javax.swing.JPanel();
        subjectsLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        subjectList = new javax.swing.JList<>();

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
        goBackLabel.setText("กลับ");
        goBackLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        goBackLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        goBackLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goBackLabel.setMaximumSize(new java.awt.Dimension(73, 31));
        goBackLabel.setPreferredSize(new java.awt.Dimension(63, 50));
        goBackLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goBackLabelMouseClicked(evt);
            }
        });
        northPanelWrapper.add(goBackLabel, java.awt.BorderLayout.LINE_START);

        studentHeader.setFont(new java.awt.Font("Prompt", 1, 28)); // NOI18N
        studentHeader.setForeground(new java.awt.Color(93, 93, 93));
        studentHeader.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        studentHeader.setText("จัดการนักศึกษา (นายศุภกร เนตรสุวรรณ)");
        studentHeader.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        studentHeader.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        studentHeader.setPreferredSize(new java.awt.Dimension(600, 53));
        northPanelWrapper.add(studentHeader, java.awt.BorderLayout.CENTER);

        northPanel.add(northPanelWrapper);

        headerSeparator.setForeground(new java.awt.Color(193, 193, 193));
        headerSeparator.setPreferredSize(new java.awt.Dimension(950, 2));
        northPanel.add(headerSeparator);

        add(northPanel, java.awt.BorderLayout.PAGE_START);

        centerPanel.setBackground(new java.awt.Color(255, 255, 255));
        centerPanel.setForeground(new java.awt.Color(93, 93, 93));

        studentDetailWrapper.setBackground(new java.awt.Color(255, 255, 255));
        studentDetailWrapper.setLayout(new java.awt.GridLayout(0, 2, 2, 2));

        fullnameLabel.setBackground(new java.awt.Color(255, 255, 255));
        fullnameLabel.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        fullnameLabel.setText("ชื่อจริง-นามสกุล");
        studentDetailWrapper.add(fullnameLabel);

        fullname.setBackground(new java.awt.Color(255, 255, 255));
        fullname.setFont(new java.awt.Font("Prompt", 0, 14)); // NOI18N
        fullname.setForeground(new java.awt.Color(134, 134, 134));
        fullname.setText("นายศุภกร เนตรสุวรรณ");
        studentDetailWrapper.add(fullname);

        studentidLabel.setBackground(new java.awt.Color(255, 255, 255));
        studentidLabel.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        studentidLabel.setText("รหัสนักศึกษา");
        studentDetailWrapper.add(studentidLabel);

        studentId.setBackground(new java.awt.Color(255, 255, 255));
        studentId.setFont(new java.awt.Font("Prompt", 0, 14)); // NOI18N
        studentId.setForeground(new java.awt.Color(134, 134, 134));
        studentId.setText("64070108");
        studentDetailWrapper.add(studentId);

        genderLabel.setBackground(new java.awt.Color(255, 255, 255));
        genderLabel.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        genderLabel.setText("เพศ");
        studentDetailWrapper.add(genderLabel);

        gender.setBackground(new java.awt.Color(255, 255, 255));
        gender.setFont(new java.awt.Font("Prompt", 0, 14)); // NOI18N
        gender.setForeground(new java.awt.Color(134, 134, 134));
        gender.setText("ชาย");
        studentDetailWrapper.add(gender);

        ageLabel.setBackground(new java.awt.Color(255, 255, 255));
        ageLabel.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        ageLabel.setText("อายุ");
        studentDetailWrapper.add(ageLabel);

        age.setBackground(new java.awt.Color(255, 255, 255));
        age.setFont(new java.awt.Font("Prompt", 0, 14)); // NOI18N
        age.setForeground(new java.awt.Color(134, 134, 134));
        age.setText("20");
        studentDetailWrapper.add(age);

        phoneLabel.setBackground(new java.awt.Color(255, 255, 255));
        phoneLabel.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        phoneLabel.setText("เบอร์โทรศัพท์");
        studentDetailWrapper.add(phoneLabel);

        phone.setBackground(new java.awt.Color(255, 255, 255));
        phone.setFont(new java.awt.Font("Prompt", 0, 14)); // NOI18N
        phone.setForeground(new java.awt.Color(134, 134, 134));
        phone.setText("0959259515");
        studentDetailWrapper.add(phone);

        facultyLabel.setBackground(new java.awt.Color(255, 255, 255));
        facultyLabel.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        facultyLabel.setText("คณะ");
        studentDetailWrapper.add(facultyLabel);

        faculty.setBackground(new java.awt.Color(255, 255, 255));
        faculty.setFont(new java.awt.Font("Prompt", 0, 14)); // NOI18N
        faculty.setForeground(new java.awt.Color(134, 134, 134));
        faculty.setText("คณะเทคโนโลยีสารสนเทศ");
        studentDetailWrapper.add(faculty);

        branchLabel.setBackground(new java.awt.Color(255, 255, 255));
        branchLabel.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        branchLabel.setText("สาขา");
        studentDetailWrapper.add(branchLabel);

        branch.setBackground(new java.awt.Color(255, 255, 255));
        branch.setFont(new java.awt.Font("Prompt", 0, 14)); // NOI18N
        branch.setForeground(new java.awt.Color(134, 134, 134));
        branch.setText("สาขา IT");
        studentDetailWrapper.add(branch);

        jSeparator1.setBackground(new java.awt.Color(193, 193, 193));
        jSeparator1.setForeground(new java.awt.Color(193, 193, 193));

        studentSubjectsWrapper.setBackground(new java.awt.Color(255, 255, 255));

        subjectsLabel.setBackground(new java.awt.Color(255, 255, 255));
        subjectsLabel.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        subjectsLabel.setText("วิชาที่เรียน");

        subjectList.setFont(new java.awt.Font("Prompt", 0, 14)); // NOI18N
        subjectList.setForeground(new java.awt.Color(134, 134, 134));
        subjectList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "วิชา xxx-1", "วิชา xxx-2", "วิชา  yyyy-1", "วิชา  yyzz-2" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        subjectList.setSelectionBackground(new java.awt.Color(255, 137, 47));
        subjectList.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(subjectList);

        javax.swing.GroupLayout studentSubjectsWrapperLayout = new javax.swing.GroupLayout(studentSubjectsWrapper);
        studentSubjectsWrapper.setLayout(studentSubjectsWrapperLayout);
        studentSubjectsWrapperLayout.setHorizontalGroup(
            studentSubjectsWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentSubjectsWrapperLayout.createSequentialGroup()
                .addComponent(subjectsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        studentSubjectsWrapperLayout.setVerticalGroup(
            studentSubjectsWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentSubjectsWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentSubjectsWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(studentDetailWrapper, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                    .addComponent(studentSubjectsWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(studentDetailWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentSubjectsWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void goBackLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackLabelMouseClicked

    }//GEN-LAST:event_goBackLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JLabel branch;
    private javax.swing.JLabel branchLabel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel faculty;
    private javax.swing.JLabel facultyLabel;
    private javax.swing.JLabel fullname;
    private javax.swing.JLabel fullnameLabel;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel goBackLabel;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel northPanel;
    private javax.swing.JPanel northPanelWrapper;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JPanel studentDetailWrapper;
    private javax.swing.JLabel studentHeader;
    private javax.swing.JLabel studentId;
    private javax.swing.JPanel studentSubjectsWrapper;
    private javax.swing.JLabel studentidLabel;
    private javax.swing.JList<String> subjectList;
    private javax.swing.JLabel subjectsLabel;
    // End of variables declaration//GEN-END:variables
}
