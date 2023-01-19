import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener{
    private Dimension dimension = new Dimension(700,700);
    private BufferedImage bi;
    private Boundary[] walls;
    private LightSource source;
    private Graphics bufGraphics;

    public MyPanel() {
        this.bi = new BufferedImage((int)(this.dimension.getWidth()), (int)(this.dimension.getHeight()), BufferedImage.TYPE_INT_ARGB);
        this.bufGraphics = this.bi.getGraphics();
        
        this.walls = new Boundary[5+4];
        for(int i = 0; i < this.walls.length; i++){
            int x1 = (int)(Math.random()*this.dimension.getWidth());
            int y1 = (int)(Math.random()*this.dimension.getHeight());
            int x2 = (int)(Math.random()*this.dimension.getWidth());
            int y2 = (int)(Math.random()*this.dimension.getHeight());
            this.walls[i] = new Boundary(new Point(x1, y1), new Point(x2,y2));
        }

        this.walls[5] = new Boundary(new Point(0,0), new Point(700, 0));
        this.walls[6] = new Boundary(new Point(700,0), new Point(700, 700));
        this.walls[7] = new Boundary(new Point(700,700), new Point(0, 700));
        this.walls[8] = new Boundary(new Point(0,700), new Point(0, 0));

        this.source = new LightSource();

        this.setPreferredSize(this.dimension);
        this.setBackground(new Color(0,0,0));

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    private Graphics2D convTo2D(Graphics g) {
        return (Graphics2D)g;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.source.updPosition(e.getX(), e.getY());
        this.source.show(this.convTo2D(this.bufGraphics));
        this.source.cast(this.walls, this.convTo2D(this.bufGraphics));
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.bufGraphics.setColor(Color.BLACK);
        this.bufGraphics.fillRect(0, 0, (int)this.dimension.getWidth(), (int)this.dimension.getWidth());
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.bufGraphics.setColor(Color.BLACK);
        this.bufGraphics.fillRect(0, 0, (int)this.dimension.getWidth(), (int)this.dimension.getWidth());

        this.source.updPosition(e.getX(), e.getY());
        this.source.show(this.convTo2D(this.bufGraphics));
        this.source.cast(this.walls, this.convTo2D(this.bufGraphics));

        this.repaint();    
    }
    
    @Override
    public void mouseMoved(MouseEvent e) { }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for(int i = 0; i < this.walls.length; i ++) {
            this.walls[i].show(this.convTo2D(this.bufGraphics));
        }
        super.paintComponent(g2);
        g2.drawImage(this.bi, null, 0, 0);
    }
}