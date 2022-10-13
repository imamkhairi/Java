import javax.swing.*;
import java.awt.*;


public class PracticeBorderLayout extends JFrame{

    private JButton button1;
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel eastPanel;
    private JPanel westPanel;
    private boolean colorized;

    PracticeBorderLayout() {
        super();

        this.colorized = false;

        this.northPanel = new JPanel();
        this.northPanel.setPreferredSize(new Dimension(50,50));

        this.southPanel = new JPanel();
        this.southPanel.setPreferredSize(new Dimension(50,50));

        this.westPanel = new JPanel();
        this.westPanel.setPreferredSize(new Dimension(50,50));

        this.eastPanel = new JPanel();
        this.eastPanel.setPreferredSize(new Dimension(50,50));
        
        this.button1 = new JButton("Click me!");
        this.button1.addActionListener(e -> colorize());
        
        JPanel panel1 = new JPanel();
        // panel1.setBackground(Color.WHITE);
        panel1.setPreferredSize(new Dimension(420,420));
        panel1.setLayout(new BorderLayout(3,3));

        panel1.add(this.northPanel, BorderLayout.NORTH);
        panel1.add(this.southPanel, BorderLayout.SOUTH);
        panel1.add(this.eastPanel, BorderLayout.EAST);
        panel1.add(this.westPanel, BorderLayout.WEST);
        panel1.add(this.button1, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel1);
        this.pack();
        this.setVisible(true); 
    }
    
    public static void main(String[] args){
        new PracticeBorderLayout();
    }

    private void colorize() {
        if(!this.colorized) {
            this.northPanel.setBackground(new Color(0xFF00FF));
            this.southPanel.setBackground(new Color(255,0,0));
            this.westPanel.setBackground(Color.ORANGE);
            this.eastPanel.setBackground(Color.YELLOW);
            this.colorized = true;
        } else {
            this.northPanel.setBackground(null);
            this.southPanel.setBackground(null);
            this.westPanel.setBackground(null);
            this.eastPanel.setBackground(null);
            this.colorized = false;
        }
        
    }
}