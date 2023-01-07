import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// public class Chara extends JPanel{
//     private String fileName;
//     private Image sprite;
//     private Toolkit tk;

//     public Chara() {
//         // this.setPreferredSize(new Dimension(300,300));
//         this.tk = Toolkit.getDefaultToolkit();
//         this.sprite = tk.getImage("front0.png").getScaledInstance(60, 70, Image.SCALE_DEFAULT);
//         this.setBounds(0, 0, 60, 70);
//     }

//     @Override
//     public void paintComponent(Graphics g) {
//         Graphics2D g2 = (Graphics2D)g;
//         g2.drawImage(this.sprite, 0, 0, this);
//     }
// }

public class Chara extends JLabel {
    private String fileName;
    private String dir;
    private String action;
    private ImageIcon sprite;
    private int scale = 4;
    private final int width = 12;
    private final int height = 14;

    private int spriteIndex = 0;
    private int pathIndex = 0;

    private Point p;
    private int gridSize;

    private List<Point> path = new ArrayList<Point>();

    public Chara(Point p, int gridSize) {
        // rightwalk masih agak aneh
        this.dir = "left";
        this.action = "walk";
        this.updateFileName(this.dir, this.action, 0);
        this.updateSprite();

        this.p = p;
        this.gridSize = gridSize;

        this.updateSpritePosition();
    }

    public void updatePath(List<Point> p) {
        if(p.size() != 0) {
            this.path = p;
            this.path = this.reversePath();
        }
    }

    public List<Point> reversePath() {
        List<Point> p = new ArrayList<Point>();
        for(int i = this.path.size() - 2; i >= 0; i--) {
            p.add(this.path.get(i)); 
        }
        return p;
    }

    private Point setPosition() {
        int x = (this.gridSize - this.width*this.scale)/2;
        int y = (this.gridSize - this.height*this.scale)/2;
        x += this.p.x * this.gridSize;
        y += this.p.y * this.gridSize;
        Point p = new Point(x,y);
        return p;
    }

    public int[] getMovement() {
        int[] r = new int[2];
        r[0] = 0;
        r[1] = 0;

        if(this.path.size() > 0) {
            int x = this.path.get(0).x - this.p.x;
            int y = this.path.get(0).y - this.p.y;
            
            r[0] = x;
            r[1] = y;

            // this.p.move(r[0], r[1]);

            // System.out.println(this.path);
            // System.out.println(this.path);
            // System.out.println(r[0] + "," + r[1]);
            this.path.remove(0);
        }
        return r;
    }

    public List<Point> getPath() {
        return this.path;
    }

    public void updateSpritePosition() {
        int[] v = this.getMovement();
        // if(v[0] != 0 || v[1] != 0) {
        //     System.out.println(v[0] + "," + v[1]);
        // }
        this.p.translate(v[0], v[1]);
        // System.out.println(this.p);
        this.setBounds(this.setPosition().x, this.setPosition().y, this.width*this.scale, this.height*this.scale);
    }

    private void updateFileName(String dir, String action, int index) {
        this.fileName = dir + action + index;
    }

    public void setSpriteIndex(int i) {
        this.spriteIndex = i;
        String dum = this.dir + this.action + this.spriteIndex + ".png";
        this.fileName = dum;
    }

    public void updateSprite() {
        if(this.spriteIndex < 3) {
            this.spriteIndex ++;
        } else {
            this.spriteIndex = 0;
        }
        this.setSpriteIndex(this.spriteIndex);
        this.sprite = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(this.width*this.scale, this.height*this.scale, Image.SCALE_DEFAULT));
        this.setIcon(this.sprite);
    }

    public int getSpriteIndex() {
        return this.spriteIndex;
    }
}