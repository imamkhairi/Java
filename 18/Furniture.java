public class Furniture {
    private int x;
    private int y;
    private int height;
    private int width;
    private int gridSize;

    public Furniture(int x, int y, int height, int width) {
        this.gridSize = gridSize;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }


}