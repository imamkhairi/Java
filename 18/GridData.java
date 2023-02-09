import java.awt.*;

public class GridData {
    private boolean traversable;
    private Point coordinate; 

    public GridData(boolean t, Point p) {
        this.traversable = t;
        this.coordinate = p;
    }

    public void status() {
        System.out.println("T : " + this.traversable);
        System.out.println(this.coordinate);
    }

    public void setTraversable(boolean t) {
        this.traversable = t;
    }

    public boolean getTraversable() {
        return this.traversable;
    }

    public Point getCoordinate() {
        return this.coordinate;
    }
}
