import java.awt.*;
import java.awt.event.*;

public class Ray {
    private Point start;
    private Point dir;

    public Ray(Point start, Point dir) {
        this.start = start;
        this.dir = dir;
    }

    public void showBase(Graphics2D g2, MouseEvent e) {
        int r = 12;
        g2.setColor(Color.WHITE);
        g2.fillOval(e.getX()-r, e.getY()-r, r*2, r*2);
    }

    public void showRay(Graphics2D g2) {
        g2.setColor(new Color(255,255,255,50));
        g2.setStroke(new BasicStroke(1));
        g2.drawLine(this.getX1(), this.getY1(), this.getX1() + this.getX2(), this.getY1() + this.getY2());
    }

    public Point castLight(Boundary b) {
        int x1 = b.getX1();
        int y1 = b.getY1();
        int x2 = b.getX2();
        int y2 = b.getY2();

        int x3 = this.getX1();
        int y3 = this.getY1();
        int x4 = this.getX1() + this.getX2();
        int y4 = this.getY1() + this.getY2();

        double den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if(den == 0) {
            return null;
        }

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / den;
        double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / den;

        if(t > 0 && t < 1 && u > 0) {
            Point castingResult = new Point();
            castingResult.x = (int)(x1 + t * (x2-x1));
            castingResult.y = (int)(y1 + t * (y2-y1));
            return castingResult;
        } else {
            return null;
        }

    }

    public int getX1() {
        return (int)this.start.getX();
    }
    public int getY1() {
        return (int)this.start.getY();
    }
    public int getX2() {
        return (int)this.dir.getX();
    }
    public int getY2() {
        return (int)this.dir.getY();
    }

    public void setDir(int x, int y) {
        this.dir.x = x - this.start.x;
        this.dir.y = y - this.start.y;
        double length = this.vectorLenght(this.start.x, this.start.y, x, y);
    }

    private double vectorLenght(int x1, int y1, int x2, int y2) {
        double dx = x1-x2;
        double dy = y1-y2;
        double sqrt = Math.sqrt(dx*dx + dy*dy);
        return sqrt;
    }

    private void normalizeDir(double length) {
        this.dir.x = Math.round((float)(this.dir.x / length)) *10;
        this.dir.y = Math.round((float)(this.dir.y / length)) *10;
    }
}