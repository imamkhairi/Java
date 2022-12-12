import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

public class AppPanel3 extends JPanel implements MouseListener, MouseMotionListener{
    private Dimension panelSize = new Dimension(500, 500);
    private BufferedImage bi;
    private int oldX, oldY;
    private ripple water;


    // private int[][] test = new int[11][11]; //debug
 

    public AppPanel3() {
        //gambar di bufferedImage dulu baru repaint ke window utama
        this.bi = new BufferedImage((int)(this.panelSize.getWidth()), (int)(this.panelSize.getHeight()), BufferedImage.TYPE_INT_ARGB);
        this.setPreferredSize(this.panelSize);
        this.setBackground(new Color(0,0,0));
        
        this.addMouseMotionListener(this);
        this.addMouseListener(this);

        this.water = new ripple(this);

        // for(int i = 0; i < 11; i ++) {
        //     for(int j = 0; j < 11; j ++) {
        //         this.test[i][j] = 255;
        //     }
        // }
    }

    //untuk sementara bikin ngedrag tapi gambar ketika release gt 
    private void savePoint(MouseEvent e) {
        this.oldX = e.getX();
        this.oldY = e.getY();
    }

    public void testDraw(int x, int y, Graphics2D g, double[][] test) {
        int length = test.length;
        int mid = length/2;
        for(int i = 0; i < length; i ++) {
            for(int j = 0; j < length; j ++) {
                g.setColor(new Color(Math.abs((float)test[i][j]) , Math.abs((float)test[i][j]), Math.abs((float)test[i][j])));
                int delX = i-mid;
                int delY = j-mid;
                g.drawLine(x-delX, y-delY, x-delX, y-delY);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { 
        this.savePoint(e);
        int x = e.getX();
        int y = e.getY();
        Graphics g = this.bi.getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        // this.water.start(x, y, g2);
    }  
    @Override
    public void mouseReleased(MouseEvent e) {
        // this.repaint();
        Graphics g = this.bi.getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        this.water.resetAll();
        this.savePoint(e);
        this.testDraw(oldX, oldY, g2, this.water.getCurrent());
        this.repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) { 
        int x = e.getX();
        int y = e.getY();
        Graphics g = this.bi.getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        // this.testDraw(x, y, g2, this.water.getCurrent());
        this.water.start(x, y, g2);
    } 
    
    @Override
    public void mouseEntered(MouseEvent e) { }
    
    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Graphics g = this.bi.getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        this.water.start(x, y, g2);

        // g2.fillOval(x - 50/2, y - 50/2, 50, 50);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        g2.drawImage(this.bi, null, 0, 0);
    }
}
