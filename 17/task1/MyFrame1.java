import javax.swing.*;
import java.awt.*;

// ini res buat filenya masih bisa diganti (diutamakan ganti)
// https://github.com/danhales/linearalgebra/blob/4380eda5aab03be6b7cd6c242c7b025e0ea8f351/Vector.java#L310
// github itu worth check lah ya
// ubah ke yang pake buffer?
// sampai tgl 11 bulan 1

public class MyFrame1 extends JFrame {
    private MyPanel1 mp;

    public MyFrame1() {
        super();
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        // Image chara = tk.getImage("/mnt/home/p214071/Java/17/res/png/Idle (1).png");
        Image chara = tk.getImage("Dead (1).png").getScaledInstance(200,170, Image.SCALE_DEFAULT);

        this.mp = new MyPanel1();
        this.mp.setChara(chara);

        this.getContentPane().add(this.mp);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new MyFrame1();
    }
}