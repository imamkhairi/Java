import java.awt.*;
import java.util.LinkedList;

public class Entity {
    private PathFinder pathFinder;
    private GridSystem gridSystem;

    public Point startPoint;
    public Point currentPoint;
    public Point endPoint;

    private LinkedList<Point> openList;
    private LinkedList<Point> closeList;
    private LinkedList<Point> neighborList;

    public Entity() {
        this.startPoint = new Point(1,1);
        this.currentPoint = new Point(this.startPoint.x, this.startPoint.y);
        int x = (int)(Math.random()*10);
        int y = (int)(Math.random()*10);
        System.out.println(x + ", " + y);
        this.endPoint = new Point(x,y);
        // this.endPoint = new Point(8,9);

        this.gridSystem = new GridSystem(); // ini harusnya dipassing gt dr constructor

        this.pathFinder = new PathFinder(this.startPoint, this.currentPoint, this.endPoint);
        this.pathFinder.startPathFinding();
    }
    public static void main(String[] args) {
        new Entity();
    }
    
}
