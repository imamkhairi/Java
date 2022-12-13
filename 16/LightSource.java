import java.awt.*;

public class LightSource {
    private Point center;
    private Ray[] rays;

    public LightSource() {
        this.center = new Point(350, 350);
        int divider = 3;
        this.rays = new Ray[360/divider];

        for(int i = 0; i < 360; i+= divider) {
            int x = (int)Math.round(Math.cos(Math.toRadians((double)i))*5);
            int y = (int)Math.round(Math.sin(Math.toRadians((double)i))*5);
            this.rays[i/divider] = new Ray(this.center, new Point(x,y));
        }
    }

    public void show(Graphics2D g2) {
        for(int i = 0; i < this.rays.length; i++) {
            rays[i].showRay(g2);
        }
    }

    public void cast(Boundary[] walls, Graphics2D g2) {
        g2.setColor(new Color(255,255,255,50));
        for(int i = 0; i < this.rays.length; i++) {
            Point closest = null; 
            int record = (int)(750*Math.sqrt((double)2)); //window diagonal size
            for(int j = 0; j < walls.length; j ++) {
                Point pt = rays[i].castLight(walls[j]);
                if(pt != null) {
                    int d = (int)Math.round(this.calcDist(this.center.x, this.center.y, pt.x, pt.y));
                    if(d < record) {
                        record = d;
                        closest = pt;
                    }
                }
            }
            if(closest != null) {
                g2.drawLine(this.center.x, this.center.y, closest.x, closest.y);
            }
        }
    }

    private double calcDist(int x1, int y1, int x2, int y2) {
        double dx = x1-x2;
        double dy = y1-y2;
        double sqrt = Math.sqrt(dx*dx + dy*dy);
        return sqrt;
    }
    public void updPosition(int x, int y) {
        this.center.x = x;
        this.center.y = y;
    }
}