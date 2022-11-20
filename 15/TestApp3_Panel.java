import javax.swing.JPanel;
import java.awt.*;

public class TestApp3_Panel extends JPanel{
    private Dimension windowSize = new Dimension(500,500);
    private My3DPoint[] point;

    public TestApp3_Panel() {
        this.setPreferredSize(windowSize);
        this.point = new My3DPoint[4];
        
        // initiate points
        this.point[0] = new My3DPoint(100, 100, 0);
        this.point[1] = new My3DPoint(200, 100, 0);
        this.point[2] = new My3DPoint(200, 200, 0);
        this.point[3] = new My3DPoint(100, 200, 0);

        // change into 1 x 3 matrix (transpose)
        for(int i = 0; i < this.point.length; i ++){
            point[i] = point[i].changeToPoint(MyMatrix.rotation(0.2, MyMatrix.tPoint(point[i])));
            // ini masih kurang
            // point -> vector(transpose) -> transform -> pindah ke 2d -> point
        }


    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        super.paintComponent(g2);

        // g2.drawOval(100, 100, 100, 100);
        g2.setColor(Color.BLUE);
        for(int i = 0; i < this.point.length; i++) {
            g2.fillOval(point[i].getX(), point[i].getY(), 15, 15);
        }
    }
}
