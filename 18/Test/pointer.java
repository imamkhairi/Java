public class pointer {
    private int x;
    private int y;
    private int height;
    private int width;
    private int leftBoundary;
    private int rightBoundary;
    private int moveSpeed;

    public pointer(int leftBoundary, int rightBoundary) {
        this.x = 250;
        this.y = 250;
        this.height = 40;
        this.width = 30;

        this.moveSpeed = 3;

        this.leftBoundary = leftBoundary;
        this.rightBoundary = rightBoundary;
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
        if(this.x > this.rightBoundary || this.x < this.leftBoundary) {
            this.moveSpeed = -this.moveSpeed;
        } 
        this.x += this.moveSpeed;
    }

}