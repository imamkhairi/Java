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
        // int x = e.getX();
        // int y = e.getY();
        // System.out.println("x = " +x +", y = " + y);
        Graphics g = this.getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        int r = 10;
        g2.setColor(Color.WHITE);
        g2.drawOval(e.getX()-r, e.getY()-r, 2*r,2*r);
        //bisa dimain2in warnanya pake fillOval
        //atau random2 juga tipe shape nya (mungkin bisa)
    }  
    
    @Override
    public void mouseReleased(MouseEvent e) { } // マウスボタンが離されたとき
    
    @Override
    public void mouseClicked(MouseEvent e) { }  // マウスボタンがクリックされた(押して離された)とき
    
    @Override
    public void mouseEntered(MouseEvent e) { }  // マウスカーソルが部品内に入ったとき
    
    @Override
    public void mouseExited(MouseEvent e) { }   // マウスカーソルが部品外に出たとき
}