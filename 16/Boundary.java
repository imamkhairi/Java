import java.awt.*;

public class Boundary {
    private Point start;
    private Point end;

    public Boundary(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public void show(Graphics2D g2) {
        g2.setColor(new Color(255, 255, 255));
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(getX1(), getY1(), getX2(), getY2());
    }

    public int getX1() {
        return (int)this.start.getX();
    }
    public int getY1() {
        return (int)this.start.getY();
    }
    public int getX2() {
        return (int)this.end.getX();
    }
    public int getY2() {
        return (int)this.end.getY();
    }
}