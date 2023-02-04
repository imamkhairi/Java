import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
    private Timer timer;
    private int i = 0;

    private MyPanel gamePanel;
    private GridSystem gridSystem;

    private final Dimension windowSize = new Dimension(1920, 1080);
    private final int gridSize = 64; //32*2

    public MyFrame() {
        super();
        
        this.timer = new Timer(1000/30, this);
        this.timer.start();

        this.gamePanel = new MyPanel(this.windowSize, this.gridSize);
        this.gridSystem = new GridSystem(this.windowSize, this.gridSize);

        this.getContentPane().add(this.gamePanel);

        this.gamePanel.drawAll(this.gridSystem);

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
        if(i == 30) {
            System.out.println("1 second");
            i = 0;
        } else {
            i++;
        }
        // System.out.println(i);
    }
}