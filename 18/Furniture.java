import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Furniture {
    private int x;
    private int y;
    private int height;
    private int width;
    private BufferedImage sprite;
    private GridSystem gridSystem;

    public Furniture(int x, int y, int height, int width, GridSystem gridSystem) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.gridSystem = gridSystem;
    }

    public void loadSprite(String fileName) {
        try {
            this.sprite = ImageIO.read(getClass().getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite() {
        return this.sprite;
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

    public GridSystem getGridSystem() {
        return this.gridSystem;
    }
}