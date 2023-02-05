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

    private BufferedImage[] sprite;

    public Entity() {
        this.name = "adam";
        this.action = "idle";
        this.direction = "front";
        this.index = 0;

        this.setFileName();
        this.currentPoint = new Point(7,5);

        this.sprite = new BufferedImage[6];
        this.loadBuffer();
    }

    public void loadBuffer() {
        for (int i = 0; i < this.sprite.length; i++) {
            this.index = i;
            this.setFileName();
            try {
                this.sprite[i] = ImageIO.read(getClass().getResourceAsStream(this.fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public BufferedImage getBufferedImage() {
        return this.sprite[this.index];
    }


    public void setFileName() {
        // "res\adam_idle_front_0.png"
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
}
