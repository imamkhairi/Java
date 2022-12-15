import javax.swing.*;
import java.awt.*;

public class MyFrame2 extends JFrame {
    private MyPanel2 mp;
    private Image[] chara;

    public MyFrame2() {
        super();

        this.chara = new Image[5];
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        for(int i = 0; i < chara.length; i ++) {
            this.chara[i] = tk.getImage("Dead (" + (i+1) + ").png").getScaledInstance(200,170, Image.SCALE_DEFAULT);
        }

        this.mp = new MyPanel2();
        this.mp.setChara(this.chara);

        this.getContentPane().add(this.mp);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame2();
    }
}