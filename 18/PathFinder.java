import java.awt.*;
import java.util.List;
import java.util.LinkedList;

public class PathFinder {
    private GridSystem grid;
    
    private Point start;
    private Point current;
    private Point end; 

    private int length;

    private int currentCost = 10;

    private int[][] gridGCost;
    private int[][] gridHCost;
    private int[][] gridFCost;

    private Point[][] parent;

    private List<Point> open; 
    private List<Point> close; 
    private List<Point> nbr;
    private List<Point> path;

    public PathFinder(Point startPoint, Point currentPoint, Point endPoint) {
        // grid = new GridSystem(); // ini harusnya dipassing dari constructor

        // ini bisa digunakan untuk besar array cost
        this.length = this.grid.getGridData().length;

        this.gridGCost = new int[this.length][this.length];
        this.gridHCost = new int[this.length][this.length];
        this.gridFCost = new int[this.length][this.length];
        this.parent = new Point[this.length][this.length];

        this.open = new LinkedList<Point>();
        this.close = new LinkedList<Point>();
        this.nbr = new LinkedList<Point>();
        this.path = new LinkedList<Point>();

        // start dan end akan diambil dari input klik / masing2 npc akan beda
        this.start = startPoint;
        this.current = currentPoint;
        this.end = endPoint;
    }   

    public void startPathFinding() {
        this.open.add(this.start);
        while(this.current.x != this.end.x || this.current.y != this.end.y) {
            this.current = this.updateCurrent(this.getLowestF()); 
            this.getTraversableNeighbor(this.current.x, this.current.y);
            // System.out.println(this.nbr);
    
            this.updateGCost();
            this.updateHCost();
            this.updateFCost();
    
            // check
            // System.out.println(this.nbr);
            // System.out.println("G COST");
            // this.cekCost(this.gridGCost);
            // System.out.println("H COST");
            // this.cekCost(this.gridHCost);
            // System.out.println("F COST");
            // this.cekCost(this.gridFCost);
            
            this.checkNeighbor();
            this.nbr.clear();
        }
        
        // System.out.println();
        // for(int i = 0; i < 10; i ++) {
        //     for (int j = 0; j < 10; j ++) {
        //         System.out.print(this.parent[j][i].y + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
    
        this.setPath(); 
        System.out.println(this.path);
        // System.out.println("===============================================================");
        // this.current = this.updateCurrent(this.getLowestF()); 
        // this.getTraversableNeighbor(this.current.x, this.current.y);
        // this.updateGCost();
        // this.updateHCost();
        // this.updateFCost();
        // // System.out.println(this.nbr);
        // // System.out.println(this.nbr);
        // this.cekCost(this.gridGCost);
        // System.out.println();
        // this.cekCost(this.gridHCost);
        // System.out.println();
        // this.cekCost(this.gridFCost);
        
        // System.out.println(this.current);
        // System.out.println(this.parent[this.current.x][this.current.y]);

        // for(int i = 0; i < 10; i ++) {
        //     for (int j = 0; j < 10; j ++) {
        //         System.out.print(this.parent[i][j] + " ");
        //     }
        //     System.out.println();
        // }

    }

    //DEBUG
    private void cekCost(int[][] target) {
        for(int i = 0; i < 10; i ++) {
            for (int j = 0; j < 10; j ++) {
                System.out.print(target[j][i] + " ");
            }
            System.out.println();
        }
    }

    private void setPath() {
        int x = this.end.x;
        int y = this.end.y;
        this.path.add(this.end);

        while(x != this.start.x || y != this.start.y) {
            int prevX = this.parent[x][y].x;
            int prevY = this.parent[x][y].y;

            this.path.add(new Point(prevX, prevY));

            x = prevX;
            y = prevY;
        }
    }

    private void checkNeighbor() {
        for (Point neighbor : this.nbr) {
            int x = neighbor.x;
            int y = neighbor.y;
            // int currentCost = this.currentCost;
            if (!this.checkInOpen(x, y)) { // disini harusnya juga dicek shorter path (cost terendah)
                this.parent[x][y] = new Point(this.current.x, this.current.y);
                this.open.add(neighbor);
            }   
        }
    }

    private void checkParent(int a, int b, int x, int y) {
        if(this.parent[a][b] != null) {
            if(this.getCost(new Point(a,b), this.parent[a][b]) > this.getCost(new Point(a,b), new Point(x,y))){
                this.parent[a][b] = new Point(x, y);
            }
        }
    }

    private Point updateCurrent(LinkedList<Point> lowestF) {
        LinkedList<Point> result = new LinkedList<>();
        if(lowestF.size() > 1) {
            result = this.getLowestH(lowestF);
        } else {
            result.add(lowestF.get(0));
        }

        this.close.add(result.get(0));
        this.open.remove(result.get(0));

        this.currentCost += this.gridHCost[result.get(0).x][result.get(0).y];

        return result.get(0);
    }

    private LinkedList<Point> getLowestH(LinkedList<Point> lowestF) {
        int lowest = this.gridHCost[lowestF.get(0).x][lowestF.get(0).y];
        LinkedList<Point> result = new LinkedList<>();

        for(Point point : lowestF) {
            int x = point.x;
            int y = point.y;
            if(this.gridHCost[x][y] < lowest) {
                lowest = this.gridHCost[x][y];
                result.clear();
                result.add(point);
            } else if (this.gridHCost[x][y] == lowest) {
                result.add(point);
            }
        }

        return result;
    }

    private LinkedList<Point> getLowestF() {
        int lowest = this.gridFCost[this.open.get(0).x][this.open.get(0).y];
        LinkedList<Point> result = new LinkedList<>();

        for(Point point : this.open) {
            int x = point.x;
            int y = point.y;
            if(this.gridFCost[x][y] < lowest) {
                lowest = this.gridFCost[x][y];
                result.clear();
                result.add(point);
            } else if (this.gridFCost[x][y] == lowest) {
                result.add(point);
            }
        }

        return result;
    }

    private int getCost(Point a, Point b) {
        int[] result = this.getDiaHor(this.getDifference(a, b));
        return result[0] * 14 + result[1] *10;
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
    // private void updateTraversableData(int x, int y, boolean t) {
    //     this.grid.getGridData()[x][y].setTraversable(t);
    // }

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
                
                this.checkParent(a, b, x, y);
                // if(this.parent[a][b] != null) {
                //     if(this.getCost(new Point(a,b), this.parent[a][b]) > this.getCost(new Point(a,b), new Point(x,y))){
                //         this.parent[a][b] = new Point(x, y);
                //     }
                // }
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

    private boolean checkInOpen(int x, int y) {
        boolean result = false;
        for (Point p : this.open) {
            if(x == p.x && y == p.y) {
                result = true;
                break;
            } else {
                result = false;
            }
        }
        return result;
    }
}