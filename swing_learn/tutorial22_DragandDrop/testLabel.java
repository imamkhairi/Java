package swing_learn.tutorial22_DragandDrop;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class testLabel extends JPanel{
    testLabel() {
        this.setBounds(250,250, 100, 100);
        this.setLocation(250, 250);
        this.setBackground(Color.PINK);
        this.setOpaque(true);
        ClickListener clickListener = new ClickListener();
        this.addMouseListener(clickListener);
    }
    
    public class ClickListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e) {
            System.out.println("click");
        }
    }
    
}
