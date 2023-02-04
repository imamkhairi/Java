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

    private void drawHorizontalGrid(GridSystem gridSystem) {
        Graphics2D g2 = this.getBufferGraphics();
        // super.paintComponent(g2);

        g2.setColor(Color.LIGHT_GRAY);
        for(int i = 1; i <= gridSystem.getRowCount(); i++) {
            g2.drawLine(0, i*this.gridSize, 
            this.windowSize.width, i*this.gridSize);
        }

        g2.dispose();
        this.repaint();
    }

    private void drawVerticalGrid(GridSystem gridSystem) {
        Graphics2D g2 = this.getBufferGraphics();
        // super.paintComponent(g2);

        g2.setColor(Color.LIGHT_GRAY);
        for(int i = 1; i <= gridSystem.getColumnCount(); i++) {
            g2.drawLine(i*this.gridSize, 0, 
            i*this.gridSize, this.windowSize.height);
        }

        g2.dispose();
        this.repaint();
    }


    // Furniture

    private void drawTable(Table table) {
        Graphics2D g2 = this.getBufferGraphics();
        // super.paintComponent(g2);

        g2.setColor(Color.GREEN);
        g2.fillRect(this.changeToGridCoordinate(table.getX()), this.changeToGridCoordinate(table.getY()), 
        this.changeToGridCoordinate(table.getWidth()), this.changeToGridCoordinate(table.getHeight()));

        g2.dispose();
        this.repaint();
    }

    public void drawAll(GridSystem gridSystem, Table table) {
        Graphics2D g2 = this.getBufferGraphics();
        super.paintComponent(g2);

        // makin bawah, makin di atas di panel
        this.drawHorizontalGrid(gridSystem);
        this.drawVerticalGrid(gridSystem);
        this.drawTable(table);

        g2.dispose();
        this.repaint();
    }

    public void drawAll(GridSystem gridSystem, Table table, Table example) {
        Graphics2D g2 = this.getBufferGraphics();
        super.paintComponent(g2);

        // makin bawah, makin di atas di panel
        this.drawHorizontalGrid(gridSystem);
        this.drawVerticalGrid(gridSystem);
        this.drawTable(table);
        this.drawTable(example);

        g2.dispose();
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(this.bi, null, 0, 0);
    }
}