package swing_learn.tutorial21_mouselistener;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.*;

public class MyFrame extends JFrame implements MouseListener{

    private JLabel label;
    ImageIcon angry;
    ImageIcon happy;
    ImageIcon nervous;
    ImageIcon smile;


    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new FlowLayout());

        smile = new ImageIcon("swing_learn\\tutorial21_mouselistener\\smile.png");
        happy = new ImageIcon("swing_learn\\tutorial21_mouselistener\\happy.png");
        nervous = new ImageIcon("swing_learn\\tutorial21_mouselistener\\nervous.png");
        angry = new ImageIcon("swing_learn\\tutorial21_mouselistener\\angry.png");

        label = new JLabel();
        label.setIcon(smile);
        label.addMouseListener(this);

        this.add(label);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Invoked when a mouse button has been clicked (pressed and released) on a component
        // System.out.println("You clicked the mouse");
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Invoked when a mouse button has been pressed on a component
        System.out.println("You pressed the mouse");
        label.setIcon(angry);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Invoked when a mouse button has been released on a component
        System.out.println("You released the mouse");
        label.setIcon(happy);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Invoked when the mouse enters a components
        System.out.println("You entered the component");
        label.setIcon(nervous);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Invoked when the mouse exits a component
        System.out.println("You exited the component");
        label.setIcon(smile);
    }
    
}
