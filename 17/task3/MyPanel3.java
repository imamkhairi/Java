import javax.swing.*;
import java.awt.*;

public class MyPanel3 extends JPanel{
    private Dimension panelSize = new Dimension(720, 720);

    private Grid myGrid;
    private Chara myChara;
    
    public MyPanel3() {
        // this.chara = new Image[10];
        this.setPreferredSize(this.panelSize);

        this.myGrid = new Grid(this.panelSize);
        this.myChara = new Chara(this.myGrid.getStart(), this.myGrid.getGridSize());

        this.setLayout(null);
        this.add(this.myChara);
        this.add(this.myGrid);
    }

    public void update() {
        this.myChara.updatePath(this.myGrid.getPath());
        // int[] x = this.myChara.getMovement();

        //DEBUG
        // System.out.println(x[0] + ","+ x[1]);
        // System.out.println(this.myChara.getPath());
        
        // this.myChara.updateSpritePosition();

        this.myChara.animateMovement();
        this.myChara.changeMoveValue();

        this.myGrid.clearPath();
        this.myChara.updateSprite();
    }

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