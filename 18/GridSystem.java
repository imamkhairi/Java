import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class GridSystem {
    List<GridData> data;

    GridData[][] gridData;
    // Point[][] parent;

    public GridSystem() {
        this.gridData = new GridData[10][10];

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                this.gridData[i][j] = new GridData(true, new Point(i,j));
            }
        }
    }

    public GridData[][] getGridData() {
        return this.gridData;
    }

    public static void main(String[] args) {
        new GridSystem();
    }

    //Bikin method yang falsekan edge grid yang dipinggir
}