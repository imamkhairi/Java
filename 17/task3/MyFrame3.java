import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyFrame3 extends JFrame implements ActionListener{
    private MyPanel3 mp;
    private Timer timer;

    //Test 

    public MyFrame3() {
        super();
        
        this.timer = new Timer(400, this);
        this.timer.start();

        this.mp = new MyPanel3();
        
        this.getContentPane().add(this.mp);
        // this.getContentPane().add(this.myGrid);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame3();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // System.out.println("timer success");
        // this.mp.checkOpen();
        this.mp.update();
        Toolkit.getDefaultToolkit().sync();
    }
}