import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Grid extends JPanel implements MouseListener{
    private Dimension dimension;
    private int gridCount = 10;
    private int gridSize;
    private int box_X = -1;
    private int box_Y = -1;
    
    public Grid(Dimension dimension) {
        this.dimension = dimension;
        this.setBounds(0, 0, this.dimension.width, this.dimension.height);
        this.gridSize = this.dimension.height/this.gridCount;
        this.setPreferredSize(this.dimension);

        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.CYAN);
        
        Graphics2D g2 = (Graphics2D)g;
        // tanya kenapa ini dieksekusi dua kali di awal
        this.drawBox(g2, this.box_X, this.box_Y);

        g2.setColor(Color.BLACK);
        this.drawHorizontalLine(g2);
        this.drawVerticalLine(g2);
    }

    public void drawVerticalLine(Graphics2D g2) {
        for(int i = 1; i < this.gridCount; i++) {
            g2.drawLine(i*this.gridSize, 0, i*this.gridSize, this.gridCount*this.gridSize);
        }
    }

    public void drawHorizontalLine(Graphics2D g2) {
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
        if(x > 0 && y > 0) {
            c = this.getGridCoordinate(x,y);
            g2.setColor(Color.RED);
            g2.fillRect(c[0]*this.gridSize, c[1]*this.gridSize, this.gridSize, this.gridSize);
        } else {
            System.out.println("outside");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // this.box_X = e.getX();
        // this.box_Y = e.getY();
        // this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.box_X = e.getX();
        this.box_Y = e.getY();
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
