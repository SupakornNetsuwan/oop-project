package components;

import frame.SuccessFrame;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import model.*;

public class MenuBar extends JMenuBar {

    private JMenu menu = new JMenu("จัดการ");
    private JMenu exportItems = new JMenu("นำออกข้อมูล");
    private JMenuItem exportStudent = new JMenuItem("นำออกข้อมูลนักศึกษา");

    public MenuBar() {
        Font font = new Font("prompt", 0, 14);
        menu.setOpaque(true);
        menu.setFont(font);
        exportItems.setFont(font);
        exportStudent.setFont(font);

        exportItems.add(exportStudent);
        menu.add(exportItems);
        this.add(menu);
    }

    public JMenuItem getExportStudent() {
        return this.exportStudent;
    }

    public void exportStudents() {
        try ( PrintWriter printWriter = new PrintWriter("./student.csv")) {
            StringBuilder stringBuilder = new StudentModel().exportStudents();
            printWriter.write(stringBuilder.toString());
            printWriter.close();
            new SuccessFrame(new JFrame(), "นำข้อมูลนักศึกษาออกสำเร็จ", "นำข้อมูลออกสำเร็จ");
        } catch (FileNotFoundException err) {
            System.out.println("ERR : " + err.getMessage());
        }
    }
}
