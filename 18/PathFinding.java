import java.awt.*;

public class PathFinding {
    private GridSystem grid;
    private Point start;
    private Point end; 

    private int length;

    private int[][] gridGCost;
    private int[][] gridHCost;

    // Ini gk butuh edge 

    public PathFinding() {
        grid = new GridSystem();

        // ini bisa digunakan untuk besar array cost
        this.length = this.grid.getGridData().length;

        // start dan end akan diambil dari input klik
        this.start = new Point(1,1);
        this.end = new Point(3,3);

        this.updateGCost(new Point(3,0), this.start);
        this.updateHCost(new Point(3,0), this.end);
    }   

    private void updateHCost(Point current, Point end) {
        int[] result = this.getDiaHor(this.getDifference(current, end));
        System.out.println("F cost : " + (result[0] * 14 + result[1] * 10));
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
    
    // ini harusnya di grid system, di sini sekarang buat debug aja
    private void updateTraversableData(int x, int y, boolean t) {
        this.grid.getGridData()[x][y].setTraversable(t);
    }

    // ini harusnya return array of point atau kita pake arraylist lagi
    private void getTraversableNeighbor(int x, int y) {
        int[] v = {-1,0,1};
        for (int i : v) {
            for (int j : v){
                if (i == 0 && j == 0 ) continue;
                int a = x + i;
                int b = y + j;
                if (a < 0 || b < 0 || a > this.length - 1 || b > this.length - 1) continue;
                else if (!this.grid.getGridData()[a][b].getTraversable()) continue;
                System.out.println(a + "," + b);
            }
        }
    }
    
    public static void main(String[] args) {
        new PathFinding();
    }
}