package game;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // final int originalTileSize = 16;
    // final int scale = 3;

    // final int tileSize = originalTileSize * scale;
    final int tileSize = 120;
    final int maxCol = 16;
    final int maxRow = 9;
    final int screenWidth = maxCol * tileSize;
    final int screenHeight = maxRow * tileSize;

    // FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // Set Player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 10;

    Image bg;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true); 
        // if sets to true, all the drawing from this component will be done in an offscreen painting buffer
        // intinya improve game rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.bg = new ImageIcon("game\\team.png").getImage();
    }

    public void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    // Sleep method
    // @Override
    // public void run() {
    //     double drawInterval = 1000000000/this.FPS; // 0.01666.. s
    //     double nextDrawTime = System.nanoTime() + drawInterval;
    //     // disini tempat game loop nya 
    //     while(this.gameThread != null) {
            
    //         // Update information
    //         update();
    //         // Draw to the screen
    //         repaint();

    //         try {
    //             double remainingTime = nextDrawTime - System.nanoTime();
    //             remainingTime = remainingTime / 1000000; // convert to mili

    //             if(remainingTime < 0) {
    //                 remainingTime = 0;
    //             }
                
    //             Thread.sleep((long)remainingTime); // mili

    //             nextDrawTime += drawInterval;
    //         } catch (InterruptedException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }
    //     }
    // }

    @Override
    public void run() {
        double drawInterval = 1000000000/this.FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            // hitung berapa banyak waktu yang udah lewat
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            // kalau udh lewat batas drawIntervalnya update
            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000) {
                System.out.println("FPS : " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    

    public void update() {
        if(keyH.upPressed == true) {
            playerY -= playerSpeed;
        }
        if(keyH.downPressed == true) {
            playerY += playerSpeed;
        }
        if(keyH.leftPressed == true) {
            playerX -= playerSpeed;
        }
        if(keyH.rightPressed == true) {
            playerX += playerSpeed;
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D)g;
        
        g2D.drawImage(bg, 0, 0, null);
        g2D.setColor(Color.WHITE);
        g2D.fillRect(playerX, playerY, 120, 120);
        g2D.dispose();
    }
}
