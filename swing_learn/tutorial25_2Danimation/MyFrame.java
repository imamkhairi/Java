// package swing_learn.tutorial25_2Danimation;

import java.awt.*;

import javax.swing.*;

public class MyFrame extends JFrame{

    MyPanel panel;

    MyFrame() {
        panel = new MyPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        this.pack();
        this.setLocationRelativeTo(null); // supaya windownya muncul di tengah
        this.setVisible(true);
    }
    
}
