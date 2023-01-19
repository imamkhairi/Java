import java.awt.*;

public class GridData {
    private boolean edge_N;
    private boolean edge_W;
    private boolean traversable;
    private Point coordinate; // point di sini masih gk jelas gunanya apa

    public GridData(boolean t, Point p) {
        // this.edge_W = w;
        this.traversable = t;
        this.updateEdge();
        this.coordinate = p;
    }

    public void status() {
        System.out.println("N : " + this.edge_N);
        System.out.println("W : " + this.edge_W);
        System.out.println("T : " + this.traversable);
        System.out.println(this.coordinate);
    }

    private void updateEdge() {
        if(this.traversable) {
            this.edge_N = true;
            this.edge_W = true;
        } else {
            this.edge_N = false;
            this.edge_W = false;
        }
    }

    public void setTraversable(boolean t) {
        this.traversable = t;
        this.updateEdge();
    }

    public void setEdge(int type, boolean value) {
        if(type == 0) {
            this.edge_N = value;
        } else {
            this.edge_W = value;
        }
    }

    public Point getCoordinate() {
        return this.coordinate;
    }
}