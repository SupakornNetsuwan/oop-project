package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Table extends JTable {

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
                if (column == 3) {
                    ViewDataBtn viewBtn = new ViewDataBtn("ดูข้อมูล");
                    return viewBtn;
                }
                else {
                    Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Obtain row and column indexes the user clicked.
                int row = rowAtPoint(e.getPoint());
                int col = columnAtPoint(e.getPoint());
                
                if (col == 3) {
                    // Check if user clicks the cell that the JButton is located,
                    // then show the data of that row in JOptionPane.
                    System.out.println("Clicked a button. [" + row + ", " + col + "]");
                    String str = "isSelected: " + getModel().getValueAt(row,0) + "\n" +
                            "name: " + getModel().getValueAt(row,1) + "\n" +
                            "amount: " + getModel().getValueAt(row,2);
                    JOptionPane.showMessageDialog(null, str);
                }
                else {
                    // When user ticks JCheckBox, print all row names that has
                    // JCheckBox ticked on console.
                    String toShow = "selected:";
                    for (int i=0; i<getRowCount(); i++) {
                        Boolean selected = (Boolean)getModel().getValueAt(i, 0);
                        if (selected == null) {
                            selected = false;
                        }
                        String name = getModel().getValueAt(i, 1).toString();
                        if (selected) {
                            toShow += " " + name;
                        }
                    }
                    System.out.println(toShow);
                }
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
