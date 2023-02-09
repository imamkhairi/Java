import java.awt.event.*;
import java.util.LinkedList;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
    private Timer timer;
    private int i;
    private MyPanel gamePanel;
    private GridSystem gridSystem;
    private NPC customerNPC;
    private StageData stageData;
    private LinkedList<Point> chairPoints;
    private final Dimension windowSize = new Dimension(1920, 1080);
    private int gridSize; 
    private final int fps = 60;


    public MyFrame() {
        super();
        this.gridSystem = new GridSystem(this.windowSize);
        this.gridSize = this.gridSystem.getGridSize();
        this.stageData = new StageData(this.gridSystem);
        this.chairPoints = this.stageData.getChairPoints();
        this.customerNPC = new NPC(new Point(14,14+(int)(Math.random()*2)), this.chairPoints.get((int)(Math.random()*36)), this.gridSize, this.gridSystem);
        this.gamePanel = new MyPanel(this.windowSize, this.gridSize, this.customerNPC, this.stageData, this.chairPoints, this);
        this.getContentPane().add(this.gamePanel);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.i = 0;
        this.timer = new Timer(1000/this.fps, this);
        this.timer.start();

        KeyAdapter listener = new KeyAdapter() {
            @Override public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

            if(key == KeyEvent.VK_Q) {
                System.exit(0);
            }
            }
        };

        this.addKeyListener(listener);
    }
    
    public static void main(String[] args) {
        new MyFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.i == 3) {
            this.customerNPC.move();
            this.gamePanel.repaint();  
            this.i = 0;
        } else {
            this.i++;
        }
    }

}