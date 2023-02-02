import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class testFrame extends JFrame implements ActionListener, KeyListener {
    private Timer timer;
    private int i = 0;
    private testPanel panel;
    private pointer pointer;
    
    public testFrame() {
        super();

        this.timer = new Timer(1000/90, this);
        this.timer.start();

        this.panel = new testPanel();
        this.pointer = new pointer(500,500);

        // this.setSize(250,250);
        this.getContentPane().add(this.panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.addKeyListener(this);
        // this.panel.testDraw();
    }

    public static void main(String[] args) {
        new testFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.pointer.move();
        this.panel.drawPointer(this.pointer);
        this.panel.repaint();
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            System.out.println(this.pointer.getX() + ", " + this.pointer.getY());
        }
    }
    public void keyReleased(KeyEvent e){ }
    public void keyTyped(KeyEvent e){ }

    // coba tambahin listener keyboardnya (space)
}