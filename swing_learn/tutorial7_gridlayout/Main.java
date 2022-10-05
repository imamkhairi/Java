package swing_learn.tutorial7_gridlayout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        // GridLayout = place components in a grid of cells.
        //              Each component takes all the available space within its cell,
        //              and each cell is the same size.
    
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout( 3, 3, 10, 10));
        // parameter baris, kolom, hgap, vgap
        // ketika berlebih akan diprioritaskan jumlah baris yang telah di setting

        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("7"));
        frame.add(new JButton("8"));
        frame.add(new JButton("9"));
        frame.add(new JButton("10"));

        frame.setVisible(true);
    }
}
