import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class GridSystem {
    List<GridData> data;

    GridData[][] gridData;

    public GridSystem() {
        this.gridData = new GridData[10][10];

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                this.gridData[i][j] = new GridData(true, new Point(i,j));
            }
        }

        this.updateTraversableData(2, 4, false);
        // this.gridData[2][4].status();
        // this.gridData[3][4].status();
        // this.gridData[2][5].status();

        this.getTraversableNeighbor(1,1);
    }

    private void updateTraversableData(int x, int y, boolean t) {
        this.gridData[x][y].setTraversable(t);
        this.gridData[x+1][y].setEdge(1, t);
        this.gridData[x][y+1].setEdge(0, t);
    }

    private void getTraversableNeighbor(int x, int y) {
        int[] v = {-1,0,1};
        for(int i : v) {
            for(int j : v){
                if(i == 0 && j == 0 ) continue;
                int a = x + i;
                int b = y + j;
                System.out.println(a + "," + b);
            }
        }
    }

    private void joinW(int x,y) {

    }

    public static void main(String[] args) {
        new GridSystem();
    }
}