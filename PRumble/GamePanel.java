import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    private final int tileSize = 120;
    private final int maxCol = 16;
    private final int maxRow = 9;

    private final int screenWidth = tileSize * maxCol;
    private final int screenHeight = tileSize * maxRow;

    private Thread gameThread;
    private KeyHandler keyH = new KeyHandler();

    // Player Location (delete)
    private int playerX = 100;
    private int playerY = 100;
    private int playerSpeed = 10;
    
    // FPS
    private int FPS = 60;

    // Backgroud Image
    private Image backgroundImage; 

    // Point 
    Point prevPt;
    Point[] setTeam;

    final int setTeamX = 370;
    final int setTeamY = 540;
    final int maxPetsNumber = 5;
    final int selectionX = 370;
    final int selectionY = 770;
    final int maxSelection = 3;

    // Checkin clicked


    // test
    Pet[] entity;
    Pet[] petSelection;
    public int selectedPet = -1;
    public int selectedSelection = -1;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true);

        this.backgroundImage = new ImageIcon("D:\\Kosen\\Java\\PRumble\\res\\setup.png").getImage();

        // set pet
        ClickListener clickListener = new ClickListener(this);
        DragListener dragListener = new DragListener(this);
        
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
        
        // Point
        setTeam = new Point[this.maxPetsNumber];
        for(int i = 0; i < this.maxPetsNumber; i ++) {
            setTeam[i] = new Point(this.setTeamX + 180*i, this.setTeamY);
        }

        entity = new Pet[this.maxPetsNumber];
        petSelection = new Pet[this.maxSelection];

        for(int i = 0; i < this.maxPetsNumber - 1; i ++) {
            entity[i] = new Pet((int)setTeam[i].getX(), (int)setTeam[i].getY(), this); //180 masih bisa ganti
        }

        for(int i = 0; i < this.maxSelection; i ++) {
            petSelection[i] = new Pet(this.selectionX + 180*i, this.selectionY, this);
        }
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
        for(int i = 0; i < this.maxPetsNumber - 1; i++) {
            entity[i].draw(g2);
        }
        for(int i = 0; i < this.maxSelection; i++) {
            petSelection[i].draw(g2);
        }

        g2.setColor(Color.WHITE);
        g2.fillRect(playerX, playerY, 120, 120);
        g2.dispose();
    }
}