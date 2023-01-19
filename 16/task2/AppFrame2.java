import javax.swing.*;

public class AppFrame2 extends JFrame {
    private AppPanel2 drawPanel;
    
    public AppFrame2() {
        super();

        this.drawPanel = new AppPanel2();

        JPanel basePanel = new JPanel();
        basePanel.add(this.drawPanel);

        this.getContentPane().add(basePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        System.out.println(this.getContentPane().getSize());
    }
    
    public static void main(String[] args) {
        new AppFrame2();
    }
}