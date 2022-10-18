import javax.swing.*;
import java.awt.*;

public class PracticeFlowLayout extends JFrame{

    private JPanel panel1;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    
    PracticeFlowLayout() {
        super();

        this.panel1 = new JPanel();
        this.panel1.setPreferredSize(new Dimension(420,420));
        this.panel1.setBackground(Color.GRAY);

        this.panel2 = new JPanel();
        this.panel2.setPreferredSize(new Dimension(100,50));
        this.panel2.setBackground(Color.BLUE);

        this.button1 = new JButton("button1");
        this.button1.addActionListener(
            e -> {
                System.out.println("Button1 pressed");
                this.panel2.setBackground(Color.RED);
            }
        );

        this.button2 = new JButton("button2");
        this.button2.addActionListener(
            e -> {
                System.out.println("Button2 pressed");
                this.panel2.setBackground(Color.YELLOW);
            }
        );

        this.panel1.setLayout(new FlowLayout());
        this.panel1.add(this.panel2);
        this.panel1.add(this.button1);
        this.panel1.add(this.button2);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // this.setSize(500,500);
        this.add(panel1);
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new PracticeFlowLayout();
    }
}