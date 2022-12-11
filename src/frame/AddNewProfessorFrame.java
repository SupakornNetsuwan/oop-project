package frame;

import java.awt.*;
import javax.swing.*;

public class AddNewProfessorFrame extends JFrame {

    public AddNewProfessorFrame() {
        initComponents();
    }

    public void init() {

    }

    public void config() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wrapper = new javax.swing.JPanel();
        professorName = new javax.swing.JLabel();
        professorNameTextField = new javax.swing.JTextField();
        professorEducation = new javax.swing.JLabel();
        professorEducationTextFIeld = new javax.swing.JTextField();
        professorAge = new javax.swing.JLabel();
        professorAgeTextField = new javax.swing.JTextField();
        professorGender = new javax.swing.JLabel();
        professorGenderTextField = new javax.swing.JTextField();
        professorPhone = new javax.swing.JLabel();
        professorPhoneTextField = new javax.swing.JTextField();
        addStudent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("Add a new professor"); // NOI18N
        setResizable(false);

        wrapper.setBackground(new java.awt.Color(255, 255, 255));
        wrapper.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        wrapper.setDoubleBuffered(false);

        professorName.setFont(new java.awt.Font("Prompt Medium", 0, 20)); // NOI18N
        professorName.setForeground(new java.awt.Color(255, 137, 47));
        professorName.setText("ชื่อ นามสกุล");

        professorNameTextField.setFont(new java.awt.Font("Prompt", 0, 18)); // NOI18N
        professorNameTextField.setForeground(new java.awt.Color(154, 154, 154));
        professorNameTextField.setMargin(new java.awt.Insets(10, 10, 10, 10));

        professorEducation.setFont(new java.awt.Font("Prompt Medium", 0, 20)); // NOI18N
        professorEducation.setForeground(new java.awt.Color(255, 137, 47));
        professorEducation.setText("ระดับการศึกษา");

        professorEducationTextFIeld.setFont(new java.awt.Font("Prompt", 0, 18)); // NOI18N
        professorEducationTextFIeld.setForeground(new java.awt.Color(154, 154, 154));
        professorEducationTextFIeld.setMargin(new java.awt.Insets(10, 10, 10, 10));

        professorAge.setFont(new java.awt.Font("Prompt Medium", 0, 20)); // NOI18N
        professorAge.setForeground(new java.awt.Color(255, 137, 47));
        professorAge.setText("อายุ");

        professorAgeTextField.setFont(new java.awt.Font("Prompt", 0, 18)); // NOI18N
        professorAgeTextField.setForeground(new java.awt.Color(154, 154, 154));
        professorAgeTextField.setMargin(new java.awt.Insets(10, 10, 10, 10));

        professorGender.setFont(new java.awt.Font("Prompt Medium", 0, 20)); // NOI18N
        professorGender.setForeground(new java.awt.Color(255, 137, 47));
        professorGender.setText("เพศ");

        professorGenderTextField.setFont(new java.awt.Font("Prompt", 0, 18)); // NOI18N
        professorGenderTextField.setForeground(new java.awt.Color(154, 154, 154));
        professorGenderTextField.setMargin(new java.awt.Insets(10, 10, 10, 10));

        professorPhone.setFont(new java.awt.Font("Prompt Medium", 0, 20)); // NOI18N
        professorPhone.setForeground(new java.awt.Color(255, 137, 47));
        professorPhone.setText("เบอร์โทรศัพท์");

        professorPhoneTextField.setFont(new java.awt.Font("Prompt", 0, 18)); // NOI18N
        professorPhoneTextField.setForeground(new java.awt.Color(154, 154, 154));
        professorPhoneTextField.setMargin(new java.awt.Insets(10, 10, 10, 10));

        addStudent.setBackground(new java.awt.Color(255, 137, 47));
        addStudent.setFont(new java.awt.Font("Prompt", 0, 14)); // NOI18N
        addStudent.setForeground(new java.awt.Color(255, 255, 255));
        addStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addStudent.setText("เพิ่มอาจารย์");
        addStudent.setFocusPainted(false);
        addStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wrapperLayout = new javax.swing.GroupLayout(wrapper);
        wrapper.setLayout(wrapperLayout);
        wrapperLayout.setHorizontalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(professorNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addComponent(professorEducationTextFIeld, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, wrapperLayout.createSequentialGroup()
                        .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(professorAge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(professorAgeTextField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(professorGenderTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(professorGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(professorPhoneTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addComponent(professorEducation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(professorName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(professorPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        wrapperLayout.setVerticalGroup(
            wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wrapperLayout.createSequentialGroup()
                .addComponent(professorName)
                .addGap(18, 18, 18)
                .addComponent(professorNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(professorEducation)
                .addGap(18, 18, 18)
                .addComponent(professorEducationTextFIeld, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(professorAge)
                    .addComponent(professorGender))
                .addGap(18, 18, 18)
                .addGroup(wrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(professorAgeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(professorGenderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(professorPhone)
                .addGap(18, 18, 18)
                .addComponent(professorPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(addStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(wrapper, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStudentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudent;
    private javax.swing.JLabel professorAge;
    private javax.swing.JTextField professorAgeTextField;
    private javax.swing.JLabel professorEducation;
    private javax.swing.JTextField professorEducationTextFIeld;
    private javax.swing.JLabel professorGender;
    private javax.swing.JTextField professorGenderTextField;
    private javax.swing.JLabel professorName;
    private javax.swing.JTextField professorNameTextField;
    private javax.swing.JLabel professorPhone;
    private javax.swing.JTextField professorPhoneTextField;
    private javax.swing.JPanel wrapper;
    // End of variables declaration//GEN-END:variables
}