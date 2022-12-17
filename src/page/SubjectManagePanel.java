package page;

import frame.AddNewSubjectFrame;
import components.*;
import frame.AlertFrame;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import model.SubjectModel;

public class SubjectManagePanel extends JPanel implements ActionListener {

    private AddNewSubjectFrame addNewSubjectFrame; // Internal frame
    private SubjectModel subjectModel = new SubjectModel();

    public SubjectManagePanel() {
        initComponents();
        initTable();
    }

    public void initTable() {
        Object tableRows[][] = subjectModel.getSubjects();
        this.getSubjectTable().setViewDataBtnColumn(5);
        this.getSubjectTable().clearTable();
        for (Object[] tableRow : tableRows) {
            if((String.valueOf(tableRow[1]).contains(this.getFindSubject().getText())) || (String.valueOf(tableRow[2]).contains(this.getFindSubject().getText()))
            || (String.valueOf(tableRow[3]).contains(this.getFindSubject().getText()))){
                this.getSubjectTable().addRow(tableRow);
            }
        }

        // Loop from database and insert subject list
    }

    public Table getSubjectTable() {
        return this.subjectTable;
    }

    public JButton getAddSubjectBtn() {
        return this.addSubject;
    }

    public JButton getDeleteSubjectBtn() {
        return this.deleteSubject;
    }

    public JTextField getFindSubject() {
        return findSubject;
    }
    
    public AddNewSubjectFrame getAddNewSubjectFrame() {
        return this.addNewSubjectFrame;
    }

    public void createAddNewSubjectFrame() {
        this.addNewSubjectFrame = new AddNewSubjectFrame();
        addNewSubjectFrame.getAddSubjectBtn().addActionListener(this);
    }

    public void configAddNewSubjectFrame() {
        this.addNewSubjectFrame.config();
    }

