import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App1 extends JFrame implements ActionListener{

    private JCheckBox cb1, cb2;
    private JButton judge;
    private JLabel label;
    
    public App1() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel basePanel = new JPanel();
        basePanel.setPreferredSize(new Dimension(500, 500));
        basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));
        basePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        basePanel.setBackground(Color.CYAN);

        this.cb1 = new JCheckBox("数学が得意");
        this.cb1.setFont(new Font("Monaco", Font.PLAIN, 25));
        this.cb2 = new JCheckBox("英語が得意", true);
        this.cb2.setFont(new Font("Monaco", Font.PLAIN, 25));

        this.judge = new JButton("Submit");
        this.judge.addActionListener(this);

        this.label = new JLabel();
        this.label.setFont(new Font("Monaco", Font.PLAIN, 25));


        basePanel.add(this.cb1);
        basePanel.add(this.cb2);
        basePanel.add(this.judge);
        basePanel.add(label);

        this.getContentPane().add(basePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new App1();
    }

    private int judgeCheckBox() {
        int result = -1;
        if(this.cb1.isSelected() && this.cb2.isSelected()) {
            result = 1;
        } else if(this.cb1.isSelected() && !this.cb2.isSelected()) {
            result = 2;
        } else if(!this.cb1.isSelected() && this.cb2.isSelected()) {
            result = 3;
        } else {
            result = 4;
        }
        return result;
    }
// 00
// 01
// 10
// 11
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.judge) {
            if(judgeCheckBox() == 1) this.label.setText("Nice"); 
            else if(judgeCheckBox() == 2) this.label.setText("Math");
            else if(judgeCheckBox() == 3) this.label.setText("Eng");
            else if(judgeCheckBox() == 4) this.label.setText("dumb");
        }
    }

}