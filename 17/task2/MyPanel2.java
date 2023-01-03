import javax.swing.*;
import java.awt.*;

public class MyPanel2 extends JPanel {
    private Dimension panelSize = new Dimension(1080, 720);
    private Image[] chara;

    public MyPanel2() {
        this.setPreferredSize(this.panelSize);
        this.setBackground(Color.BLACK);
        this.chara = new Image[5];
    }

    public void setChara(Image[] chara) {
        for(int i = 0; i < chara.length; i ++) {
            this.chara[i] = chara[i];
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        for(int i = 0; i < this.chara.length; i ++) {
            g2.drawImage(this.chara[i], 0+120*i, 0, this);
        }
    }
} 