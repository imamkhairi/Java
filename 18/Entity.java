import java.awt.*;

public class Entity {
    private Point currentPoint;
    private String name;
    private String action;
    private String direction;
    private int index;

    private Image sprite;

    private String fileName;

    
    // public Point endPoint;

    public Entity(Toolkit tk) {
        this.name = "adam";
        this.action = "idle";
        this.direction = "front";
        this.index = 0;

        this.setFileName();
        // this.setSprite(tk);
        this.currentPoint = new Point(7,5);
    }

    public void setFileName() {
        // "res\adam_idle_front_0.png"
        // this.fileName = "res\\" +this.name + "_" + this.action + "_" + this.direction + "_" + this.index + "_" + ".png";
        this.fileName = this.name + "_" + this.action + "_" + this.direction + "_" + this.index + ".png";
    }

    public void setSprite(Toolkit tk) {
        this.sprite = tk.getImage(this.fileName);
    }

    public String getFileName() {
        return this.fileName;
    }

    public Image getSprite() {
        // System.out.println(this.sprite);
        return this.sprite;
    }
    
}
