import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppPanel2 extends JPanel implements MouseMotionListener, MouseListener{
    private Dimension windowSize = new Dimension(500,500);
    private int oldX, oldY;
    
    public AppPanel2() {
        this.setPreferredSize(this.windowSize);
        this.setBackground(Color.BLACK);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    private void savePoint(MouseEvent e) {
        this.oldX = e.getX();
        this.oldY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) { 
        this.savePoint(e);
    }  
    
    @Override
    public void mouseReleased(MouseEvent e) { }
    
    @Override
    public void mouseClicked(MouseEvent e) { }
    
    @Override
    public void mouseEntered(MouseEvent e) { }
    
    @Override
    public void mouseExited(MouseEvent e) {
        Graphics g = this.getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, (int)(this.windowSize.getWidth()), (int)(this.windowSize.getHeight()));
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = this.getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        
        g2.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        g2.drawLine(this.oldX, this.oldY, e.getX(), e.getY());
        this.savePoint(e);
    }

}