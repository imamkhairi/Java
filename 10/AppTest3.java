import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppTest3 extends JFrame implements ActionListener{
    private JButton button;

    public AppTest3() {
        super();

        this.button = new JButton("Click!");
        this.button.setFocusable(false);
        this.button.addActionListener(this);
        // this.button.addActionListener(e -> System.out.println("Hahaha"));
        // this.button.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         System.out.println("clicked");
        //     }
        // });
        super.getContentPane().add(this.button);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button) {
            System.out.println("Button Clikced");
        } 
    }
    
    public static void main(String[] args) {
        AppTest3 myFrame = new AppTest3();
        myFrame.setSize(500, 500);
        myFrame.setLocation(10,10);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
}
