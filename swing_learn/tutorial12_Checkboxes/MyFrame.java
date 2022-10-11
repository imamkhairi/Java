package swing_learn.tutorial12_Checkboxes;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Font;

public class MyFrame extends JFrame implements ActionListener{
    
    private JButton button;
    private JCheckBox checkBox;
    ImageIcon xIcon;
    ImageIcon checkIcon;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        xIcon = new ImageIcon("swing_learn\\tutorial12_Checkboxes\\x_icon.png");
        checkIcon = new ImageIcon("swing_learn\\tutorial12_Checkboxes\\check.png");

        button = new JButton();
        button.setText("submit");
        button.addActionListener(this);

        checkBox = new JCheckBox();
        checkBox.setText("I'm not a robot");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Consolas", Font.PLAIN, 35));
        checkBox.setIcon(xIcon);
        checkBox.setSelectedIcon(checkIcon);

        this.add(button);
        this.add(checkBox);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.button) {
            System.out.println(this.checkBox.isSelected());
        }
    }

}
