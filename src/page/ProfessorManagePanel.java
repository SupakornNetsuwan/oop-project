package page;

import frame.AddNewProfessorFrame;
import components.*;
import frame.AlertFrame;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import model.ProfessorModel;
import model.Professor;

public class ProfessorManagePanel extends JPanel implements ActionListener {

    private AddNewProfessorFrame addNewProfessorFrame; // Internal frame
    private ProfessorModel professorModel = new ProfessorModel();

    public ProfessorManagePanel() {
        initComponents();
        initTable();
    }

    public void initTable() {
        ArrayList<Professor> professors = professorModel.getProfessors();
        this.getProfessorTable().clearTable();
        for (int i = 0; i < professors.size(); i++) {
            Professor professor = professors.get(i);
            Object[] object = {null, professor.getFullname(), professor.getDegree(), null};
            if((String.valueOf(object[1]).contains(this.getFindProfessor().getText())) || (String.valueOf(object[2]).contains(this.getFindProfessor().getText()))){
                this.getProfessorTable().addRow(object);
            }
        }
    }

    public Table getProfessorTable() {
        return this.professorTable;
    }

    public JButton getAddProfessorBtn() {
        return this.addProfessor;
    }

    public JButton getDeleteProfessorBtn() {
        return this.deleteProfessor;
    }

    public JTextField getFindProfessor() {
        return findProfessor;
    }

    public AddNewProfessorFrame getAddNewProfessorFrame() {
        return this.addNewProfessorFrame;
    }

    public void createAddNewProfessorFrame() {
        this.addNewProfessorFrame = new AddNewProfessorFrame();
        addNewProfessorFrame.getAddProfessor().addActionListener(this);
    }

    public void configAddNewProfessorFrame() {
        this.addNewProfessorFrame.config();
    }

