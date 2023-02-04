import java.awt.*;
import java.util.LinkedList;

public class Table extends Furniture {
    public Table(int x, int y, int height, int width, GridSystem gridSystem) {
        super(x, y, height, width, gridSystem);
    }

    public LinkedList<Point> getChairPosition() {
        LinkedList<Point> chairPoints = new LinkedList<Point>();

        for (int i = 0; i < this.getHeight(); i ++) {
            chairPoints.add(new Point(this.getX()-1, this.getY()+i));
            chairPoints.add(new Point(this.getX()+this.getWidth(), this.getY()+i));
        }

        return chairPoints;
    }
}