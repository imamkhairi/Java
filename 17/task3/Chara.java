import javax.swing.*;
import java.awt.*;

// public class Chara extends JPanel{
//     private String fileName;
//     private Image sprite;
//     private Toolkit tk;

//     public Chara() {
//         // this.setPreferredSize(new Dimension(300,300));
//         this.tk = Toolkit.getDefaultToolkit();
//         this.sprite = tk.getImage("front0.png").getScaledInstance(60, 70, Image.SCALE_DEFAULT);
//         this.setBounds(0, 0, 60, 70);
//     }

//     @Override
//     public void paintComponent(Graphics g) {
//         Graphics2D g2 = (Graphics2D)g;
//         g2.drawImage(this.sprite, 0, 0, this);
//     }
// }

public class Chara extends JLabel {
    private String fileName;
    private String dir;
    private String action;
    private ImageIcon sprite;
    private int scale = 4;
    private final int width = 12;
    private final int height = 14;

    private int index = 0;

    public Chara() {
        // rightwalk masih agak aneh
        this.dir = "left";
        this.action = "walk";
        this.updateFileName(this.dir, this.action, 0);
        // this.sprite = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(this.width*this.scale, this.height*this.scale, Image.SCALE_DEFAULT));
        // this.setIcon(this.sprite);
        this.updateSprite();
        this.setBounds(0, 0, this.width*this.scale, this.height*this.scale);
    }

    private void updateFileName(String dir, String action, int index) {
        this.fileName = dir + action + index;
    }

    public void setFileIndex(int i) {
        this.index = i;
        String dum = this.dir + this.action + this.index + ".png";
        this.fileName = dum;
    }

    public void updateSprite() {
        if(this.index < 3) {
            this.index ++;
        } else {
            this.index = 0;
        }
        this.setFileIndex(this.index);
        this.sprite = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(this.width*this.scale, this.height*this.scale, Image.SCALE_DEFAULT));
        this.setIcon(this.sprite);
    }

    public int getIndex() {
        return this.index;
    }
}