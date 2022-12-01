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

    
    //tambahin method resize

    @Override
    public void mousePressed(MouseEvent e) { 
        this.savePoint(e);
    }  
    
    @Override
    public void mouseReleased(MouseEvent e) { } // マウスボタンが離されたとき
    
    @Override
    public void mouseClicked(MouseEvent e) { }  // マウスボタンがクリックされた(押して離された)とき
    
    @Override
    public void mouseEntered(MouseEvent e) { }  // マウスカーソルが部品内に入ったとき
    
    @Override
    public void mouseExited(MouseEvent e) { }
    
    @Override
    public void mouseMoved(MouseEvent e) {

    }

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