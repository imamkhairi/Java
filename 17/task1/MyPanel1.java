import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class MyPanel1 extends JPanel {
    private Image chara;
    private BufferedImage bi;

    private Dimension panelSize = new Dimension(720, 480);

    public MyPanel1() {
        this.setPreferredSize(this.panelSize);
        this.bi = new BufferedImage(this.panelSize.width, this.panelSize.height, BufferedImage.TYPE_INT_ARGB);
        this.setBackground(Color.BLACK);
    }

    public void setChara(Image chara) {
        this.chara = chara;
    }

    public void draw() {
        Graphics g = this.bi.getGraphics();
        Graphics2D g2 = (Graphics2D)g;

        if(this.chara == null) {
            System.out.println("null");
        }

        g2.drawImage(this.chara, 150, 150, null);
        g2.setColor(Color.CYAN);
        g2.drawLine(0, 0, 100, 100);
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D)g;
        this.draw();
        super.paintComponent(g2);
        // g2.drawImage(this.chara, 150, 150, this);
        g2.drawImage(this.bi, 0, 0, this);
    }
}