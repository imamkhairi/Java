import java.util.List;
import java.util.LinkedList;
import java.awt.*;

public class GridSystem {
    private List<GridData> data;
    private Dimension windowSize;
    private GridData[][] gridData;
    private int gridSize;
    private int columnCount;
    private int rowCount;

    public GridSystem(Dimension windowSize, int gridSize) {
        this.windowSize = windowSize;
        this.gridSize = gridSize;

        this.rowCount = (int)this.windowSize.getHeight()/this.gridSize;    
        this.columnCount = (int)this.windowSize.getWidth()/this.gridSize; 

        // System.out.println(this.rowCount + ", " +this.columnCount);
        
        this.gridData = new GridData[this.columnCount][this.rowCount];

        for(int i = 0; i < this.columnCount; i++) {
            for(int j = 0; j < this.rowCount; j++) {
                this.gridData[i][j] = new GridData(true, new Point(i,j));
            }
        }
    }

    public GridData[][] getGridData() {
        return this.gridData;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public int getGridSize() {
        return this.gridSize;
    }

    public void setTraversable(int x, int y, boolean traversable) {
        this.gridData[x][y].setTraversable(traversable);
    }
    // ini harusnya di grid system, di sini sekarang buat debug aja
    // private void updateTraversableData(int x, int y, boolean t) {
    //     this.grid.getGridData()[x][y].setTraversable(t);
    // }
}