public class PathFinding {
    public GridSystem grid;

    public PathFinding() {
        grid = new GridSystem();

        // this.updateTraversableData(2, 4, false);

        // this.getSurroundEdge(1, 1);
        this.grid.getGridData()[1][2].setEdge(1, false);
        this.getSurroundEdge(1, 1);
        this.getTraversableNeighbor(1,1);
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
        boolean[] result = new boolean[4];
        result[0] = this.grid.getGridData()[x][y].getW();
        result[1] = this.grid.getGridData()[x][y].getN();
        result[2] = this.grid.getGridData()[x+1][y].getW();
        result[3] = this.grid.getGridData()[x][y+1].getN();
        return result;
    }

    public static void main(String[] args) {
        new PathFinding();
    }
}