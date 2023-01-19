import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
    private Point next = new Point(84,8);

    private boolean start = true;

    public Chara(Point p, int gridSize) {
        this.dir = "front";
        this.action = "idle";
        this.updateFileName(this.dir, this.action, 0);
        this.updateSprite();

        this.p = p;
        this.current = p;
        this.gridSize = gridSize;

        this.updateSpritePosition();

        this.current = this.setPosition(this.current);
        this.p = this.setPosition(this.p);

    }

    public void updatePath(List<Point> p) {
        if(p.size() != 0) {
            this.path = p;
            this.path = this.reversePath();
        }
    }

    public List<Point> reversePath() {
        List<Point> p = new ArrayList<Point>();
        for(int i = this.path.size() - 1; i >= 0; i--) {
            p.add(this.path.get(i)); 
        }
        if(start) {
            p.remove(0);
            this.start = false;
        }
        return p;
    }

    public Point setPosition(Point current) {
        int x = (this.gridSize - this.width*this.scale)/2;
        int y = (this.gridSize - this.height*this.scale)/2;
        x += current.x * this.gridSize;
        y += current.y * this.gridSize;
        Point p = new Point(x,y);
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
        
        if(v[0] != 0 || v[0] != 0) {
            while(x != next.x || y != next.y) {
                x += v[0]*1;
                y += v[1]*1;
                this.setBounds(x, y, this.width*this.scale, this.height*this.scale);
            }
        } else {
            this.setBounds(next.x, next.y, this.width*this.scale, this.height*this.scale);
        }
    }

    public void changeMoveValue() {
        if(this.path.size() > 0 && !this.move) {
            this.move = true;
            this.next = this.setPosition(this.path.get(0));
        } else if(this.current.x == this.next.x && this.current.y == this.next.y) {
            this.move = false;
        }
    }

    private void changeDir(int x, int y) {
        if(x < 0) {
            this.dir = "left";
        } else if(x > 0) {
            this.dir = "right";
        }

        if(y > 0 && x == 0) {
            this.dir = "front";
        } else if(y < 0 && x == 0) {
            this.dir = "back";
        }
    }

    private void changeAction(List<Point> p) {
        if(p.size() > 0) {
            this.action = "walk";
        } else {
            this.action = "idle";
        }
    }
    
    public void animateMovement() {
        if(this.move) {
            int x = this.next.x - this.p.x;
            int y = this.next.y - this.p.y;
            this.current.translate(8*x/72, 8*y/72);

            this.changeDir(x, y);

            this.setBounds(this.current.x, this.current.y, this.width*this.scale, this.height*this.scale);
            this.move = true;
        } else if(this.current.x == this.next.x && this.current.y == this.next.y) {
            int x = this.current.x;
            int y = this.current.y;
            this.p = new Point(x,y);

            if(this.path.size() > 1) {
                this.path.remove(0);
                this.next = this.setPosition(this.path.get(0));
            } else {
                this.path.clear();
                this.move = false;
            }
        }

        this.changeAction(this.path);
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
        this.updateFileName(this.dir, this.action, this.spriteIndex);
        if(this.spriteIndex < 3) {
            this.spriteIndex ++;
        } else {
            this.spriteIndex = 0;
        }
        this.setSpriteIndex(this.spriteIndex);
        this.sprite = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(this.width*this.scale, this.height*this.scale, Image.SCALE_DEFAULT));
        this.setIcon(this.sprite);
    }
}