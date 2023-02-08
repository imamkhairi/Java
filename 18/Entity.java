import java.awt.*;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Entity {
    private Point currentPoint;
    private String name;
    private String action;
    private String direction;
    private int index;
    private String fileName;
    private int gridSize;

    private BufferedImage sprite;

    public Entity(Point start, int gridSize) {
        this.name = "adam";
        this.action = "walk";
        this.direction = "front";
        this.index = 0;
        this.gridSize = gridSize;

        this.setFileName();
        this.currentPoint = new Point(start.x * this.gridSize, start.y * this.gridSize);

        // this.sprite = new BufferedImage[6];
        // this.loadBuffer();
        this.loadSprite();
    }

    public void loadSprite() {
        try {
            this.sprite = ImageIO.read(getClass().getResourceAsStream(this.fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite() {
        return this.sprite;
    }

    public void setFileName() {
        this.fileName = "res\\" +this.name + "_" + this.action + "_" + this.direction + "_" + this.index + ".png";
    }

    public void increaseIndex() {
        if(this.index < 5) {
            this.index++;
        } else {
            this.index = 0;
        }
    }

    public String getFileName() {
        return this.fileName;
    }

    public Point getCurrentPoint() {
        return this.currentPoint;
    }

    public void setCurrentPoint(Point target) {
        this.currentPoint = new Point(target.x*this.gridSize, target.y*this.gridSize);
    }

    public void setDirection(String newDirection) {
        this.direction = newDirection;
    }

    public void setAction(String action) {
        this.action = action;
    }

    
}
