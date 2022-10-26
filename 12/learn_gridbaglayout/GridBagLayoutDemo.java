package learn_gridbaglayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class GridBagLayoutDemo extends JFrame {
    
    public GridBagLayoutDemo() {
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();
        
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("GridBagLayout Demo");
        this.setLocationRelativeTo(null);
        this.setLayout(layout);

        JButton btn1 = new JButton("button1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(btn1, gbc);

        JButton btn2 = new JButton("button2");
        // gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(btn2, gbc);

        JButton btn3 = new JButton("button3");
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(btn3, gbc);

        JButton btn4 = new JButton("button4");
        gbc.gridx = 2;
        gbc.gridy = 1;
        this.add(btn4, gbc);

        JButton btn5 = new JButton("button5");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        this.add(btn5, gbc);


        this.setVisible(true);
    }
    
}
