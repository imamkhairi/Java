package swing_learn.tutorial1_panels;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MyFrame extends JFrame {
    MyFrame() {
        this.setTitle("JFrame Title goes here"); // sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit app 
        // ada DO_NOTHING_ON_CLOSE atau HIDE_ON_CLOSE (defaultnya ini)
        this.setResizable(false); // prevent frame to get resized
        this.setSize(690,420); // set x and y dimension
        this.setVisible(true); // set visibilitas
        
        ImageIcon image = new ImageIcon("D:\\高専\\Java\\swing_learn\\image.png"); //create an ImageIcon
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0x123423));
        // untuk ini tersedia warna2 basic juga tinggal Color.
        // Color(int,int,int) untuk masukin nilai rgb
        // Color(hexadecimal) juga bisa 
    
    } 
    
}
