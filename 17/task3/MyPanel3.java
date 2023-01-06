import javax.swing.*;
import java.awt.*;

public class MyPanel3 extends JPanel{
    private Dimension panelSize = new Dimension(720, 720);
    // private Image[] chara;

    private Grid myGrid;
    private Chara myChara;
    
    public MyPanel3() {
        // this.chara = new Image[10];
        this.setPreferredSize(this.panelSize);

        this.myGrid = new Grid(this.panelSize);
        this.myChara = new Chara();

        this.setLayout(null);
        this.add(this.myChara);
        this.add(this.myGrid);
    }

    public void update() {
        this.myChara.updateSprite();
    }

    //debug, List jalan dan bisa digunakan
    public void checkOpen() {
        if(this.myGrid.getOpen().isEmpty()){
            System.out.println(this.myGrid.getOpen().isEmpty());
        } else {
            // System.out.println(this.myGrid.getOpen().get(0).x);
            // System.out.println(this.myGrid.getOpen().get(0).y);
            System.out.println(this.myGrid.getOpen().size());
        }
    }

}