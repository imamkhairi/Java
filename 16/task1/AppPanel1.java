import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppPanel1 extends JPanel implements MouseListener{
    private Dimension windowSize = new Dimension(500,500);
    
    public AppPanel1() {
        this.setPreferredSize(this.windowSize);
        this.setBackground(Color.BLACK);
        this.addMouseListener(this);
    }


    @Override
    public void mousePressed(MouseEvent e) { 
        Graphics g = this.getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        int r = 10;
        g2.setColor(new Color((int)Math.round(Math.random()*255),(int)Math.round(Math.random()*255),(int)Math.round(Math.random()*255)));
        int type = (int)Math.round(Math.random()*2);
        switch (type) {
            case 0:
                g2.fillOval(e.getX()-r, e.getY()-r, 2*r,2*r);
                break;
            case 1:
                g2.fillRect(e.getX()-r, e.getY()-r, 2*r, 2*r);
                break;
            case 2:
                g2.fillRoundRect(e.getX()-r, e.getY()-r, 2*r, 2*r, 9, 9);
                break;
            default:
                System.out.println("Type input error");
                break;
        }
    }  
    
    @Override
    public void mouseReleased(MouseEvent e) { }
    
    @Override
    public void mouseClicked(MouseEvent e) { }
    
    @Override
    public void mouseEntered(MouseEvent e) { }
    
    @Override
    public void mouseExited(MouseEvent e) { }
}