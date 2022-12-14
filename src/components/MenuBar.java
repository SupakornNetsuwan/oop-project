package components;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {

    private JMenu menu = new JMenu("จัดการ");
    private JMenuItem exportItem = new JMenuItem("นำออกข้อมูล");

    public MenuBar() {
        Font font = new Font("prompt", 0, 14);
        menu.setFont(font);
        menu.setOpaque(true);
        exportItem.setFont(font);
        menu.add(exportItem);
        this.add(menu);
    }
}
