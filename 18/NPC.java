import java.awt.*;
import java.util.LinkedList;

public class NPC extends Entity {
    // private PathFinder pathFinder;

    private Point startPoint;
    private Point endPoint;
    private Point bufferPoint;

    private LinkedList<Point> path;

    private boolean first  = true;
    
    public NPC(Point startPoint, Point endPoint, int gridSize) {
        super(startPoint, gridSize);
        // angap dari pintu masuk dulu
        // this.startPoint = new Point(16, 13);
        this.startPoint = new Point(this.getCurrentPoint().x, this.getCurrentPoint().y);
        this.endPoint = new Point(endPoint.x*gridSize, endPoint.y*gridSize);
        this.bufferPoint = new Point (this.getCurrentPoint().x/64, this.getCurrentPoint().y/64);
        System.out.println(this.bufferPoint);
    }

    public Point getStarPoint() {
        return this.startPoint;
    }

    public Point getEndPoint() {
        return this.endPoint;
    }

    public LinkedList<Point> getPath() {
        return this.path;
    }

    public void setPath(LinkedList<Point> path) {
        this.path = path;
    }

    private int[] getDirectionValue() {
        int[] direction = new int[2];

        // int x1 = this.path.get(0).x;
        // int y1 = this.path.get(0).y;
        // int x2 = this.path.get(1).x;
        // int y2 = this.path.get(1).y;

        int x1 = this.bufferPoint.x;
        int y1 = this.bufferPoint.y;
        int x2 = this.path.get(0).x;
        int y2 = this.path.get(0).y;

        direction[0] = x2-x1;
        direction[1] = y2-y1;

        return direction;
    }

    private void setBufferPoint(Point target) {
        this.bufferPoint = target;
    }

    public void move() {
        if(this.path.size() != 0) {
            int[] direction = new int[2];

            direction = this.getDirectionValue();
            System.out.println(direction[0] +" , " + direction[1]);

            if (this.getCurrentPoint().x == this.path.get(0).x*64 && this.getCurrentPoint().y == this.path.get(0).y*64){
                System.out.println("masuk ----------------");
                this.setCurrentPoint(this.path.get(0));
                this.setBufferPoint(this.path.get(0));
                this.path.remove(0);
            } else {
                this.getCurrentPoint().translate(16*direction[0], 16*direction[1]);
            }

        } else {
            System.out.println("arrived");
        }
    }
}