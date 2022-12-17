package frame;

import java.awt.*;
import javax.swing.*;

public class SuccessFrame extends JOptionPane {

    public SuccessFrame(JFrame parent, String text, String title) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("prompt", 0, 14));
        this.showMessageDialog(parent, label, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
