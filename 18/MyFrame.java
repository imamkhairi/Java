import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
    private Timer timer;
    private int i = 0;

    public MyFrame() {
        super();
        
        this.timer = new Timer(1000/30, this);
        this.timer.start();

        this.setSize(250,250);
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