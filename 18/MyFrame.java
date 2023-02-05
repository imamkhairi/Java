import java.awt.event.*;
import java.util.LinkedList;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener, MouseListener{
    private Timer timer;
    private int i = 0;

    private MyPanel gamePanel;
    private GridSystem gridSystem;
    private Table table;
    private NPC customerNPC;

    private PathFinder pathFinder;

    private LinkedList<Point> chairPoints;

    private final Dimension windowSize = new Dimension(1920, 1080);
    private final int gridSize = 64; //32*2

    private final int fps = 30;

    private Toolkit tk;

    public MyFrame() {
        super();
        
        this.tk = Toolkit.getDefaultToolkit();

        this.timer = new Timer(1000/this.fps, this);
        this.timer.start();

        this.gridSystem = new GridSystem(this.windowSize, this.gridSize);
        
        this.table = new Table(1,1,2,2,this.gridSystem);
        this.chairPoints = this.table.getChairPosition();
        
        this.customerNPC = new NPC(this.tk, this.chairPoints.get((int)(Math.random()*4)));
        // this.customerNPC = new NPC(new Point(0,1));
        
        
        this.pathFinder = new PathFinder(this.gridSystem);
        
        // DEBUG
        this.customerNPC.setPath(this.pathFinder.startPathFinding(this.customerNPC.getStarPoint(), this.customerNPC.getCurrentPoint(), this.customerNPC.getEndPoint()));
        this.customerNPC.setSprite(tk);

        this.gamePanel = new MyPanel(this.windowSize, this.gridSize, this.customerNPC);
        this.getContentPane().add(this.gamePanel);

        // this.gamePanel.drawAll(this.gridSystem, this.table, this.customerNPC);

        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.addMouseListener(this);
    }
    
    public static void main(String[] args) {
        new MyFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(i == 20) {
        //     // System.out.println("1 second");
        //     this.customerNPC.move();
        //     this.gamePanel.drawAll(this.gridSystem, this.table, this.customerNPC);
        //     this.gamePanel.repaint();

            this.customerNPC.increaseIndex();
            this.customerNPC.setFileName();
            this.customerNPC.setSprite(this.tk);  
            this.gamePanel.repaint();  

            i = 0;
        } else {
            i++;
        }
        // System.out.println(i);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("clicked");        
    }

    @Override
    public void mousePressed(MouseEvent e) {
            
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}