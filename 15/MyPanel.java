import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private final Dimension windowSize = new Dimension(700, 700);

    public MyPanel() {
        super.setBackground(new Color(240, 240, 250));
        super.setPreferredSize(windowSize);
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        super.paintComponent(g);

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.BLACK);

        int r  = 30;
        int prev_r = r;
        int next_r = r;
        int x = (int)(this.windowSize.getWidth()/2);


        for(int i = 0; i < 15; i++) {
            next_r  = prev_r + i*2;
            g2.drawOval(x - next_r, 10, next_r*2, next_r*2);
            g2.drawOval(x - next_r, 490 - next_r*2, next_r*2, next_r*2);
            prev_r = next_r;
        }
    }
}