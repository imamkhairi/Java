import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame2 extends JFrame implements MouseListener{
    private MyPanel2 mp;
    private Image[] chara;

    private Toolkit tk;
    public MyFrame2() {
        super();

        this.chara = new Image[1];
        
        this.tk = Toolkit.getDefaultToolkit();
        // for(int i = 0; i < chara.length; i ++) {
        //     this.chara[i] = this.tk.getImage("front" + i +".png").getScaledInstance(120, 140, Image.SCALE_DEFAULT);
        // }

        this.mp = new MyPanel2(tk);
        // this.mp.setChara(this.chara);
        // this.mp.updateChara(tk);

        this.getContentPane().add(this.mp);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.addMouseListener(this);
    }

    public static void main(String[] args) {
        new MyFrame2();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("clicked");        
        this.mp.updateChara(this.tk);
        this.mp.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}