import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.*;

public class PracticeBoxLayout extends JFrame{
    PracticeBoxLayout() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.LINE_AXIS));
        // 2 parameter -> container apa yang akan dimanage dg box layout ini
        //                axis where the component will be lay out

        JLabel label = new JLabel("label");
        JButton button = new JButton("Button");

        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setSize(new Dimension(300, 300));
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // JTextField textField = new JTextField();
        JButton button1 = new JButton("Button1");
        JButton button2 = new JButton("Button2");

        // panel.add(textField);
        panel.add(Box.createVerticalGlue());
        panel.add(button1);
        panel.add(Box.createRigidArea(new Dimension(0,50)));
        panel.add(button2);
        panel.add(Box.createVerticalStrut(45));

        this.add(Box.createRigidArea(new Dimension(50,50)));
        this.add(label);
        this.add(Box.createRigidArea(new Dimension(50,50)));
        this.add(button);
        this.add(Box.createRigidArea(new Dimension(50,50)));
        this.add(panel);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new PracticeBoxLayout();
    }
}
