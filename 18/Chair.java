public class Chair extends Furniture {
    private boolean occupied;

    public Chair(int x, int y, int height, int width, GridSystem gridSystem) {
        super(x, y, height, width, gridSystem);
        this.occupied = false;
        this.loadSprite("res\\chair0.png");
        // this.updateGridTraversable();
    }

    private void updateGridTraversable() {
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight(); j++){
                this.getGridSystem().setTraversable(this.getX() + i, this.getY() + j, false);
            }
        }
    }
}