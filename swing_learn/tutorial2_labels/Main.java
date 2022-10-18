package swing_learn.tutorial2_labels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {
    public static void main(String[] args) {

        // JLabel = a GUI display area for a string of text, an image, or both

        ImageIcon image = new ImageIcon("D:\\高専\\Java\\swing_learn\\tutorial2\\1802977.png");
        Border border = BorderFactory.createLineBorder(Color.green,3);

        JLabel label = new JLabel(); // Create a label
        label.setLocation(50,20);

        // TEXT
        label.setText("Bro, do you even code"); // Set text of label
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.TOP); // set text TOP, CENTER, BOTTOM of imageicon
        label.setForeground(new Color(0x00FF00)); // set font color
        label.setFont(new Font("Arial Black", Font.PLAIN, 50)); // set properties of font
        
        label.setIconTextGap(100); // set icon and text gap
        
        // BACKGROUND
        label.setBackground(Color.blue); // set backgroud color
        label.setOpaque(true); // agar setBackground berefek 
        label.setBorder(border);
        
        // ALIGNMENT 
        label.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label
        // label.setBounds(50,0,600,600); // x dan y adalah posisi akan muncul 
        // label defaultnya akan menjadi seukuran windowsnya, diatas cara set ukurannya 

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(700, 700);
        //frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.pack(); // resize the frame size accordingly to the content
        // posisikan pack setelah memasukkan semua component yang diinginkan
    }
    
}
