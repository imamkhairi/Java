import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;

public class MyPanel3 extends JPanel{
    private Dimension panelSize = new Dimension(720, 720);
    private Image[] chara;

    // Kemungkinan ini akan pindah ke class baru
    private int gridCount = 10;
    private int gridSize = (int)(this.panelSize.getHeight())/this.gridCount;
    private int box_X;
    private int box_Y;

    // field baru
    private Grid myGrid;
    
    public MyPanel3() {
        this.chara = new Image[10];
        this.setPreferredSize(this.panelSize);

        this.myGrid = new Grid(this.panelSize);

        // this.setLayout(new BorderLayout());

        this.setLayout(null);
        this.add(this.myGrid);
    }

}