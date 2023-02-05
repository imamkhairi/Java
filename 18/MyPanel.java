import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

// public class MyPanel extends JPanel implements MouseListener{
public class MyPanel extends JPanel{
    private Dimension windowSize;
    private int gridSize;
    
    private BufferedImage bi;
    // TEST
    private NPC customer;

    public MyPanel(Dimension windowSize, int gridSize, NPC customer) {
        this.windowSize = windowSize;
        this.setPreferredSize(this.windowSize);
        this.bi = new BufferedImage(this.windowSize.width, this.windowSize.height, BufferedImage.TYPE_INT_ARGB);
        this.gridSize = gridSize;
        this.customer = customer;
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
    private void drawHorizontalGrid(Graphics2D g2, GridSystem gridSystem) {
        g2.setColor(Color.LIGHT_GRAY);
        for(int i = 1; i <= gridSystem.getRowCount(); i++) {
            g2.drawLine(0, i*this.gridSize, 
            this.windowSize.width, i*this.gridSize);
        }
    }

    private void drawVerticalGrid(Graphics2D g2, GridSystem gridSystem) {
        g2.setColor(Color.LIGHT_GRAY);
        for(int i = 1; i <= gridSystem.getColumnCount(); i++) {
            g2.drawLine(i*this.gridSize, 0, 
            i*this.gridSize, this.windowSize.height);
        }
    }


    // Furniture
    private void drawTable(Graphics2D g2, Table table) {
        // super.paintComponent(g2);

        g2.setColor(Color.GREEN);
        g2.fillRect(this.changeToGridCoordinate(table.getX()), this.changeToGridCoordinate(table.getY()), 
        this.changeToGridCoordinate(table.getWidth()), this.changeToGridCoordinate(table.getHeight()));
    }

    // NPC
    private void drawCostumer(Graphics2D g2, NPC customer) {
        g2.setColor(Color.ORANGE);
        g2.fillRect(this.changeToGridCoordinate(customer.getCurrentPoint().x), this.changeToGridCoordinate(customer.getCurrentPoint().y),
        this.gridSize, this.gridSize);
        // g2.drawImage(customer.getSprite(), 500, 500, this);
    }

    // public void drawAll(GridSystem gridSystem, Table table, NPC costumer) {
    //     Graphics2D g2 = this.getBufferGraphics();
    //     super.paintComponent(g2);

    //     // makin bawah, makin di atas di panel
    //     this.drawTable(g2, table);
    //     this.drawCostumer(g2, costumer);
    //     this.drawHorizontalGrid(g2, gridSystem);
    //     this.drawVerticalGrid(g2, gridSystem);

    //     g2.dispose();
    //     this.repaint();
    // }

    // TEST
    public void paintImage(Graphics2D g2) {
        super.paintComponent(g2);
        g2.drawImage(this.customer.getSprites(), 500, 500, this);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        
        this.paintImage(this.getBufferGraphics());
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(this.bi, null, 0, 0);
    }
}