import java.awt.event.*;
import java.util.LinkedList;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
    private Timer timer;
    // private int i = 0;

    private MyPanel gamePanel;
    private GridSystem gridSystem;
    private Table table;
    private NPC customerNPC;

    private PathFinder pathFinder;

    // DEBUG
    private Table example;

    private LinkedList<Point> chairPoints;

    private final Dimension windowSize = new Dimension(1920, 1080);
    private final int gridSize = 64; //32*2

    public MyFrame() {
        super();
        
        this.timer = new Timer(1000/30, this);
        this.timer.start();

        this.gamePanel = new MyPanel(this.windowSize, this.gridSize);
        this.gridSystem = new GridSystem(this.windowSize, this.gridSize);

        this.table = new Table(1,1,2,2);
        this.chairPoints = this.table.getChairPosition();
        
        this.customerNPC = new NPC(this.chairPoints.get((int)(Math.random()*4)));

        this.pathFinder = new PathFinder(this.gridSystem);
        

        this.example = new Table(16, 13, 1, 1);
        // DEBUG
        this.pathFinder.startPathFinding(this.customerNPC.getStarPoint(), this.customerNPC.getCurrentPoint(), this.customerNPC.getEndPoint());
        // System.out.println(this.chairPoints.get((int)(Math.random()*4)));

        this.getContentPane().add(this.gamePanel);

        this.gamePanel.drawAll(this.gridSystem, this.table, this.example);

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
        // if(i == 30) {
        //     System.out.println("1 second");
        //     i = 0;
        // } else {
        //     i++;
        // }
        // System.out.println(i);
    }
}