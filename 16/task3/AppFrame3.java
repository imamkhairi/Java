import javax.swing.*;
import java.awt.*;

public class AppFrame3 extends JFrame {
    private AppPanel3 drawPanel;
    
    public AppFrame3() {
        super();

        this.drawPanel = new AppPanel3();

        JPanel basePanel = new JPanel();
        basePanel.add(this.drawPanel);

        this.getContentPane().add(basePanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);        
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AppFrame3();
    }
}