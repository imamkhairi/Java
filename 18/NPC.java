import java.awt.*;
import java.util.LinkedList;

public class NPC extends Entity {
    // private PathFinder pathFinder;

    private Point startPoint;
    private Point endPoint;
    private Point bufferPoint;

    private LinkedList<Point> path;
    
    public NPC(Point startPoint, Point endPoint, int gridSize) {
        super(startPoint, gridSize);
        // angap dari pintu masuk dulu
        // this.startPoint = new Point(16, 13);
        this.startPoint = new Point(this.getCurrentPoint().x, this.getCurrentPoint().y);
        this.endPoint = new Point(endPoint.x*gridSize, endPoint.y*gridSize);
        this.bufferPoint = this.getCurrentPoint();
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

        int x1 = this.bufferPoint.x/64;
        int y1 = this.bufferPoint.y/64;
        int x2 = this.path.get(0).x;
        int y2 = this.path.get(0).y;

        System.out.println(x1);
        System.out.println(y1);
        System.out.println(x2);
        System.out.println(y2);
        System.out.println();

        direction[0] = x2-x1;
        direction[1] = y2-y1;

        return direction;
    }

    public void move() {
        if(this.path.size() != 0) {
            int[] direction = new int[2];

            if(this.path.size() > 0) {
                direction = this.getDirectionValue();
                // System.out.println(direction[0] +", " + direction[1]);
            }


            if(this.getCurrentPoint().x != this.path.get(0).x*64 && this.getCurrentPoint().y != this.path.get(0).y*64){
                this.getCurrentPoint().translate(16*direction[0], 16*direction[1]);
                System.out.println("sini");
                // System.out.println(this.getCurrentPoint() + "," + this.path.get(0).x*64 +","+ this.path.get(0).y*64);
            } else {
                System.out.println("masuk");
                this.setCurrentPoint(this.path.get(0));
                // this.bufferPoint = this.getCurrentPoint();
                this.path.remove(0);
            }

        } else {
            System.out.println("arrived");
        }
    }
}