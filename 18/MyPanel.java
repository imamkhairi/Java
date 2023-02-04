import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

// public class MyPanel extends JPanel implements MouseListener{
public class MyPanel extends JPanel{
    private Dimension windowSize;
    private BufferedImage bi;
    private int gridSize;

    public MyPanel(Dimension windowSize, int gridSize) {
        this.windowSize = windowSize;
        this.setPreferredSize(this.windowSize);
        this.bi = new BufferedImage(this.windowSize.width, this.windowSize.height, BufferedImage.TYPE_INT_ARGB);
        this.gridSize = gridSize;
        // this.addMouseListener(this);
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
        // super.paintComponent(g2);

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
    private void drawCostumer(Graphics2D g2, NPC costumer) {
        // super.paintComponent(g2);

        g2.setColor(Color.ORANGE);
        g2.fillRect(this.changeToGridCoordinate(costumer.getCurrentPoint().x), this.changeToGridCoordinate(costumer.getCurrentPoint().y),
        this.gridSize, this.gridSize);
    }

    public void drawAll(GridSystem gridSystem, Table table, NPC costumer) {
        Graphics2D g2 = this.getBufferGraphics();
        super.paintComponent(g2);

        // makin bawah, makin di atas di panel
        this.drawTable(g2, table);
        this.drawCostumer(g2, costumer);
        this.drawHorizontalGrid(g2, gridSystem);
        this.drawVerticalGrid(g2, gridSystem);

        g2.dispose();
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(this.bi, null, 0, 0);
    }
}