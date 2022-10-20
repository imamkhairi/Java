import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App2 extends JFrame implements ActionListener{
    private JRadioButton rb1, rb2, rb3;
    private JButton submitButton;
    
    public App2() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.CYAN);
        

        this.submitButton = new JButton("Submit");
        this.submitButton.addActionListener(this);

        this.rb1 = new JRadioButton("就職");
        this.rb1.setFont(new Font("Monaco", Font.PLAIN, 20));
        this.rb2 = new JRadioButton("専攻科に進学");
        this.rb2.setFont(new Font("Monaco", Font.PLAIN, 20));
        this.rb3 = new JRadioButton("大学編入", true);
        this.rb3.setFont(new Font("Monaco", Font.PLAIN, 20));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.rb1);
        buttonGroup.add(this.rb2);
        buttonGroup.add(this.rb3);

        buttonPanel.add(this.rb1);
        buttonPanel.add(this.rb2);
        buttonPanel.add(this.rb3);

        basePanel.add(buttonPanel, BorderLayout.CENTER);
        basePanel.add(submitButton, BorderLayout.SOUTH);
        
        this.getContentPane().add(basePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new App2();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.submitButton) {
            checkRadioButton();
        }
    }

    private void checkRadioButton() {
        if(this.rb1.isSelected()) System.out.println("work");
        if(this.rb2.isSelected()) System.out.println("staying");
        if(this.rb3.isSelected()) System.out.println("uni");
    }
}