import java.awt.*;
import java.util.LinkedList;

public class NPC extends Entity {
    // private PathFinder pathFinder;

    public Point startPoint;
    public Point currentPoint;
    public Point endPoint;

    private LinkedList<Point> path;
    
    public NPC(Toolkit tk, Point endPoint) {
        super(tk);
        // angap dari pintu masuk dulu
        // this.startPoint = new Point(16, 13);
        this.startPoint = new Point(7,5);
        this.currentPoint = new Point(this.startPoint.x, this.startPoint.y);
        this.endPoint = endPoint;
    }

    public Point getStarPoint() {
        return this.startPoint;
    }

    public Point getEndPoint() {
        return this.endPoint;
    }

    public Point getCurrentPoint() {
        return this.currentPoint;
    }

    public LinkedList<Point> getPath() {
        return this.path;
    }

    public void setPath(LinkedList<Point> path) {
        this.path = path;
    }

    public void move() {
        if(this.path.size() != 0) {
            this.currentPoint = this.path.get(0);
            this.path.remove(0);
        } else {
            System.out.println("arrived");
        }
    }
}