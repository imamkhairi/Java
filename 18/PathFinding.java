import java.awt.*;

public class PathFinding {
    private GridSystem grid;
    private Point start;
    private Point end; 

    private int[][] gridGCost;

    // Ini gk butuh edge 

    public PathFinding() {
        grid = new GridSystem();

        // start dan end akan diambil dari input klik
        this.start = new Point(1,1);
        this.end = new Point(0,3);

        // ini oke
        // System.out.println(this.getDiaHor(this.getDifference(this.start, this.end))[0]);
        // System.out.println(this.getDiaHor(this.getDifference(this.start, this.end))[1]);

        // untuk ini sementara udah oke dulu
        // this.grid.getGridData()[1][1].setEdge(0, false);
        // this.getTraversableNeighbor(1,1);

        // COBA
        // this.grid.getGridData()[1][1].setEdge(0, false);
        // this.getTraversableNeighbor(1, 1);

        this.getSurroundEdge(1, 1);
    }   

    private void updateGCost(Point current, Point start) {
        int[] result = this.getDiaHor(this.getDifference(current, start));
        System.out.println("G cost : " + (result[0] * 14 + result[1] * 10));
    }

    private int[] getDifference(Point start, Point end) {
        int[] result = new int[2];
        result[0] = start.x - end.x;
        result[1] = start.y - end.y;

        for (int i = 0; i < result.length; i++) {
            if(result[i] < 0) {
                result[i] *= -1;
            }
        }

        return result;
    }

    private int getLowest(int[] target) {
        if(target.length > 2) {
            System.out.println("Length exceeds limit");
            return -1;
        }

        if(target[0] <= target[1]) {
            return target[0];
        } else {
            return target[1];
        }
    }

    private int[] getDiaHor(int[] dif) {
        int[] buff = dif;
        int[] result = new int[2];

        result[0] = this.getLowest(buff);
        for (int i = 0; i < buff.length; i++) {
            if(buff[i] - result[0] != 0) {
                result[1] = buff[i] - result[0];
            }
        }

        return result;
    }
    
    private void updateTraversableData(int x, int y, boolean t) {
        this.grid.getGridData()[x][y].setTraversable(t);
        this.grid.getGridData()[x+1][y].setEdge(1, t);
        this.grid.getGridData()[x][y+1].setEdge(0, t);
    }

    private void getTraversableNeighbor(int x, int y) {
        int[] v = {-1,0,1};
        boolean[] edge = this.getSurroundEdge(x, y);
        for (int i : v) {
            for (int j : v){
                if(i == 0 && j == 0 ) continue;
                else if (!edge[0] && i == -1) continue;
                else if (!edge[1] && j == -1) continue;
                else if (!edge[2] && i == 1) continue;
                else if (!edge[3] && j == 1) continue;
                int a = x + i;
                int b = y + j;
                System.out.println(a + "," + b);
            }
        }
    }

    private boolean[] getSurroundEdge(int x, int y) {
        boolean[] result = new boolean[12];
        int[] v = {-1, 0, 1};
        int index = 0;
        for (int i : v) {
            for (int j : v) {
                if ((i == -1 && j == -1)) continue;
                int dx = x + i;
                int dy = y + j;
                String e = "";
                if (j == 0 || j == 1) {
                    result[index] = this.grid.getGridData()[dx][dy].getN();
                    index++;
                }
                if (i == 0 || i == 1) {
                    result[index] = this.grid.getGridData()[dx][dy].getW();
                    index++;
                }
                // hasil perpindahan keluar juga skip
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        // result[0] = this.grid.getGridData()[x][y].getW();
        // result[1] = this.grid.getGridData()[x][y].getN();
        // result[2] = this.grid.getGridData()[x+1][y].getW();
        // result[3] = this.grid.getGridData()[x][y+1].getN();
        // result[4] = this.grid.getGridData()[x-1][y].getN();
        // result[5] = this.grid.getGridData()[x][y-1].getW();
        // result[6] = this.grid.getGridData()[x+1][y-1].getW();
        // result[7] = this.grid.getGridData()[x+1][y].getN();
        // result[8] = this.grid.getGridData()[x+1][y+1].getN();
        // result[9] = this.grid.getGridData()[x+1][y+1].getW();
        // result[10] = this.grid.getGridData()[x][y+1].getW();
        // result[11] = this.grid.getGridData()[x-1][y+1].getN();
        return result;
    }

    public static void main(String[] args) {
        new PathFinding();
    }
}