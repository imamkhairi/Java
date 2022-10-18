package swing_learn.tutorial22_DragandDrop;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class DragPanel extends JPanel{

    ImageIcon image = new ImageIcon("swing_learn\\tutorial22_DragandDrop\\smile.png");
    final int WIDTH = image.getIconWidth();
    final int HEIGHT = image.getIconHeight();
    Point imageCorner;
    Point prevPt;
    JLabel imageLabel;
    boolean imageClicked = false;
    
    testLabel test;

    DragPanel() {
        imageCorner = new Point(217,238);
        // this.setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        Click click = new Click();

        this.setLayout(null);

        imageLabel = new JLabel();
        imageLabel.setIcon(image);
        imageLabel.setBounds((int)imageCorner.getX(),(int)imageCorner.getY(),WIDTH,HEIGHT);
        // imageLabel.addMouseListener(clickListener);
        // imageLabel.addMouseMotionListener(dragListener);
        test = new testLabel();

        this.add(test);
        this.add(imageLabel);
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }

    //repaint our image after repositioning
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // image.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
    }

    private class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            int x = (int)e.getPoint().getX();
            int y = (int)e.getPoint().getY();
            // System.out.println(x);
            // System.out.println(y);
            if(x >= imageCorner.getX() && x <= imageCorner.getX() + WIDTH) {
                if(y >= imageCorner.getY() && y <= imageCorner.getY() + HEIGHT) {
                    System.out.println("kena");
                    imageClicked = true;
                }
            } else {
                System.out.println("miss");
            }
            prevPt = e.getPoint();
            // System.out.println("panel clicked");
        }
        public void mouseReleased(MouseEvent e) {
            imageClicked = false;
        }
    }

    private class Click extends MouseAdapter {
        public void mousePressed(MouseEvent e){
            imageClicked = true;
            System.out.println(imageClicked);
        }
        public void mouseReleased(MouseEvent e){
            imageClicked = false;
            System.out.println(imageClicked);
        }
    }

    // biar gambarnya pindah juga ketika kita memindahkan mouse
    private class DragListener extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e) {
            
            if(imageClicked == true) {
                System.out.println("dragging");
    
                Point currentPt = e.getPoint();
                
                imageCorner.translate(
                    (int)(currentPt.getX()-prevPt.getX()),
                    (int)(currentPt.getY()-prevPt.getY())
                );
    
                prevPt = currentPt;
                // repaint();
                imageLabel.setLocation(imageCorner);

            } else {
                System.out.println("gakena");
            }
        }
    }
}
