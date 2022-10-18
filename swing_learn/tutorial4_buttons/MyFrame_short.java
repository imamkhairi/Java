package swing_learn.tutorial4_buttons;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame_short extends JFrame {
    JButton button;
    JLabel label;

    MyFrame_short() {
        
        ImageIcon icon = new ImageIcon("D:\\高専\\Java\\swing_learn\\tutorial4_buttons\\small.png");
        ImageIcon icon2 = new ImageIcon("D:\\高専\\Java\\swing_learn\\tutorial4_buttons\\labl.png");

        label = new JLabel();
        label.setIcon(icon2);
        label.setBounds(150, 250, 150,150);
        label.setVisible(false);

        button = new JButton();
        button.setBounds(100, 100, 250, 150);
        button.addActionListener(e -> {
            System.out.println("poo");
            label.setVisible(true);
        }); // e -> {} merupakan lambda expression
        // ini menyingkat penggunaan ActionListener
        button.setText("This is a button");
        button.setFocusable(false); // false akan menghilangkan kyk box disekitaran textnya
        button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button.setIconTextGap(-5);
        button.setForeground(Color.CYAN); // set font color
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createEtchedBorder());
        // button.setEnabled(false); mematikan button
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }

}
