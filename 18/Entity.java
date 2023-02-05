import java.awt.*;

public class Entity {
    private Point currentPoint;
    private String name;
    private String action;
    private String direction;
    private int index;
    private Image sprite;
    private String fileName;
    private Image[] sprites;

    public Entity(Toolkit tk) {
        this.name = "adam";
        this.action = "idle";
        this.direction = "front";
        this.index = 0;

        this.sprites = new Image[6];

        this.setFileName();
        // this.setSprite(tk);
        this.currentPoint = new Point(7,5);
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
        System.out.println(this.index);
    }

    public void setSprites(Toolkit tk) {
        for (int i = 0; i < this.sprites.length; i++) {
            this.index = i;
            this.setFileName();
            this.sprites[i] = tk.getImage(this.fileName).getScaledInstance(64, 128, Image.SCALE_DEFAULT);
        }
    }

    public Image getSprites() {
        return this.sprites[this.index];
    }

    public void setSprite(Toolkit tk) {
        this.sprite = tk.getImage(this.fileName).getScaledInstance(64, 128, Image.SCALE_DEFAULT);
    }

    public String getFileName() {
        return this.fileName;
    }

    public Image getSprite() {
        return this.sprite;
    }
    
}
