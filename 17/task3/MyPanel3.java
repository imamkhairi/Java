import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel3 extends JPanel implements MouseListener{
    private Dimension panelSize = new Dimension(720, 720);
    private Image[] chara;
    private int gridCount = 10;
    private int gridSize = (int)(this.panelSize.getHeight())/this.gridCount;
    private int box_X;
    private int box_Y;
    
    public MyPanel3() {
        this.chara = new Image[10];
        // System.out.println(this.panelSize.x);

        this.setPreferredSize(this.panelSize);

        this.addMouseListener(this);
    }


    @Override
    public void paintComponent(Graphics g) { // karena ini set backgroud jadi ilang
        this.setBackground(Color.WHITE);
        // super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        this.drawBox(g2, this.box_X, this.box_Y); //untuk box ini masih memungkinkan untuk jadi class sendiri, berarti mouselistener ikut pindah
        g2.setColor(Color.BLACK);
        this.drawVerticalLine(g2);
        this.drawHorizontalLine(g2);
    }

    private void drawVerticalLine(Graphics2D g2) {
        for(int i = 1; i < this.gridCount; i++) {
            g2.drawLine(i*this.gridSize, 0, i*this.gridSize, this.gridCount*this.gridSize);
        }
    }

    private void drawHorizontalLine(Graphics2D g2) {
        for(int i = 1; i < this.gridCount; i++) {
            g2.drawLine(0, i*this.gridSize, this.gridCount*this.gridSize, i*this.gridSize);
        }
    }

    private int[] getGridCoordinate(int x, int y) {
        int[] result = new int[2];
        result[0] = x/this.gridSize;
        result[1] = y/this.gridSize;
        return result;
    }

    private void drawBox(Graphics2D g2, int x, int y) {
        int[] c = new int[2];
        c = this.getGridCoordinate(x,y);
        g2.setColor(Color.RED);
        // g2.fillRect(c[0]*this.gridSize, c[1]*this.gridSize, this.gridSize, this.gridSize);
        g2.fillRect(c[0]*this.gridSize, c[1]*this.gridSize, this.gridSize, this.gridSize);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // System.out.println(e.getX() + "  " + e.getY());
        // this.getGridCoordinate(e.getX(), e.getY());
        // int[] ans = new int[2];
        // ans = this.getGridCoordinate(e.getX(), e.getY());
        // System.out.println(ans[0] + " " + ans[1]);
        this.box_X = e.getX();
        this.box_Y = e.getY();
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}