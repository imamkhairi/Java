import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.LinkedList;

public class MyPanel extends JPanel implements MouseListener{
    private Dimension windowSize;
    private int gridSize;
    private BufferedImage bi;
    private NPC customer;
    private GridSystem gridSystem;
    private StageData stageData;
    private LinkedList<Point> chairPoints;


    public MyPanel(Dimension windowSize, int gridSize, NPC customer, StageData stageData, LinkedList<Point> chairPoints, JFrame frame) {
        this.windowSize = windowSize;
        this.setPreferredSize(this.windowSize);
        this.bi = new BufferedImage(this.windowSize.width, this.windowSize.height, BufferedImage.TYPE_INT_ARGB);
        this.gridSize = gridSize;
        this.customer = customer;
        this.stageData = stageData;
        this.chairPoints = chairPoints;

        this.addMouseListener(this);
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
    // private void drawHorizontalGrid(Graphics2D g2) {
    //     g2.setColor(Color.LIGHT_GRAY);
    //     for(int i = 1; i <= this.gridSystem.getRowCount(); i++) {
    //         g2.drawLine(0, i*this.gridSize, 
    //         this.windowSize.width, i*this.gridSize);
    //     }
    // }

    // private void drawVerticalGrid(Graphics2D g2) {
    //     g2.setColor(Color.LIGHT_GRAY);
    //     for(int i = 1; i <= this.gridSystem.getColumnCount(); i++) {
    //         g2.drawLine(i*this.gridSize, 0, 
    //         i*this.gridSize, this.windowSize.height);
    //     }
    // }


    // Furniture
    private void drawFurniture(Graphics2D g2, Furniture furniture) {
        int x = this.changeToGridCoordinate(furniture.getX());
        int y = this.changeToGridCoordinate(furniture.getY());
        g2.drawImage(furniture.getSprite(),x, y, this.gridSize*furniture.getWidth(), this.gridSize*furniture.getHeight(), null);
    }

    // NPC
    public void drawCustomer(Graphics2D g2) {
        int x = this.customer.getCurrentPoint().x;
        int y = this.customer.getCurrentPoint().y - this.gridSize;

        g2.drawImage(this.customer.getSprite(), x, y, this.gridSize,this.gridSize*2, null);
    }

    //Stage
    private void drawStage(Graphics2D g2) {
        g2.drawImage(this.stageData.getBackgroundImage(), 0, 0, this.windowSize.width, this.windowSize.height, null);
        for ( int i = 0; i < this.stageData.getTables().length; i++){
            this.drawFurniture(g2, this.stageData.getTables()[i]);
        }
        for ( int i = 0; i < this.stageData.getChairs().length; i ++) {
            this.drawFurniture(g2, this.stageData.getChairs()[i]);
        }
    }

    public void drawAll() {
        Graphics2D g2 = this.getBufferGraphics();
        super.paintComponent(g2);

        this.drawStage(g2);
        this.drawCustomer(g2);
        // this.drawHorizontalGrid(g2);
        // this.drawVerticalGrid(g2);

        g2.dispose();
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        
        this.drawAll();
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(this.bi, null, 0, 0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.customer.getPhase() == 1) {
            this.customer.startNewPath(this.chairPoints.get((int)(Math.random()*36)));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}