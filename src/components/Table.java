package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    public void setViewDatBtnColumn(int newVuewDataBtnColumn) {
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column == newVuewDataBtnColumn) { // <- buton location
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
            }

        });
    }

    public void setRows(Object[][] body, String[] header) {
        this.setModel(new javax.swing.table.DefaultTableModel(
                body,
                header
        ) {
            Class[] types = new Class[]{
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.setRowCount(0);
    }

    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(134, 134, 134));
        getTableHeader().setReorderingAllowed(false);
        setRowHeight(40);
        setFont(new Font("prompt", 0, 14));

        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader tHeader = new TableHeader("" + value);
//                if (column == 4) {}
                tHeader.setHorizontalAlignment(JLabel.CENTER);

                return tHeader;
            }

        });
        this.setViewDatBtnColumn(3);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if (col == 0) {
            return true;
        }
        return false;
    }
}
