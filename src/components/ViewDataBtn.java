package components;

import java.awt.*;
import javax.swing.*;

public class ViewDataBtn extends JButton {

    public ViewDataBtn(String text) {
        setText(text);
        setFont(new Font("Prompt", Font.BOLD, 14));
        setBackground(new Color(255, 137, 47));
        setForeground(Color.white);
    }
}
