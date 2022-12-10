package page;

import frame.AddNewFacultyFrame;
import components.*;
import javax.swing.*;

public class FacultyManagePanel extends javax.swing.JPanel {

    private AddNewFacultyFrame addNewFacultyFrame;

    public FacultyManagePanel() {
        initComponents();
    }

    public Table getTable() {
        return this.facultyTable;
    }

    public JButton getAddFacultyBtn() {
        return this.addFaculty;
    }

    public JButton getDeleteFacultyBtn() {
        return this.deleteFaculty;
    }

    public AddNewFacultyFrame getAddNewFacultyFrame() {
        return this.addNewFacultyFrame;
    }

    public void createAddNewFacultyFrame() {
        this.addNewFacultyFrame = new AddNewFacultyFrame();
    }

    public void configAddNewFacultyFrame() {
        this.addNewFacultyFrame.config();
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
        findFaculty = new javax.swing.JTextField();
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

        findFaculty.setColumns(20);
        findFaculty.setFont(new java.awt.Font("Prompt", 1, 14)); // NOI18N
        findFaculty.setForeground(new java.awt.Color(93, 93, 93));
        findFaculty.setToolTipText("");
        findFaculty.setActionCommand("<Not Set>");
        findFaculty.setAutoscrolls(false);
        findFaculty.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ค้นหาคณะ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Prompt", 0, 14), new java.awt.Color(149, 149, 149))); // NOI18N
        findFaculty.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        findFaculty.setMargin(new java.awt.Insets(2, 24, 2, 24));
        findFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findFacultyActionPerformed(evt);
            }
        });
        actionWrapper.add(findFaculty, java.awt.BorderLayout.LINE_START);

        tableScrollPane.setBorder(null);

        facultyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "tao", "eartrgh", null},
                { new Boolean(false), "earth", null, null},
                {null, "oat", null, "fasfasf"},
                {null, "toa", null, "asdas"},
                {null, "benz", null, null},
                {null, "neng", null, null},
                {null, "earth-2", null, null},
                {null, "earthg", null, null}
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
                    .addComponent(actionWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                    .addComponent(tableScrollPane))
                .addContainerGap())
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actionWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void findFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findFacultyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findFacultyActionPerformed

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
    private javax.swing.JTextField findFaculty;
    private javax.swing.JSeparator headerSeparator;
    private javax.swing.JPanel northPanel;
    private javax.swing.JLabel pageHeader;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
