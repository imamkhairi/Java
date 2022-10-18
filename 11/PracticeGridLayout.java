import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class PracticeGridLayout extends JFrame{
    private JButton[] button;
    
    PracticeGridLayout() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.button = new JButton[9];

        this.button[0] = new JButton("button1");
        this.button[1] = new JButton("button2");
        this.button[2] = new JButton("button3");
        this.button[3] = new JButton("button4");
        this.button[4] = new JButton("button5");
        this.button[5] = new JButton("button6");
        this.button[6] = new JButton("button7");
        this.button[7] = new JButton("button8");
        this.button[8] = new JButton("button9");

        JPanel panel = new JPanel();
        panel.setSize(new Dimension(500, 500));
        panel.setLayout(new GridLayout(3,3, 5,5));
        for(int i = 0; i < 9; i++) {
            panel.add(this.button[i]);
        }

        this.getContentPane().add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new PracticeGridLayout();
    }    
}
