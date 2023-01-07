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

    private Point p;
    private int gridSize;

    private boolean move = false;

    private List<Point> path = new ArrayList<Point>();

    private Point current;
    private Point next;

    public Chara(Point p, int gridSize) {
        // rightwalk masih agak aneh
        this.dir = "front";
        this.action = "idle";
        this.updateFileName(this.dir, this.action, 0);
        this.updateSprite();

        this.p = p;
        this.gridSize = gridSize;

        this.updateSpritePosition();

        this.current = this.setPosition();
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

    public Point setPosition() {
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

            if(!this.move) this.path.remove(0);
        }
        return r;
    }

    public List<Point> getPath() {
        return this.path;
    }

    public void translateP(int[] v) {
        this.p.translate(v[0], v[1]);
        
    }
    public void updateSpritePosition() {
        int[] v = this.getMovement();
        
        Point next = this.setPosition();
        int x = next.x;
        int y = next.y;
        
        this.p.translate(v[0], v[1]);
        next = this.setPosition();
        
        if(v[0] != 0 || v[0] != 0) {
            while(x != next.x || y != next.y) {
                x += v[0]*1;
                y += v[1]*1;
                System.out.println(x +","+ y);
                this.setBounds(x, y, this.width*this.scale, this.height*this.scale);
            }
        } else {
            this.setBounds(next.x, next.y, this.width*this.scale, this.height*this.scale);
        }
    }

    public void animateMovement() {
        // System.out.println(this.current);
        this.p.translate(1, 1);
        this.next = this.setPosition();
        System.out.println(this.current);
        System.out.println(this.next);
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