package page;

import frame.AddNewFacultyFrame;
import components.*;
import frame.AlertFrame;
import java.awt.event.*;
import javax.swing.*;
import model.FacultyModel;
import model.BranchModel;

public class FacultyManagePanel extends JPanel implements ActionListener {

    private AddNewFacultyFrame addNewFacultyFrame; // Internal frame
    private FacultyModel facultyModel = new FacultyModel();

    public FacultyManagePanel() {
        initComponents();
        initTable();
    }

    public void initTable() {
        Object tableRows[][] = facultyModel.getRecordsForTableContent();
        //String tableHeader[] = {"การเลือก", "ชื่อคณะ", "จำนวนสาขา", "ดูข้อมูล"};
        this.getFacultyTable().clearTable();
        for (Object[] tableRow : tableRows) {
            if(String.valueOf(tableRow[1]).contains(this.getFindFacultyTextField().getText())){
                this.getFacultyTable().addRow(tableRow);
            }
        }
    }

    public FacultyModel getFacultyModel() {
        return facultyModel;
    }

    public Table getFacultyTable() {
        return this.facultyTable;
    }

    public JButton getAddFacultyBtn() {
        return this.addFaculty;
    }

    public JButton getDeleteFacultyBtn() {
        return this.deleteFaculty;
    }

    public JTextField getFindFacultyTextField() {
        return findFacultyTextField;
    }    

    public AddNewFacultyFrame getAddNewFacultyFrame() {
        return this.addNewFacultyFrame;
    }

    public void createAddNewFacultyFrame() {
        this.addNewFacultyFrame = new AddNewFacultyFrame();
        addNewFacultyFrame.getAddFacultyBtn().addActionListener(this);
    }

    public void configAddNewFacultyFrame() {
        this.addNewFacultyFrame.config();
    }

    public void deleteFaculty() {
        for (int i = 0; i < this.getFacultyTable().getRowCount(); i++) {
            Boolean selected = (Boolean) this.getFacultyTable().getModel().getValueAt(i, 0);
            if (selected == null) {
                selected = false;
            }
            String name = this.getFacultyTable().getModel().getValueAt(i, 1).toString();
            if (selected) {
                if (!this.getFacultyModel().delete(name)) {
                    new AlertFrame(addNewFacultyFrame, "ไม่สามารถลบคณะ " + name + " ได้เนื่องจากมีสาขาอยู่ โปรดลบสาขาก่อน", "ไม่สามารถดำเนินการได้");
                }
            }
        }
        this.initTable();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(addNewFacultyFrame.getAddFacultyBtn())) {
            // Clicked on add new faculty btn

            if (!facultyModel.insert(addNewFacultyFrame.getFacultyNameTextField().getText())) {
                JOptionPane.showMessageDialog(addNewFacultyFrame, "Error, Duplicated name", "Error!", JOptionPane.ERROR_MESSAGE);
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
        pageHeader = new javax.swing.JLabel();
        headerSeparator = new javax.swing.JSeparator();
        centerPanel = new javax.swing.JPanel();
        actionWrapper = new javax.swing.JPanel();
        buttonsWrapper = new javax.swing.JPanel();
        deleteFaculty = new javax.swing.JButton();
        addFaculty = new javax.swing.JButton();
        findFacultyTextField = new javax.swing.JTextField();
        tableScrollPane = new javax.swing.JScrollPane();
        facultyTable = new components.Table();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new java.awt.Dimension(1000, 720));
        setLayout(new java.awt.BorderLayout(0, 5));

        northPanel.setBackground(new java.awt.Color(255, 255, 255));
        northPanel.setLayout(new javax.swing.BoxLayout(northPanel, javax.swing.BoxLayout.PAGE_AXIS));

        pageHeader.setFont(new java.awt.Font("Prompt", 1, 28)); // NOI18N
        pageHeader.setForeground(new java.awt.Color(93, 93, 93));
        pageHeader.setText("จัดการคณะ/สาขา");
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

        deleteFaculty.setBackground(new java.awt.Color(249, 249, 249));
        deleteFaculty.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        deleteFaculty.setForeground(new java.awt.Color(230, 63, 63));
        deleteFaculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        deleteFaculty.setText("ลบคณะที่เลือก");
        deleteFaculty.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 63, 63), 2, true));
        deleteFaculty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteFaculty.setMargin(new java.awt.Insets(2, 5, 3, 5));
        deleteFaculty.setPreferredSize(new java.awt.Dimension(140, 40));
        deleteFaculty.setRequestFocusEnabled(false);
        deleteFaculty.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        deleteFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFacultyActionPerformed(evt);
            }
        });
        buttonsWrapper.add(deleteFaculty, java.awt.BorderLayout.LINE_START);

        addFaculty.setBackground(new java.awt.Color(255, 137, 47));
        addFaculty.setFont(new java.awt.Font("Prompt Medium", 0, 14)); // NOI18N
        addFaculty.setForeground(new java.awt.Color(255, 255, 255));
        addFaculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addFaculty.setText("เพิ่มคณะ");
        addFaculty.setBorder(null);
        addFaculty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addFaculty.setMargin(new java.awt.Insets(2, 5, 3, 5));
        addFaculty.setPreferredSize(new java.awt.Dimension(100, 40));
        addFaculty.setRequestFocusEnabled(false);
        addFaculty.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bin.png"))); // NOI18N
        addFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFacultyActionPerformed(evt);
            }
        });
        buttonsWrapper.add(addFaculty, java.awt.BorderLayout.EAST);

        actionWrapper.add(buttonsWrapper, java.awt.BorderLayout.EAST);

        findFacultyTextField.setColumns(20);
        findFacultyTextField.setFont(new java.awt.Font("Prompt", 1, 14)); // NOI18N
        findFacultyTextField.setForeground(new java.awt.Color(93, 93, 93));
        findFacultyTextField.setToolTipText("");
        findFacultyTextField.setActionCommand("<Not Set>");
        findFacultyTextField.setAutoscrolls(false);
        findFacultyTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ค้นหาคณะ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Prompt", 0, 12), new java.awt.Color(149, 149, 149))); // NOI18N
        findFacultyTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        findFacultyTextField.setMargin(new java.awt.Insets(2, 24, 2, 24));
        findFacultyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findFacultyTextFieldActionPerformed(evt);
            }
        });
        actionWrapper.add(findFacultyTextField, java.awt.BorderLayout.LINE_START);

        tableScrollPane.setBorder(null);

        facultyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "การเลือก", "ชื่อคณะ", "จำนวนสาขา", "ดูข้อมูล"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableScrollPane.setViewportView(facultyTable);
        if (facultyTable.getColumnModel().getColumnCount() > 0) {
            facultyTable.getColumnModel().getColumn(0).setMinWidth(80);
            facultyTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            facultyTable.getColumnModel().getColumn(0).setMaxWidth(80);
            facultyTable.getColumnModel().getColumn(3).setMinWidth(100);
            facultyTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            facultyTable.getColumnModel().getColumn(3).setMaxWidth(100);
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

    private void findFacultyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findFacultyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findFacultyTextFieldActionPerformed

    private void deleteFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFacultyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteFacultyActionPerformed

    private void addFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFacultyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addFacultyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionWrapper;
    private javax.swing.JButton addFaculty;
    private javax.swing.JPanel buttonsWrapper;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JButton deleteFaculty;
    private components.Table facultyTable;
    private javax.swing.JTextField findFacultyTextField;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JPanel northPanel;
    private javax.swing.JLabel pageHeader;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
