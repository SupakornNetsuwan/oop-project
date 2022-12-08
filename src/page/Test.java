package page;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author windows
 */
import java.awt.*;
import javax.swing.*;
public class Test extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint ga = new GradientPaint(0, 0 ,Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("000046"));
        g2.setPaint(ga);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
    }
    public static void main(String[] args){
        Test t = new Test();
        JFrame fr = new JFrame();
        fr.add(t);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300,300);
        
        fr.setVisible(true);
    }   
}
