import java.awt.*;

public class GridSystem {
    private Dimension windowSize;
    private GridData[][] gridData;
    private final int gridSize = 64;
    private int columnCount;
    private int rowCount;

    public GridSystem(Dimension windowSize) {
        this.windowSize = windowSize;

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
}