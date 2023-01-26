import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class PathFinding {
    private GridSystem grid;
    
    private Point start;
    private Point current;
    private Point end; 

    private int length;

    private int[][] gridGCost;
    private int[][] gridHCost;
    private int[][] gridFCost;

    private List<Point> open; 
    private List<Point> close; 
    private List<Point> nbr;

    public PathFinding() {
        grid = new GridSystem();

        // ini bisa digunakan untuk besar array cost
        this.length = this.grid.getGridData().length;

        this.gridGCost = new int[this.length][this.length];
        this.gridHCost = new int[this.length][this.length];
        this.gridFCost = new int[this.length][this.length];

        this.open = new ArrayList<Point>();
        this.close = new ArrayList<Point>();
        this.nbr = new ArrayList<Point>();

        // start dan end akan diambil dari input klik
        this.start = new Point(1,1);
        // this.current = new Point(this.start.x, this.start.y);
        this.end = new Point(1,3);

        this.startPathFinding();
        // this.updateGCost(new Point(3,0), this.start);
        // this.updateHCost(new Point(3,0), this.end);
    }   

    private void startPathFinding() {
        System.out.println("started");

        this.open.add(this.start);

        // disini harusnya akan ada while(!tidak sama dengan end)

        // System.out.println(this.open);
        this.current = this.getLowestF(); // disini harusnya juga ngecek g dan h
        // System.out.println(this.close);
        // System.out.println(this.current);
        // System.out.println(this.open);
        
        this.getTraversableNeighbor(this.current.x, this.current.y);
        // System.out.println(this.nbr);

        // sepertinya ini lebih bagus saat memilih travesable nbr
        this.updateGCost();
        this.updateHCost();
        this.updateFCost();

        // System.out.println(this.nbr);
        this.cekCost(this.gridGCost);
        System.out.println();
        this.cekCost(this.gridHCost);
        System.out.println();
        this.cekCost(this.gridFCost);
    }

    //DEBUG
    private void cekCost(int[][] target) {
        for(int i = 0; i < 10; i ++) {
            for (int j = 0; j < 10; j ++) {
                System.out.print(target[i][j] + " ");
            }
            System.out.println();
        }
    }

    private Point getLowestF() {
        Point result;
        int low = 10;
        if(this.open.size() == 1) {
            result = this.open.get(0);
            this.open.remove(0);
        } else {
            for (int i = 0; i < this.open.size(); i++) {
                Point p = this.open.get(i);
                if(this.gridFCost[p.x][p.y])
            }
            result = new Point(-1,-1);
            // disini cek paling rendah harusnya
        }
        this.close.add(new Point(result.x, result.y));
        return result;
    }

    private void updateHCost(Point current, Point end) {
        int[] result = this.getDiaHor(this.getDifference(current, end));
        System.out.println("F cost : " + (result[0] * 14 + result[1] * 10));
    }

    private void updateGCost(Point current, Point start) {
        int[] result = this.getDiaHor(this.getDifference(current, start));
        System.out.println("G cost : " + (result[0] * 14 + result[1] * 10));
    }

    private void updateGCost() {
        for (Point p : this.nbr) {
            int[] result = this.getDiaHor(this.getDifference(p, this.start));
            this.gridGCost[p.x][p.y] = result[0] * 14 + result[1] * 10;
        }
    }

    private void updateHCost() {
        for (Point p : this.nbr) {
            int[] result = this.getDiaHor(this.getDifference(p, this.end));
            this.gridHCost[p.x][p.y] = result[0] * 14 + result[1] * 10;
        }
    }

    private void updateFCost() {
        for (int i = 0; i < this.length; i ++) {
            for (int j = 0; j < this.length; j ++) {
                this.gridFCost[i][j] = this.gridGCost[i][j] + this.gridHCost[i][j];
            }
        }
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
                else if (!this.grid.getGridData()[a][b].getTraversable() || this.checkInClose(a,b)) continue;
                this.nbr.add(new Point(a, b));
            }
        }
    }

    private boolean checkInClose(int x, int y) {
        boolean result = false;
        for (Point p : this.close) {
            if(x == p.x && y == p.y) {
                result = true;
                break;
            } else {
                result = false;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        new PathFinding();
    }
}