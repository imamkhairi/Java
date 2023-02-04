public class box {
    private int x;
    private int y;
    private int height;
    private int width;
    // private int moveSpeed;

    public box(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = 50;
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