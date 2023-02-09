import java.awt.image.*;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import java.awt.*;

public class StageData {
    private BufferedImage backgroundImage;
    private Table[] tables;
    private Chair[] chair;
    private GridSystem gridSystem;
    private LinkedList<Point> chairPoints;

    public StageData(GridSystem gridSystem) {
        this.loadBackground();
        this.gridSystem = gridSystem;
        this.tables = new Table[9];
        this.initiateTables();

        this.chairPoints = new LinkedList<>();
        this.setChairPoints();

        this.chair = new Chair[this.chairPoints.size()];
        this.initiateChairs();
    }   

    private void initiateTables() {
        int index = 0;
        int[] x = {3, 14, 25};
        int[] y = {4, 8, 12};
        for( int i : x ) {
            for (int j : y ) {
                this.tables[index] = new Table(i, j, 2, 2, this.gridSystem);
                index ++;
            }
        }
    }

    private void setChairPoints() {
        for (int i = 0; i < this.tables.length; i++) {
            for(Point p : this.tables[i].getChairPosition()) {
                this.chairPoints.add(p);
            }
        }
    }

    private void initiateChairs() {
        for(int i = 0; i < this.chair.length; i++) {
            this.chair[i] = new Chair(this.chairPoints.get(i).x, this.chairPoints.get(i).y, 1, 1, this.gridSystem);
        }
    }

    private void loadBackground() {
        try {
            this.backgroundImage = ImageIO.read(getClass().getResourceAsStream("res/backgroundtest.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBackgroundImage() {
        return this.backgroundImage;
    }

    public Table[] getTables() {
        return this.tables;
    }

    public Chair[] getChairs() {
        return this.chair;
    }

    public LinkedList<Point> getChairPoints() {
        return this.chairPoints;
    }
}