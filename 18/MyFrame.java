import java.awt.event.*;
import java.util.LinkedList;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
    private Timer timer;
    private int i = 0;

    private MyPanel gamePanel;
    private GridSystem gridSystem;
    private Table table;
    private NPC customerNPC;

    private PathFinder pathFinder;

    private LinkedList<Point> chairPoints;

    private final Dimension windowSize = new Dimension(1920, 1080);
    private final int gridSize = 64; 

    private final int fps = 30;


    public MyFrame() {
        super();
        
        this.timer = new Timer(1000/this.fps, this);
        this.timer.start();

        this.gridSystem = new GridSystem(this.windowSize, this.gridSize);
        
        this.table = new Table(1,1,2,2,this.gridSystem);
        this.chairPoints = this.table.getChairPosition();
        
        this.customerNPC = new NPC(this.chairPoints.get((int)(Math.random()*4)));

        this.pathFinder = new PathFinder(this.gridSystem);
        
        // DEBUG
        this.customerNPC.setPath(this.pathFinder.startPathFinding(this.customerNPC.getStarPoint(), this.customerNPC.getCurrentPoint(), this.customerNPC.getEndPoint()));

        this.gamePanel = new MyPanel(this.windowSize, this.gridSize, this.customerNPC, this.table, this.gridSystem);

        this.getContentPane().add(this.gamePanel);

        // this.gamePanel.drawAll(this.gridSystem, this.table, this.customerNPC);

        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new MyFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(i == 5) {
            this.customerNPC.move();
            this.customerNPC.increaseIndex();  
            this.gamePanel.repaint();  
            i = 0;
        } else {
            i++;
        }
        // System.out.println(i);
    }

}