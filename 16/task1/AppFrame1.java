import javax.swing.*;

public class AppFrame1 extends JFrame {
    private AppPanel1 drawPanel;
    
    public AppFrame1() {
        super();

        this.drawPanel = new AppPanel1();

        JPanel basePanel = new JPanel();
        basePanel.add(this.drawPanel);

        this.getContentPane().add(basePanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new AppFrame1();
    }
}