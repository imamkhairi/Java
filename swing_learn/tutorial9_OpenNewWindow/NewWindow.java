package swing_learn.tutorial9_OpenNewWindow;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
// import java.awt.*;

public class NewWindow {
    private JFrame frame = new JFrame();
    private JLabel label = new JLabel("Hello!");

    NewWindow() {
        this.label.setBounds(0,0,100,50);
        this.label.setFont(new Font(null, Font.PLAIN,25));

        this.frame.add(label);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(420,420);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }
}
