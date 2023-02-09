public class Chair extends Furniture {
    private boolean occupied;

    public Chair(int x, int y, int height, int width, GridSystem gridSystem) {
        super(x, y, height, width, gridSystem);
        this.occupied = false;
        this.loadSprite("res/chair0.png");
    }
}