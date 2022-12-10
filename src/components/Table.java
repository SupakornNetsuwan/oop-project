package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Table extends JTable {
    
    public void setTable(Object[][] obj, String[] string) {
        this.setModel(new javax.swing.table.DefaultTableModel(
                obj,
                string
        ) {
            Class[] types = new Class[]{
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
    }
    
    public void addTable() {
        // your job
    }
    
    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(134, 134, 134));
        getTableHeader().setReorderingAllowed(false);
        setRowHeight(40);
        
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader tHeader = new TableHeader("" + value);
//                if (column == 4) {}
                tHeader.setHorizontalAlignment(JLabel.CENTER);
                
                return tHeader;
            }
            
        });
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column == 3) { // <- buton location
                    ViewDataBtn viewBtn = new ViewDataBtn("ดูข้อมูล");
                    return viewBtn;
                } else {
                    Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    this.setHorizontalAlignment(CENTER);
                    setBorder(noFocusBorder);
                    if (isSelected) {
                        com.setBackground(new Color(255, 234, 218));
                        com.setForeground(new Color(255, 137, 47));
                    } else {
                        com.setBackground(Color.WHITE);
                        com.setForeground(new Color(102, 102, 102));
                    }
                    return com;
                }

//                return new JLabel("" + value);
            }
            
        });
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 0) {
            return true;
        }
        return false;
    }
}
