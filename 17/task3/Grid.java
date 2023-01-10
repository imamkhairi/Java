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
    private List<Point> path;

    private int currentCost = 10; //Soalnya grid yang bersebelahan itu paling kecil 10 lah ya
    private Point current;
    private Point start = new Point(0,0); // SEMENTARA GINI DULU
    private Point end;

    private int[][] g;
    private int[][] h;
    private int[][] f;
    private int[][] openValue;
    private int[][] closeValue;

    private Point[][] parent;
    
    public Grid(Dimension dimension) {
        this.dimension = dimension;
        this.setBounds(0, 0, this.dimension.width, this.dimension.height);
        this.gridSize = this.dimension.height/this.gridCount;
        this.setPreferredSize(this.dimension);

        this.open = new ArrayList<Point>();
        this.close = new ArrayList<Point>();
        this.neighbour = new ArrayList<Point>();
        this.path = new ArrayList<Point>();

        this.current = this.start; // di awal current merupakan start

        // Kalau ada waktu silahkan tanya ke sensei cara initiate di method
        this.g = new int[this.gridCount][this.gridCount];
        this.h = new int[this.gridCount][this.gridCount];
        this.f = new int[this.gridCount][this.gridCount];
        this.openValue = new int[this.gridCount][this.gridCount];
        this.closeValue = new int[this.gridCount][this.gridCount];
        this.resetAll();

        this.parent = new Point[this.gridCount][this.gridCount];
        this.initiateParent(this.parent);

        this.addMouseListener(this);
    }

    private void initiateParent(Point[][] p) {
        for(int i = 0; i < this.gridCount; i++){
            for(int j = 0; j < this.gridCount; j++) {
                p[i][j] = null;
            }
        } 
    }

    private void startPathFinding() {
        this.open.add(this.start);
        // this.path.add(this.start);

        // LOOP gedenya di sini

        while(!this.isSame(this.end, this.current)) {
            this.current = this.updateCurrent(this.getLowestF(this.open));
            this.open.remove(this.current);
            this.addClose(this.current);
            
            this.getNeighbour();
    
            this.checkNeighbour();
    
            this.neighbour.clear();
        }

        this.updatePath();
        // System.out.println(this.path);
        this.resetAll();

        int x = this.end.x;
        int y = this.end.y;
        this.start = new Point(x,y);

        // System.out.println("Start : " + this.start);
        // System.out.println("End : " +this.end);
    }

    public void clearPath() {
        this.path.clear();
    }
    
    private void updatePath() {
        int x = this.end.x;
        int y = this.end.y;
        this.path.add(new Point(x,y));

        while(x != this.start.x || y != this.start.y) {
            int prevX = this.parent[x][y].x;
            int prevY = this.parent[x][y].y;

            this.path.add(new Point(prevX, prevY));

            x = prevX;
            y = prevY;
        }

    }

    private void addClose(Point p) {
        int x = p.x;
        int y = p.y;
        if(this.closeValue[x][y] < 0) {
            this.closeValue[x][y] = 1;
            this.close.add(p);
        }
    }

    // Kemungkinan ini gk guna
    private void addToOpen(List<Point> target) {
        for(Point p : target) {
            this.open.add(p);
        }
    }

    private Point updateCurrent(List<Point> p) {
        Point r = null;
        if(p.size() > 1) {
            r = this.getLowestH(p);
        } else {
            r = p.get(0);
        }
        return r;
    }

    private Point getLowestH(List<Point> target) {
        int lowest = this.f[target.get(0).x][target.get(0).y];
        Point r = null;

        for(Point p : target) {
            int x = p.x;
            int y = p.y;
            if(this.f[x][y] <= lowest) {
                lowest = this.f[x][y];
                r = p;
            }
        }
        return r;
    }

    private List<Point> getLowestF(List<Point> target) {
        int lowest = this.f[target.get(0).x][target.get(0).y];
        List<Point> r = new ArrayList<Point>();
        
        for(Point p : target) {
            int x = p.x;
            int y = p.y;
            if(this.f[x][y] < lowest) {
                lowest = this.f[x][y];
                r.clear();
                r.add(new Point(x,y));
            } else if (this.f[x][y] == lowest) {
                r.add(new Point(x,y));
            }
        }

        return r;
    }

    private Boolean isSame(Point p, Point q) {
        if(p.x == q.x && p.y == q.y) {
            return true;
        } else {
            return false;
        }
    }

    private void checkNeighbour() {
        List<Point> a = new ArrayList<Point>();

        for(Point p : this.neighbour) {
            if(this.open.size() == 0) {
                this.updateParent(p);
                this.checkOpen(p, a);
            } else {
                for(Point q : this.open) {
                    if(!this.isSame(p, q) || this.getCost(p, this.current) < this.currentCost) {
                        this.updateParent(p);
                    }
                    if(!this.isSame(p, q)){
                        this.checkOpen(p, a);
                    } else if (this.getCost(p, this.current) < this.currentCost) {
                        System.out.println("Cost");
                        System.out.println(this.currentCost);
                        this.currentCost = this.getCost(q, this.current);
                    }
                }
            }
        }
        
        this.addToOpen(a);
    }

    private void checkOpen(Point p, List<Point> a) {
        int x = p.x;
        int y = p.y;
        if(this.openValue[x][y] < 0) {
            this.openValue[x][y] = 1;
            a.add(p);
        }
    }

    private void updateParent(Point p) {
        int x = p.x;
        int y = p.y;
        this.setF(p);
        this.parent[x][y] = this.current;
    }

    private void setF(Point p) {
        int x = p.x;
        int y = p.y;
        this.g[x][y] = this.getCost(this.start, p);
        this.h[x][y] = this.getCost(this.end, p);
        this.f[x][y] = this.g[x][y] + this.h[x][y];
    }

    private void getNeighbour(){
        int[] v = {-1,0,1};
        for(int i : v){
            for(int j : v) {
                int x = this.current.x + i;
                int y = this.current.y + j;
                if(x >= 0 && y >= 0 && x < this.gridCount && y < this.gridCount) {
                    if(i == 0 && j == 0) {
                    } else {
                        if(this.closeValue[x][y] < 0) {
                            this.neighbour.add(new Point(x,y));
                        }
                    }
                }
            }
        }
    }

    private void resetAll() {
        this.reset(this.g);
        this.reset(this.h);
        this.reset(this.f);
        this.reset(this.openValue);
        this.reset(this.closeValue);
        this.open.clear();
        this.close.clear();
    }

    private void reset(int[][] target) {
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

    public Point getStart() {
        return this.start;
    }

    public int getGridSize() {
        return this.gridSize;
    }

    public List<Point> getPath() {
        return this.path;
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
        this.end = new Point(c[0], c[1]);
        // System.out.println(end);
        // System.out.println(this.current);

        // System.out.println(this.getCost(new Point(0,0), this.current));

        // this.open.add(new Point(c[0],c[1]));
        // this.repaint();

        this.startPathFinding();
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