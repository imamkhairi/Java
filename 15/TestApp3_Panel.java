import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.*;

public class TestApp3_Panel extends JPanel{
    private Dimension windowSize = new Dimension(500,500);
    private My3DPoint[] point;
    private My3DPoint[] projectedPoint;
    private int x;
    private int y;

    public TestApp3_Panel() {
        this.setPreferredSize(windowSize);
        this.setBackground(Color.BLACK);

        this.point = new My3DPoint[8];
        this.projectedPoint = new My3DPoint[8];

        this.x = (int)this.windowSize.getWidth()/2;
        this.y = (int)this.windowSize.getHeight()/2;
        
        // initiate points
        this.initiatePoint(100, this.point);
        this.initiatePoint(100, this.projectedPoint);

        for(int i = 0; i < this.projectedPoint.length; i++) {
            this.perspective2D(i);
        }
        
    }

    private void initiatePoint(int length, My3DPoint[] targetPoint) {
        targetPoint[0] = new My3DPoint(-length, length, length);
        targetPoint[1] = new My3DPoint(length, length, length);
        targetPoint[2] = new My3DPoint(length, -length, length);
        targetPoint[3] = new My3DPoint(-length, -length, length);
        targetPoint[4] = new My3DPoint(-length, length, -length);
        targetPoint[5] = new My3DPoint(length, length, -length);
        targetPoint[6] = new My3DPoint(length, -length, -length);
        targetPoint[7] = new My3DPoint(-length, -length, -length);
    }

    public int getPointsCount() {
        return this.point.length;
    }

    public void rotation(int i, double angleX, double angleY, double angleZ) {
        double radX = Math.toRadians(angleX);
        double radY = Math.toRadians(angleY);
        double radZ = Math.toRadians(angleZ);
        this.projectedPoint[i] = this.point[i].changeToPoint(MyMatrix.rotationTransform(radX, radY, radZ, MyMatrix.tPoint(this.point[i])));
    }

    public void to2D(int i) {
        this.projectedPoint[i] = this.projectedPoint[i].changeToPoint(MyMatrix.matrixMul(MyMatrix.projection, MyMatrix.tPoint(this.projectedPoint[i])));
    }

    public void perspective2D(int i) {
        this.projectedPoint[i] = this.projectedPoint[i].changeToPoint(
            MyMatrix.matrixMul(
                MyMatrix.perspectiveProjection(200, this.projectedPoint[i].getZ()), MyMatrix.tPoint(this.projectedPoint[i])
                )
            );
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        super.paintComponent(g2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);

        // draw point
        for(int i = 0; i < this.projectedPoint.length; i++) {
            g2.fillOval(x + (int)projectedPoint[i].getX() - 5, y + (int)projectedPoint[i].getY() - 5, 10, 10);
        }
        //draw cube
        for(int i = 0; i < 4; i ++) {
            g2.drawLine(x + (int)projectedPoint[i].getX(), y + (int)projectedPoint[i].getY(), x + (int)projectedPoint[(i+1)%4].getX(), y + (int)projectedPoint[(i+1)%4].getY());
            g2.drawLine(x + (int)projectedPoint[i+4].getX(), y + (int)projectedPoint[i+4].getY(), x + (int)projectedPoint[(i+1)%4+4].getX(), y + (int)projectedPoint[(i+1)%4+4].getY());
            g2.drawLine(x + (int)projectedPoint[i].getX(), y + (int)projectedPoint[i].getY(), x + (int)projectedPoint[i+4].getX(), y + (int)projectedPoint[i+4].getY());
        }

    }
}