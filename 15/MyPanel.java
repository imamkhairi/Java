import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public MyPanel() {
        super.setBackground(new Color(240, 240, 250));
        super.setPreferredSize(new Dimension(700, 700));
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        super.paintComponent(g);

        g2.setColor(Color.BLACK);
        // g2.setStroke(new BasicStroke(2));
        // g2.drawLine(50, 50, 100, 100);
        // g2.drawOval(32, 16, 256, 126);
        for(int i = 0; i < 11; i++) {
            // g2.drawOval(10+(100+10*i)/2, 10 + 25*i, 100+10*i, 100+10*i);
            g2.drawOval(10+i*100/2,10+i*100/2,100,100);
        }
        // g2.drawString("文字列をグラフィックスとして表示", 48, 48);
    }

    // nanti bikin pacman wkwk

}