    public void deleteSubject() {

        for (int i = 0; i < this.getSubjectTable().getRowCount(); i++) {
            Boolean selected = (Boolean) this.getSubjectTable().getModel().getValueAt(i, 0);
            if (selected == null) {
                selected = false;
            }
            String subjectId = this.getSubjectTable().getModel().getValueAt(i, 5).toString();
            String subjectName = this.getSubjectTable().getModel().getValueAt(i, 1).toString();
            if (selected) {
                // delete selected
                if (!subjectModel.deleteSubject(subjectId)) {
                    new AlertFrame(addNewSubjectFrame, "ไม่สามารถลบวิชา " + subjectName + " ได้เนื่องจากมีผู้เรียนอยู่ โปรดลบผู้เรียนก่อน", "ไม่สามารถดำเนินการได้");
                }
            }
        }

        this.initTable();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(addNewSubjectFrame.getAddSubjectBtn())) {
            // Clicked on add new subject btn
            // check in DB
            String subjectName = addNewSubjectFrame.getSubjectNameTextField().getText();
            String subjectID = addNewSubjectFrame.getSubjectIDTextField().getText();
            String professorName = addNewSubjectFrame.getSubjectProfComboBox().getSelectedItem().toString();
            String detail = addNewSubjectFrame.getSubjectDetailTextArea().getText();
            if (!subjectName.isBlank() && !subjectID.isBlank() && !professorName.isBlank()) {
                if (!subjectModel.addSubject(subjectName, subjectID, professorName, detail)) {
                    JOptionPane.showMessageDialog(addNewSubjectFrame, "Error, make sure your inserted data is correctly", "Error!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            System.out.println("ADDING SUBJECT");
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
        pageHeader = new javax.swing.JLabel();
        headerSeparator = new javax.swing.JSeparator();
        centerPanel = new javax.swing.JPanel();
        actionWrapper = new javax.swing.JPanel();
        buttonsWrapper = new javax.swing.JPanel();
        deleteSubject = new javax.swing.JButton();
        addSubject = new javax.swing.JButton();
        findSubject = new javax.swing.JTextField();
        tableScrollPane = new javax.swing.JScrollPane();
        subjectTable = new components.Table();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new java.awt.Dimension(1000, 720));
        setLayout(new java.awt.BorderLayout(0, 5));

        northPanel.setBackground(new java.awt.Color(255, 255, 255));
        northPanel.setLayout(new javax.swing.BoxLayout(northPanel, javax.swing.BoxLayout.PAGE_AXIS));

        pageHeader.setFont(new java.awt.Font("Prompt", 1, 28)); // NOI18N
        pageHeader.setForeground(new java.awt.Color(93, 93, 93));
        pageHeader.setText("จัดการวิชาเรียน");
        pageHeader.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pageHeader.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        northPanel.add(pageHeader);

        headerSeparator.setForeground(new java.awt.Color(193, 193, 193));
        headerSeparator.setPreferredSize(new java.awt.Dimension(950, 2));
        northPanel.add(headerSeparator);

        add(northPanel, java.awt.BorderLayout.PAGE_START);

        centerPanel.setBackground(new java.awt.Color(249, 249, 249));

        actionWrapper.setBackground(new java.awt.Color(249, 249, 249));
        actionWrapper.setLayout(new java.awt.BorderLayout());

        buttonsWrapper.setLayout(new java.awt.BorderLayout(5, 0));

        deleteSubject.setBackground(new java.awt.Color(249, 249, 249));
        deleteSubject.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        deleteSubject.setForeground(new java.awt.Color(230, 63, 63));
        deleteSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        deleteSubject.setText("ลบวิชาที่เลือก");
        deleteSubject.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 63, 63), 2, true));
        deleteSubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteSubject.setMargin(new java.awt.Insets(2, 5, 3, 5));
        deleteSubject.setPreferredSize(new java.awt.Dimension(140, 40));
        deleteSubject.setRequestFocusEnabled(false);
        deleteSubject.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        deleteSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSubjectActionPerformed(evt);
            }
        });
        buttonsWrapper.add(deleteSubject, java.awt.BorderLayout.LINE_START);

        addSubject.setBackground(new java.awt.Color(255, 137, 47));
        addSubject.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        addSubject.setForeground(new java.awt.Color(255, 255, 255));
        addSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addSubject.setText("เพิ่มวิชา");
        addSubject.setBorder(null);
        addSubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addSubject.setMargin(new java.awt.Insets(2, 5, 3, 5));
        addSubject.setPreferredSize(new java.awt.Dimension(100, 40));
        addSubject.setRequestFocusEnabled(false);
        addSubject.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        addSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubjectActionPerformed(evt);
            }
        });
        buttonsWrapper.add(addSubject, java.awt.BorderLayout.EAST);

        actionWrapper.add(buttonsWrapper, java.awt.BorderLayout.EAST);

        findSubject.setColumns(20);
        findSubject.setFont(new java.awt.Font("Prompt", 1, 14)); // NOI18N
        findSubject.setForeground(new java.awt.Color(93, 93, 93));
        findSubject.setToolTipText("");
        findSubject.setActionCommand("<Not Set>");
        findSubject.setAutoscrolls(false);
        findSubject.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ค้นหาวิชาเรียน", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Prompt", 0, 12), new java.awt.Color(149, 149, 149))); // NOI18N
        findSubject.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        findSubject.setMargin(new java.awt.Insets(2, 24, 2, 24));
        findSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findSubjectActionPerformed(evt);
            }
        });
        actionWrapper.add(findSubject, java.awt.BorderLayout.LINE_START);

        tableScrollPane.setBorder(null);

        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "การเลือก", "ชื่อวิชาเรียน", "รหัสวิชา", "อาจารย์ผู้สอน", "ผู้ลงเรียน", "ดูข้อมูล"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableScrollPane.setViewportView(subjectTable);
        if (subjectTable.getColumnModel().getColumnCount() > 0) {
            subjectTable.getColumnModel().getColumn(0).setMinWidth(80);
            subjectTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            subjectTable.getColumnModel().getColumn(0).setMaxWidth(80);
            subjectTable.getColumnModel().getColumn(1).setPreferredWidth(180);
            subjectTable.getColumnModel().getColumn(3).setPreferredWidth(120);
            subjectTable.getColumnModel().getColumn(5).setMinWidth(100);
            subjectTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            subjectTable.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE))
                .addContainerGap())
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actionWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void findSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findSubjectActionPerformed

    private void deleteSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteSubjectActionPerformed

    private void addSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addSubjectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionWrapper;
    private javax.swing.JButton addSubject;
    private javax.swing.JPanel buttonsWrapper;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton deleteSubject;
    private javax.swing.JTextField findSubject;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JPanel northPanel;
    private javax.swing.JLabel pageHeader;
    private components.Table subjectTable;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
