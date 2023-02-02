import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class testPanel extends JPanel{
    private Dimension panelSize;
    private BufferedImage bi;

    public testPanel() {
        this.panelSize = new Dimension(500,500);

        this.setPreferredSize(this.panelSize);
        this.bi = new BufferedImage(this.panelSize.height, this.panelSize.width, BufferedImage.TYPE_INT_ARGB);
        // this.testDraw();
    }

    public void testDraw() {
        Graphics g = this.bi.getGraphics();
        Graphics2D g2 = (Graphics2D)g; 
        g2.setColor(Color.BLACK);
        // g2.drawLine(0,0,100,50);
        int[] x = {50,100,150};
        int[] y = {100, 50, 100};
        g2.fillPolygon(x,y,3);
        g2.dispose();
        this.repaint();
    }

    public void drawPointer(pointer p) {
        Graphics g = this.bi.getGraphics();
        Graphics2D g2 = (Graphics2D)g; 

        super.paintComponent(g2);
        g2.setColor(Color.BLACK);
        // g2.drawLine(0,0,100,50);
        int[] x = {p.getX()-(p.getWidth()/2),p.getX(),p.getX()+(p.getWidth()/2)};
        int[] y = {p.getY()+p.getHeight(), p.getY(), p.getY()+p.getHeight()};
        g2.fillPolygon(x,y,3);
        g2.dispose();
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        // g2.drawLine(0,0,50,50);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(this.bi, null, 0, 0);
    }
}