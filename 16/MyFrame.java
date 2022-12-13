import javax.swing.*;

public class MyFrame extends JFrame {
    private MyPanel drawPanel;
    
    public MyFrame() {
        super();

        this.drawPanel = new MyPanel();

        JPanel basePanel = new JPanel();
        basePanel.add(this.drawPanel);

        this.getContentPane().add(basePanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);        
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}