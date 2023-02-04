import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class testFrame extends JFrame implements ActionListener, KeyListener {
    private Timer timer;
    private int i = 0;
    private testPanel panel;
    private pointer pointer;
    private box box;
    private box[] target;

    private int[] xTarget;

    public testFrame() {
        super();

        this.timer = new Timer(1000/90, this);
        this.timer.start();

        this.panel = new testPanel();
        this.box = new box(50,200,400);
        this.pointer = new pointer(this.box.getX(), this.box.getX() + this.box.getWidth());
        this.target = new box[3];
        
        this.initiateTarget();

        this.xTarget = new int[this.target.length];

        this.setTargetX();

        this.getContentPane().add(this.panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.addKeyListener(this);
    }

    public static void main(String[] args) {
        new testFrame();
    }

    private void initiateTarget() {
        ArrayList<Integer> x = new ArrayList<Integer>();

        for (int i = 0; i < this.target.length; i++) {
            int randX = 50 + (int)(Math.random()*(this.box.getWidth() - 40));
            System.out.println("x " + randX);

            if(x.size() > 0) {
                for(int value : x) {
                    System.out.println("value "+ value);
                    while(Math.abs(randX - value) < 40) {
                        randX = 50 + (int)(Math.random()*(this.box.getWidth() - 40));
                        System.out.println("DEMPET");
                        System.out.println("x update " + randX);
                    }
                }
            }
        
            this.target[i] = new box(randX, 200, 40);
            x.add(this.target[i].getX());
        }
        
        // System.out.println(x);
    }

    private void setTargetX() {
        for (int i = 0; i < this.target.length; i++) {
            this.xTarget[i] = this.target[i].getX();
        }
    }

    private void checkPoint(int x) {
        for (int i = 0; i < this.target.length; i++) {
            if(x >= this.target[i].getX() && x <= this.target[i].getX() + this.target[i].getWidth()) {
                System.out.println("kena");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.pointer.move();
        // this.panel.drawPointer(this.pointer);
        this.panel.drawAll(this.pointer, this.box, this.target);
        this.panel.repaint();
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            int x = this.pointer.getX();
            // System.out.println(x);
            this.checkPoint(x);
        }
    }
    public void keyReleased(KeyEvent e){ }
    public void keyTyped(KeyEvent e){ }

}