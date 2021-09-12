package JStyles;

import java.awt.*;
import javax.swing.*;

public class SButton extends JButton  {
    
    public SButton(String text) {
        super();
        super.setText(text);
        this.setFocusable(false);
        this.setBackground(new Color(0xc133ff));
        this.setForeground(new Color(0xFFFFFF));
        this.setFont(new Font("MV Boli", Font.PLAIN, 15));
    }
    public SButton() {
        super();
        this.setFocusable(false);
        this.setBackground(new Color(0xc133ff));
        this.setForeground(new Color(0xFFFFFF));
        this.setFont(new Font("MV Boli", Font.PLAIN, 15));
    }
}
