import javax.swing.*;
import java.awt.*;

public class MyPanel3 extends JPanel {
    private Dimension panelSize = new Dimension(1080, 720);
    private Image[] chara;
    
    public MyPanel3() {
        this.chara = new Image[10];

        this.setPreferredSize(this.panelSize);
        this.setBackground(Color.BLACK);
    }
}