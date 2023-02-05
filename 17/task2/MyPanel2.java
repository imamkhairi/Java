import javax.swing.*;
import java.awt.*;

public class MyPanel2 extends JPanel {
    private Dimension panelSize = new Dimension(1080, 720);
    private Image[] chara;
    private String fileName;
    private Image sprite;
    private int index = 0;

    public MyPanel2() {
        this.setPreferredSize(this.panelSize);
        this.setBackground(Color.BLACK);
        this.chara = new Image[4];
    }

    public MyPanel2(Toolkit tk) {
        this.setPreferredSize(this.panelSize);
        this.setBackground(Color.BLACK);
        this.sprite = tk.getImage("front0.png").getScaledInstance(120, 140, Image.SCALE_DEFAULT);
    }

    public void setChara(Image[] chara) {
        for(int i = 0; i < chara.length; i ++) {
            this.chara[i] = chara[i];
        }
    }

    public void chngeFileName() {
        if (this.index < 3) {
            this.index++;
        } else {
            this.index = 0;
        }
        this.fileName = "front" + index +".png";
        System.out.println(this.fileName);
    }

    public void updateChara(Toolkit tk) {
        this.chngeFileName();
        this.sprite = tk.getImage(this.fileName).getScaledInstance(120, 140, Image.SCALE_DEFAULT);
    }

    public void increaseIndex() {
        if(this.index < 3) {
            this.index ++;
        } else {
            this.index = 0;
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        // for(int i = 0; i < this.chara.length; i ++) {
        //     g2.drawImage(this.chara[i], 0+120*i, 0, this);
        // }
        g2.drawImage(this.chara[index], 0, 0, this);
    }
} 