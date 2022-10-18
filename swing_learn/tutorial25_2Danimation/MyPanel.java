package swing_learn.tutorial25_2Danimation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener{

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image enemy;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 2;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT)); // karena pakai pack() di frame nya
        this.setBackground(Color.GRAY);

        enemy = new ImageIcon("D:\\Kosen\\Java\\swing_learn\\tutorial25_2Danimation\\small.png").getImage();
        backgroundImage = new ImageIcon("swing_learn\\tutorial25_2Danimation\\team.png").getImage();
        timer = new Timer(10, this);
        // 2 argument -> delay, ActionListener
        timer.start();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g); // supaya method ini mengeksekusi apa yang jadi awalnya (paint background)
        
        Graphics2D g2D = (Graphics2D)g;
        g2D.drawImage(backgroundImage,0,0,null);
        g2D.drawImage(enemy, x, y,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x >= PANEL_WIDTH - enemy.getWidth(null) || x < 0) {
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;

        if(y >= PANEL_HEIGHT - enemy.getWidth(null) || y < 0) {
            yVelocity = yVelocity * -1;
        }
        y = y + yVelocity;
        repaint(); // untuk memanggil lagi paint, tapi karena gk boleh direct makanya gini
    }
    
}