    public void deleteProfessor() {

        for (int i = 0; i < this.getProfessorTable().getRowCount(); i++) {
            Boolean selected = (Boolean) this.getProfessorTable().getModel().getValueAt(i, 0);
            if (selected == null) {
                selected = false;
            }

            String professorFullname = this.getProfessorTable().getModel().getValueAt(i, 1).toString();
            if (selected) {
                // delete selected
                if (!professorModel.deleteProfessor(professorFullname)) {
                    new AlertFrame(null, "?????????????????????????????????????????????????????? " + professorFullname + " ??????????????????????????????????????????????????????????????????????????? ????????????????????????????????????????????????", "???????????????????????????????????????????????????????????????");
                }
            }
        }

        this.initTable();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(addNewProfessorFrame.getAddProfessor())) {
            // Clicked on add new professor btn
            String professorFullName = addNewProfessorFrame.getProfessorFullnameTextField().getText();
            String professorGender = addNewProfessorFrame.getProfessorGenderTextField().getText();
            String professorAge = addNewProfessorFrame.getProfessorAgeTextField().getText();
            String professorPhone = addNewProfessorFrame.getProfessorPhoneTextField().getText();
            String professorDegree = addNewProfessorFrame.getProfessorDegreeTextFIeld().getText();

            if (!professorFullName.isBlank() && !professorGender.isBlank() && !professorAge.isBlank() && !professorPhone.isBlank() && !professorDegree.isBlank()) {
                if (!professorModel.addProfessor(professorFullName, professorDegree, "-", professorGender, professorAge, professorPhone)) {
                    JOptionPane.showMessageDialog(addNewProfessorFrame, "Error, make sure your inserted data is correctly and no duplicated professor's name", "Error!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
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
        pageHeader = new javax.swing.JLabel();
        headerSeparator = new javax.swing.JSeparator();
        centerPanel = new javax.swing.JPanel();
        actionWrapper = new javax.swing.JPanel();
        buttonsWrapper = new javax.swing.JPanel();
        deleteProfessor = new javax.swing.JButton();
        addProfessor = new javax.swing.JButton();
        findProfessor = new javax.swing.JTextField();
        tableScrollPane = new javax.swing.JScrollPane();
        professorTable = new components.Table();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new java.awt.Dimension(1000, 720));
        setLayout(new java.awt.BorderLayout(0, 5));

        northPanel.setBackground(new java.awt.Color(255, 255, 255));
        northPanel.setLayout(new javax.swing.BoxLayout(northPanel, javax.swing.BoxLayout.PAGE_AXIS));

        pageHeader.setFont(new java.awt.Font("Prompt", 1, 28)); // NOI18N
        pageHeader.setForeground(new java.awt.Color(93, 93, 93));
        pageHeader.setText("???????????????????????????????????????");
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

        deleteProfessor.setBackground(new java.awt.Color(249, 249, 249));
        deleteProfessor.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        deleteProfessor.setForeground(new java.awt.Color(230, 63, 63));
        deleteProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        deleteProfessor.setText("????????????????????????????????????");
        deleteProfessor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 63, 63), 2, true));
        deleteProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteProfessor.setMargin(new java.awt.Insets(2, 5, 3, 5));
        deleteProfessor.setPreferredSize(new java.awt.Dimension(140, 40));
        deleteProfessor.setRequestFocusEnabled(false);
        deleteProfessor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        deleteProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProfessorActionPerformed(evt);
            }
        });
        buttonsWrapper.add(deleteProfessor, java.awt.BorderLayout.LINE_START);

        addProfessor.setBackground(new java.awt.Color(255, 137, 47));
        addProfessor.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        addProfessor.setForeground(new java.awt.Color(255, 255, 255));
        addProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addProfessor.setText("????????????????????????????????????????????????");
        addProfessor.setBorder(null);
        addProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProfessor.setMargin(new java.awt.Insets(2, 5, 3, 5));
        addProfessor.setPreferredSize(new java.awt.Dimension(130, 40));
        addProfessor.setRequestFocusEnabled(false);
        addProfessor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        addProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProfessorActionPerformed(evt);
            }
        });
        buttonsWrapper.add(addProfessor, java.awt.BorderLayout.EAST);

        actionWrapper.add(buttonsWrapper, java.awt.BorderLayout.EAST);

        findProfessor.setColumns(20);
        findProfessor.setFont(new java.awt.Font("Prompt", 1, 14)); // NOI18N
        findProfessor.setForeground(new java.awt.Color(93, 93, 93));
        findProfessor.setToolTipText("");
        findProfessor.setActionCommand("<Not Set>");
        findProfessor.setAutoscrolls(false);
        findProfessor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "????????????????????????????????????", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Prompt", 0, 12), new java.awt.Color(149, 149, 149))); // NOI18N
        findProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        findProfessor.setMargin(new java.awt.Insets(2, 24, 2, 24));
        findProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findProfessorActionPerformed(evt);
            }
        });
        actionWrapper.add(findProfessor, java.awt.BorderLayout.LINE_START);

        tableScrollPane.setBorder(null);

        professorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "????????????????????????", "????????????????????????-?????????????????????", "???????????????????????????????????????", "????????????????????????"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableScrollPane.setViewportView(professorTable);
        if (professorTable.getColumnModel().getColumnCount() > 0) {
            professorTable.getColumnModel().getColumn(0).setMinWidth(80);
            professorTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            professorTable.getColumnModel().getColumn(0).setMaxWidth(80);
            professorTable.getColumnModel().getColumn(3).setMinWidth(100);
            professorTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            professorTable.getColumnModel().getColumn(3).setMaxWidth(100);
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

    private void findProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findProfessorActionPerformed

    private void deleteProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteProfessorActionPerformed

    private void addProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addProfessorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionWrapper;
    private javax.swing.JButton addProfessor;
    private javax.swing.JPanel buttonsWrapper;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton deleteProfessor;
    private javax.swing.JTextField findProfessor;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JPanel northPanel;
    private javax.swing.JLabel pageHeader;
    private components.Table professorTable;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
