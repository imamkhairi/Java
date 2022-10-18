import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable{
    private final int tileSize = 120;
    private final int maxCol = 16;
    private final int maxRow = 9;

    private final int screenWidth = tileSize * maxCol;
    private final int screenHeight = tileSize * maxRow;

    private Thread gameThread;
    private KeyHandler keyH = new KeyHandler();

    // Player Location
    private int playerX = 100;
    private int playerY = 100;
    private int playerSpeed = 10;
    
    // FPS
    private int FPS = 60;

    // Backgroud Image
    private Image backgroundImage; 

    // Point 
    Point imageCorner;
    Point prevPt;
    
    // check clicked or not
    boolean imageClicked = false;


    // test
    Pet[] entity;
    int selectedPet;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true);

        this.backgroundImage = new ImageIcon("PRumble/res/setup.png").getImage();

        // set pet
        imageCorner = new Point(100, 0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
        
        entity = new Pet[5];

        entity[0] = new Pet(500, 0);
        entity[1] = new Pet(800, 0);
        entity[2] = new Pet(200, 0);
    }

    public void startGameThread() {
        this.gameThread = new Thread(this); // passing runnable ke sini
        this.gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/this.FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;

        while(this.gameThread != null) {
            // System.out.println("running");
            
            // GAME LOOP
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime  = currentTime;

            if(delta >= 1) {
                // UPDATE
                update();
    
                // REDRAW
                repaint();

                delta --;
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
        if(this.keyH.upPressed == true) {
            this.playerY -= this.playerSpeed;
        }
        if(this.keyH.downPressed == true) {
            this.playerY += this.playerSpeed;
        }
        if(this.keyH.leftPressed == true) {
            this.playerX -= this.playerSpeed;
        }
        if(this.keyH.rightPressed == true) {
            this.playerX += this.playerSpeed;
        }
    }

    // DRAWING OBJECT
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.drawImage(backgroundImage, 0, 0, null);
        for(int i = 0; i <= 2; i++) {
            entity[i].getImageIcon().paintIcon(this, g2, entity[i].getX(),entity[i].getY());
        }

        g2.setColor(Color.WHITE);
        g2.fillRect(playerX, playerY, 120, 120);
        g2.dispose();
    }
    
    private class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint();
            int x = (int)prevPt.getX();
            int y = (int)prevPt.getY();
            for(int i = 0; i <= 2; i++){ // 1 di sini masih bisa diganti
                if(x >= entity[i].getX() && x <= entity[i].getX() + entity[i].getWidth()){
                    if(y >= entity[i].getY() && y <= entity[i].getY() + entity[i].getHeight()){
                        selectedPet = i;
                        System.out.println(selectedPet);
                    }
                }

            }
        }
        public void mouseReleased(MouseEvent e) {
            imageClicked = false;
            selectedPet = -1;
            System.out.println(selectedPet);
        }

    }

    private class DragListener extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e) {
            for(int i = 0; i <= 2; i ++){
                if(selectedPet == i){
                    Point currentPt = e.getPoint();
        
                    entity[i].getPoint().translate(
                        (int)(currentPt.getX() - prevPt.getX()), 
                        (int)(currentPt.getY() - prevPt.getY())
                    );
        
                    prevPt = currentPt;
                }
            }
        }
    }
}