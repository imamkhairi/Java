import java.awt.*;
import java.util.LinkedList;

public class NPC extends Entity {
    private PathFinder pathFinder;
    private Point startPoint;
    private Point endPoint;
    private Point bufferPoint;

    private LinkedList<Point> path;

    private int phase;

    
    public NPC(Point startPoint, Point endPoint, int gridSize, GridSystem gridSystem) {
        super(startPoint, gridSize);
        this.startPoint = new Point(this.getCurrentPoint().x, this.getCurrentPoint().y);
        this.endPoint = new Point(endPoint.x*gridSize, endPoint.y*gridSize);
        this.bufferPoint = new Point (this.getCurrentPoint().x/64, this.getCurrentPoint().y/64);
        this.pathFinder = new PathFinder(gridSystem);
        this.setPath(this.pathFinder.startPathFinding(this.startPoint, this.getCurrentPoint(), this.endPoint, gridSize));
        this.phase = 0;
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

    public int getPhase() {
        return this.phase;
    }

    private void changeDirection(int x, int y) {
        if(x < 0) {
            this.setDirection("left");
        } else if(x > 0) {
            this.setDirection("right");
        }

        if(y > 0 && x == 0) {
            this.setDirection("front");
        } else if(y < 0 && x == 0) {
            this.setDirection("back");
        }
    }

    private int normalizeSpeed(int[] direction) {
        int speed;

        if(direction[0] != 0 && direction[1] != 0) {
            speed = 8;
        } else {
            speed = 16;
        }
        return speed;
    }

    private void changeAction() {
        if(this.path.size() != 0) {
            this.setAction("walk");
        } else {
            if(this.phase == 1) {
                this.setAction("sit");
                int[] x1 = {2,13,24};
                int[] x2 = {5,16,27};
                for (int i : x1) {
                    if(this.endPoint.x/64 == i) {
                        this.setDirection("right");
                    }
                }
                for (int i : x2) {
                    if(this.endPoint.x/64 == i) {
                        this.setDirection("left");
                    }
                }
            }
        }
    }

    public void move() {
        if(this.path.size() != 0) {
            int[] direction = new int[2];
            direction = this.getDirectionValue();
            this.changeDirection(direction[0], direction[1]);
            if (this.getCurrentPoint().x == this.path.get(0).x*64 && this.getCurrentPoint().y == this.path.get(0).y*64){
                this.setCurrentPoint(this.path.get(0));
                this.setBufferPoint(this.path.get(0));
                this.path.remove(0);
            } else {
                int speed = this.normalizeSpeed(direction);
                this.getCurrentPoint().translate(speed*direction[0], speed*direction[1]);
            }
        } else {
            if(this.phase == 0) this.phase++;
        }

        this.changeAction();
        this.increaseIndex();
        this.setFileName();
        this.loadSprite();
    }

    public void startNewPath() {
        this.phase = 0;
        
    }
}