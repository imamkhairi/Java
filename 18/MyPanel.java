import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

// public class MyPanel extends JPanel implements MouseListener{
public class MyPanel extends JPanel{
    private Dimension windowSize;
    private int gridSize;
    
    private BufferedImage bi;

    private NPC customer;
    private Table table;

    private GridSystem gridSystem;

    public MyPanel(Dimension windowSize, int gridSize, NPC customer, Table table, GridSystem gridSystem) {
        this.windowSize = windowSize;
        this.setPreferredSize(this.windowSize);
        this.bi = new BufferedImage(this.windowSize.width, this.windowSize.height, BufferedImage.TYPE_INT_ARGB);
        this.gridSize = gridSize;
        this.customer = customer;
        this.table = table;
        this.gridSystem = gridSystem;
    }

    private Graphics2D getBufferGraphics() {
        Graphics g = this.bi.getGraphics();
        Graphics2D g2 = (Graphics2D)g;
        return g2;
    }

    private int changeToGridCoordinate(int target) {
        return this.gridSize*target;
    }

    // GRID
    private void drawHorizontalGrid(Graphics2D g2) {
        g2.setColor(Color.LIGHT_GRAY);
        for(int i = 1; i <= this.gridSystem.getRowCount(); i++) {
            g2.drawLine(0, i*this.gridSize, 
            this.windowSize.width, i*this.gridSize);
        }
    }

    private void drawVerticalGrid(Graphics2D g2) {
        g2.setColor(Color.LIGHT_GRAY);
        for(int i = 1; i <= this.gridSystem.getColumnCount(); i++) {
            g2.drawLine(i*this.gridSize, 0, 
            i*this.gridSize, this.windowSize.height);
        }
    }


    // Furniture
    private void drawTable(Graphics2D g2) {
        int x = this.changeToGridCoordinate(this.table.getX());
        int y = this.changeToGridCoordinate(this.table.getY());
        g2.drawImage(this.table.getSprite(),x, y, this.gridSize*this.table.getWidth(), this.gridSize*this.table.getHeight(), null);
    }

    // NPC
    public void drawCustomer(Graphics2D g2) {
        // int x = this.changeToGridCoordinate(this.customer.getCurrentPoint().x);
        int x = this.customer.getCurrentPoint().x;
        // int y = this.changeToGridCoordinate(this.customer.getCurrentPoint().y - 1);
        int y = this.customer.getCurrentPoint().y - this.gridSize;

        g2.drawImage(this.customer.getBufferedImage(), x, y, this.gridSize,this.gridSize*2, null);
    }

    public void drawAll() {
        Graphics2D g2 = this.getBufferGraphics();
        super.paintComponent(g2);

        // makin bawah, makin di atas di panel
        this.drawTable(g2);
        this.drawCustomer(g2);
        this.drawHorizontalGrid(g2);
        this.drawVerticalGrid(g2);

        g2.dispose();
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        
        this.drawAll();
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(this.bi, null, 0, 0);
    }
}