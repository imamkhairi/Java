import java.awt.*;

public class NPC extends Entity {
    // private PathFinder pathFinder;

    public Point startPoint;
    public Point currentPoint;
    public Point endPoint;
    
    public NPC(Point endPoint) {
        super();
        // angap dari pintu masuk dulu
        this.startPoint = new Point(16, 13);
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
}