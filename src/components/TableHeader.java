package components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JLabel {

    public TableHeader(String text) {
        super(text);
        setOpaque(true);
        setBackground(new Color(255, 250, 245));
        setFont(new Font("prompt", 1, 14));
        setForeground(new Color(255, 137, 47));
        setBorder(new EmptyBorder(10, 5,10, 5));
    }

}
