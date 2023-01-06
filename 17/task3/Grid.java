import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

public class Grid extends JPanel implements MouseListener{
    private Dimension dimension;
    private int gridCount = 10;
    private int gridSize;
    private int box_X = -1;
    private int box_Y = -1;

    private List<Point> open;
    private List<Point> close;
    private List<Point> neighbour;

    private Point current;

    private int[][] g;
    private int[][] h;
    private int[][] f;
  
    public Grid(Dimension dimension) {
        this.dimension = dimension;
        this.setBounds(0, 0, this.dimension.width, this.dimension.height);
        this.gridSize = this.dimension.height/this.gridCount;
        this.setPreferredSize(this.dimension);

        this.open = new ArrayList<Point>();

        // Kalau ada waktu silahkan tanya ke sensei cara initiate di method
        this.g = new int[this.gridCount][this.gridCount];
        this.h = new int[this.gridCount][this.gridCount];
        this.f = new int[this.gridCount][this.gridCount];
        this.intitateCost(g);
        this.intitateCost(h);
        this.intitateCost(f);

        this.addMouseListener(this);
    }

    private void intitateCost(int[][] target) {
        // target = new int[this.gridCount][this.gridCount];
        for(int i = 0; i < this.gridCount; i ++){
            for(int j = 0; j < this.gridCount; j ++){
                target[i][j] = -1;
            }
        }
    }

    public List<Point> getOpen() {
        return this.open;
    }

    private int getCost(Point a, Point b){
        int dx = a.x - b.x;
        dx = (int)Math.abs(dx);
        int dy = a.y - b.y;
        dy = (int)Math.abs(dy);
        double d = Math.sqrt(dx*dx + dy*dy) * 10;
        return (int)d;
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // this.setBackground(Color.CYAN);
        
        Graphics2D g2 = (Graphics2D)g;
        // tanya kenapa ini dieksekusi dua kali di awal
        // this.drawBox(g2, this.box_X, this.box_Y);

        g2.setColor(Color.LIGHT_GRAY);
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

    // draw box ga digunakan lagi, kita hanya perlu koordinat grid yang diklik
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
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.box_X = e.getX();
        this.box_Y = e.getY();
        int[] c = new int[2];
        c = this.getGridCoordinate(box_X, box_Y);
        // System.out.println(c[0] + " " + c[1]); 
        // YANG ATAS INI HANYA CEK KOORDINAT SAJA

        // Yang ini bisa lah
        this.current = new Point(c[0], c[1]);
        // System.out.println(this.current);

        System.out.println(this.getCost(new Point(0,0), this.current));

        // this.open.add(new Point(c[0],c[1]));
        // this.repaint();

        //DEBUG USE
        System.out.println(this.g[0][0]);
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
