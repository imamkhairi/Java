import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

public class AppPanel3 extends JPanel implements MouseListener, MouseMotionListener{
    private Dimension panelSize = new Dimension(500, 500);
    private BufferedImage bi;
    private int oldX, oldY;


    public AppPanel3() {
        //gambar di bufferedImage dulu baru repaint ke window utama
        this.bi = new BufferedImage((int)(this.panelSize.getWidth()), (int)(this.panelSize.getHeight()), BufferedImage.TYPE_INT_ARGB);
        this.setPreferredSize(this.panelSize);
        this.setBackground(new Color(0,0,0));
        
        this.addMouseListener(this);
    }

    //untuk sementara bikin ngedrag tapi gambar ketika release gt 
    private void savePoint(MouseEvent e) {
        this.oldX = e.getX();
        this.oldY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) { 
        // int x = e.getX();
        // int y = e.getY();
        this.savePoint(e);
        // System.out.println("x = " + this.oldX + ", y = " + this.oldY);
    }  
    @Override
    public void mouseReleased(MouseEvent e) { } // マウスボタンが離されたとき
    
    @Override
    public void mouseClicked(MouseEvent e) { }  // マウスボタンがクリックされた(押して離された)とき
    
    @Override
    public void mouseEntered(MouseEvent e) { }  // マウスカーソルが部品内に入ったとき
    
    @Override
    public void mouseExited(MouseEvent e) { }   // マウスカーソルが部品外に出たとき

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = this.bi.getGraphics();
        Graphics2D g2 = (Graphics2D)g;



    
    }
}

/*

chuukan
tema 1 - 15
yang dari smt 1 juga perlu (terutama getter setter inheritance)

*/