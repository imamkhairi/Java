import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class Pet extends JPanel{
    
    private ImageIcon crabImage;
    Point imageCorner;
    
    public Pet (int x, int y) {
        imageCorner = new Point(x, y);
        this.crabImage = new ImageIcon("PRumble/res/crab.png");
    }
    
    public ImageIcon getImageIcon() {
        return this.crabImage;
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
        return crabImage.getIconWidth();
    }

    public int getHeight() {
        return crabImage.getIconHeight();
    }
}
