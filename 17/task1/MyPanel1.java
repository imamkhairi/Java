import javax.swing.*;
import java.awt.*;

public class MyPanel1 extends JPanel {
    private Image chara;

    private Dimension panelSize = new Dimension(720, 480);

    public MyPanel1() {
        this.setPreferredSize(this.panelSize);
        this.setBackground(Color.BLACK);
    }

    public void setChara(Image chara) {
        this.chara = chara;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        g2.drawImage(this.chara, 150, 150, this);
    }
}