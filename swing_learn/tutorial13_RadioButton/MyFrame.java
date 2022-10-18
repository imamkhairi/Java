package swing_learn.tutorial13_RadioButton;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class MyFrame extends JFrame implements ActionListener{

    private JRadioButton pizzaButton;
    private JRadioButton hamburgerButton;
    private JRadioButton hotdogButton;

    private ImageIcon pizzaIcon;
    private ImageIcon hamburgerIcon;
    private ImageIcon hotdogIcon;
    
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        pizzaIcon = new ImageIcon("swing_learn\\tutorial13_RadioButton\\check.png");
        hamburgerIcon = new ImageIcon("swing_learn\\tutorial13_RadioButton\\small.png");
        hotdogIcon = new ImageIcon("swing_learn\\tutorial13_RadioButton\\x_icon.png");

        pizzaButton = new JRadioButton("pizza");
        hamburgerButton = new JRadioButton("hamburger");
        hotdogButton = new JRadioButton("hotdog");

        // digroup agar hanya bisa memilih satu button
        ButtonGroup group = new ButtonGroup();
        group.add(pizzaButton);
        group.add(hamburgerButton);
        group.add(hotdogButton);

        pizzaButton.addActionListener(this);
        hamburgerButton.addActionListener(this);
        hotdogButton.addActionListener(this);

        pizzaButton.setIcon(pizzaIcon);
        hamburgerButton.setIcon(hamburgerIcon);
        hotdogButton.setIcon(hotdogIcon);

        this.add(pizzaButton);
        this.add(hamburgerButton);
        this.add(hotdogButton);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pizzaButton){
            System.out.println("You ordered pizza!");
        } 
        else if(e.getSource() == hamburgerButton){
            System.out.println("You ordered a hamburger!");
        }
        else if(e.getSource() == hotdogButton){
            System.out.println("You orderd a hotdog!");
        }
    }
}

