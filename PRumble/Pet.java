import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;

public class Pet extends JPanel{ // ini masih ada kemungkinan untuk jadi parent class gitu
    
    private ImageIcon Image;
    private GamePanel gp;
    Point imageCorner;
    Point center;
    
    public Pet (int x, int y, GamePanel gp) {
        this.gp = gp;
        imageCorner = new Point(x, y);
        this.Image = new ImageIcon("D:\\Kosen\\Java\\PRumble\\res\\crab.png");
    }
    
    public ImageIcon getImageIcon() {
        return this.Image;
    } 

    public Point getPoint() {
        return this.imageCorner;
    }

    public int getX() {
        return (int)getPoint().getX();
    }

    public int getY() {
        return (int)getPoint().getY();
    }

    public int getWidth() {
        return Image.getIconWidth();
    }

    public int getHeight() {
        return Image.getIconHeight();
    }

    public Point getCenter() {
        int centerX = (int)this.imageCorner.getX() + this.getWidth()/2;
        int centerY = (int)this.imageCorner.getY() + this.getHeight()/2;

        this.center = new Point(centerX, centerY);
        return this.center;
    }

    // public boolean getCollision(Pet p) {
    //     double distance = Math.sqrt((this.getCenter().getX() - p.getCenter().getX())*(this.getCenter().getX() - p.getCenter().getX()) + (this.getCenter().getY() - p.getCenter().getY())*(this.getCenter().getY() - p.getCenter().getY()));
    //     boolean collision = false;
    //     // System.out.println("Distance : " + (int)distance);
    //     if((int)distance <= 70) collision = true;
    //     else collision = false;
    //     return collision;
    // }
    public boolean getCollision(Point p) {
        double pX = p.getX()+this.getWidth()/2;
        double pY = p.getY()+this.getHeight()/2;
        double distance = Math.sqrt((this.getCenter().getX() - pX)*(this.getCenter().getX() - pX) + (this.getCenter().getY() - pY)*(this.getCenter().getY() - pY));
        boolean collision = false;
        // System.out.println("Distance : " + (int)distance);
        // System.out.println(pX);
        // System.out.println(pY);
        if((int)distance <= 70) collision = true;
        else collision = false;
        return collision;
    }
    public void draw(Graphics g2) {
        this.Image.paintIcon(this.gp, g2, (int)this.imageCorner.getX(), (int)this.imageCorner.getY());
    }
}
