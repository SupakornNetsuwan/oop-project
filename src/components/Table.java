package components;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Table extends JTable {

    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(134, 134, 134));
        getTableHeader().setReorderingAllowed(false);
        setRowHeight(40);
        this.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
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
                if (column != 4) {
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

                return new JLabel("" + value);
            }

        });
    }
}
