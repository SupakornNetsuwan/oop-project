import javax.swing.*;
import java.awt.*;
public class BookView {
    private JFrame fr;
    private JPanel pn1, pn2, pn3, pn4;
    private JLabel lb1, lb2, lb3;
    private JTextField tf1, tf2, tf3;
    private JButton left, right, add, update, del;
    private JComboBox cb;
    
    public BookView(){
        fr = new JFrame("Book");
        fr.setLayout(new BorderLayout());
        pn4 = new JPanel();
        pn4.setLayout(new BorderLayout());
        pn1 = new JPanel();
        pn1.setLayout(new GridLayout(3,2));
        pn2 = new JPanel();
        pn3 = new JPanel();
        lb1 = new JLabel("Name");
        lb2 = new JLabel("Price");
        lb3 = new JLabel("Type");
        tf1 = new JTextField(10);
        tf2 = new JTextField(10);
        tf3 = new JTextField("0",4);
        left = new JButton("<<<");
        right = new JButton(">>>");
        add = new JButton("Add");
        update = new JButton("Update");
        del = new JButton("Delete");
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
        
        pn2.add(left);
        pn2.add(tf3);
        pn2.add(right);
        
        pn3.add(add);
        pn3.add(update);
        pn3.add(del);
               
        fr.add(pn4, BorderLayout.CENTER);
        pn4.add(pn1, BorderLayout.CENTER);
        pn4.add(pn2, BorderLayout.SOUTH);
        fr.add(pn3, BorderLayout.SOUTH);
        
        fr.setLocationRelativeTo(null);
        fr.setSize(250, 220);
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        
        
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

    public JPanel getPn3() {
        return pn3;
    }

    public void setPn3(JPanel pn3) {
        this.pn3 = pn3;
    }

    public JPanel getPn4() {
        return pn4;
    }

    public void setPn4(JPanel pn4) {
        this.pn4 = pn4;
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

    public JButton getLeft() {
        return left;
    }

    public void setLeft(JButton left) {
        this.left = left;
    }

    public JButton getRight() {
        return right;
    }

    public void setRight(JButton right) {
        this.right = right;
    }

    public JButton getAdd() {
        return add;
    }

    public void setAdd(JButton add) {
        this.add = add;
    }

    public JButton getUpdate() {
        return update;
    }

    public void setUpdate(JButton update) {
        this.update = update;
    }

    public JButton getDel() {
        return del;
    }

    public void setDel(JButton del) {
        this.del = del;
    }

    public JComboBox getCb() {
        return cb;
    }

    public void setCb(JComboBox cb) {
        this.cb = cb;
    }
    public static void main(String[] args) {
        new BookView();
    }
}
