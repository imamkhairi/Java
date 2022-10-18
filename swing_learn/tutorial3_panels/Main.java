package swing_learn.tutorial3_panels;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {

        // JPanel = a GUI component that functions as a container to hold other components]
        ImageIcon icon = new ImageIcon("D:\\高専\\Java\\swing_learn\\tutorial3_panels\\small.png");

        JLabel label = new JLabel();
        label.setText("HI");
        label.setIcon(icon);
        
        // kalau make null layout manager gk perlu setting ini
        //label.setVerticalAlignment(JLabel.TOP);
        //label.setHorizontalAlignment(JLabel.RIGHT);

        // set bound kalau pake null layoutmanager
        label.setBounds(100,100,150,150);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0,0,250,250);
        redPanel.setLayout(null);
        redPanel.add(label);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250,0,250,250);
        bluePanel.setLayout(null);
        // bluePanel.add(label);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0,250,500,250);
        greenPanel.setLayout(null); // set layout sebelum add 
        // kalau gk setLayout sepertnya gk bisa set alignment gitu
        greenPanel.add(label);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750, 750);
        frame.setVisible(true);
        // add code di atas, akan muncul diatas
        frame.add(redPanel); // membutuhkan component -> JPanel adalah sebuah component
        frame.add(bluePanel);
        frame.add(greenPanel);
    }
}
