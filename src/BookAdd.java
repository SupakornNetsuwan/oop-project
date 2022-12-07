import javax.swing.*;
import java.awt.*;
public class BookAdd {
    private JFrame fr;
    private JPanel pn1, pn2;
    private JLabel lb1, lb2, lb3;
    private JTextField tf1, tf2, tf3;
    private JButton insert;
    private JComboBox cb;
    
    public BookAdd(){
        fr = new JFrame("Book Add");
        fr.setLayout(new BorderLayout());
        pn1 = new JPanel();
        pn1.setLayout(new GridLayout(3,2));
        pn2 = new JPanel();
        lb1 = new JLabel("Name");
        lb2 = new JLabel("Price");
        lb3 = new JLabel("Type");
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField("0",4);
        insert = new JButton("Insert");
        cb = new JComboBox();
        cb.addItem("A");
        cb.addItem("B");
        cb.addItem("C");
        cb.addItem("D");
        
        pn1.add(lb1);
        pn1.add(tf1);
        pn1.add(lb2);
        pn1.add(tf2);
        pn1.add(lb3);
        pn1.add(cb);
        
        pn2.add(insert);
        
               
        fr.add(pn1, BorderLayout.NORTH);
        fr.add(pn2, BorderLayout.SOUTH);
        
//        fr.setSize(250, 220);
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(false);
        
        
    }

    public JFrame getFr() {
        return fr;
    }

    public void setFr(JFrame fr) {
        this.fr = fr;
    }

    public JPanel getPn1() {
        return pn1;
    }

    public void setPn1(JPanel pn1) {
        this.pn1 = pn1;
    }

    public JPanel getPn2() {
        return pn2;
    }

    public void setPn2(JPanel pn2) {
        this.pn2 = pn2;
    }

    public JLabel getLb1() {
        return lb1;
    }

    public void setLb1(JLabel lb1) {
        this.lb1 = lb1;
    }

    public JLabel getLb2() {
        return lb2;
    }

    public void setLb2(JLabel lb2) {
        this.lb2 = lb2;
    }

    public JLabel getLb3() {
        return lb3;
    }

    public void setLb3(JLabel lb3) {
        this.lb3 = lb3;
    }

    public JTextField getTf1() {
        return tf1;
    }

    public void setTf1(JTextField tf1) {
        this.tf1 = tf1;
    }

    public JTextField getTf2() {
        return tf2;
    }

    public void setTf2(JTextField tf2) {
        this.tf2 = tf2;
    }

    public JTextField getTf3() {
        return tf3;
    }

    public void setTf3(JTextField tf3) {
        this.tf3 = tf3;
    }

    public JButton getInsert() {
        return insert;
    }

    public void setInsert(JButton insert) {
        this.insert = insert;
    }

    public JComboBox getCb() {
        return cb;
    }

    public void setCb(JComboBox cb) {
        this.cb = cb;
    }

    
    
}
