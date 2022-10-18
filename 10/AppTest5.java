import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppTest5 extends JFrame implements ActionListener{
    private JButton button1;
    private JButton button2;


    public AppTest5() {
        super();

        this.button1 = new JButton("Button1");
        this.button1.setBounds(10, 10, 100, 40);
        this.button1.addActionListener( 
            // e -> System.out.println("button1 pressed")
            this
            );
        this.button2 = new JButton("Button2");
        this.button2.setBounds(10, 60, 100, 40);
        this.button2.addActionListener(
            // e -> System.out.println("button2 is pressed")
            this    
        );

        this.add(button1);
        this.add(button2);
        this.setSize(700, 700);
        this.setLocation(20,20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == this.button1) System.out.println("Button1");
        else if (e.getSource() == this.button2) System.out.println("Button2");
    }
    public static void main(String args[]){
        new AppTest5();
    }

}