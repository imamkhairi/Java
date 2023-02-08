import java.awt.event.*;
import java.util.LinkedList;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
    private Timer timer;
    private int i = 0;

    private MyPanel gamePanel;
    private GridSystem gridSystem;
    private NPC customerNPC;
    private StageData stageData;

    private PathFinder pathFinder;

    private LinkedList<Point> chairPoints;

    private final Dimension windowSize = new Dimension(1920, 1080);
    private int gridSize; 

    private final int fps = 60;


    public MyFrame() {
        super();
        
        this.timer = new Timer(1000/this.fps, this);
        this.timer.start();

        this.gridSystem = new GridSystem(this.windowSize);
        this.gridSize = this.gridSystem.getGridSize();

        this.stageData = new StageData(this.gridSystem);
        this.chairPoints = this.stageData.getChairPoints();
        
        this.customerNPC = new NPC(new Point(14,14+(int)(Math.random()*2)), this.chairPoints.get((int)(Math.random()*36)), this.gridSize, this.gridSystem);
        // this.customerNPC = new NPC(new Point(7,5), this.chairPoints.get(3), this.gridSize);

        this.pathFinder = new PathFinder(this.gridSystem);
        
        // DEBUG
        this.customerNPC.setPath(this.pathFinder.startPathFinding(this.customerNPC.getStarPoint(), this.customerNPC.getCurrentPoint(), this.customerNPC.getEndPoint(), this.gridSize));
        // System.out.println(this.customerNPC.getPath());

        this.gamePanel = new MyPanel(this.windowSize, this.gridSize, this.customerNPC, this.gridSystem, this.stageData);
        this.getContentPane().add(this.gamePanel);
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
    }

}