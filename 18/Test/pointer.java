public class pointer {
    private int x;
    private int y;
    private int height;
    private int width;
    private int xBoundary;
    private int yBoundary;
    private int moveSpeed;

    public pointer(int xBoundary, int yBoundary) {
        this.x = 250;
        this.y = 250;
        this.height = 40;
        this.width = 30;

        this.moveSpeed = 3;

        this.xBoundary = xBoundary;
        this.yBoundary = yBoundary;
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


    public void move() {
        if(this.x + this.width/2 > this.xBoundary || this.x - this.width/2 < 0) {
            this.moveSpeed = -this.moveSpeed;
        } 
        this.x += this.moveSpeed;
    }

    // add keyboard listener trus ambil koordinat dari x y nya
}