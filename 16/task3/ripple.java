import java.awt.*;
import java.awt.event.*;

public class ripple {
    private int cols = 501;
    private int rows = 501;
    private int mid = (rows-1)/2;
    private double[][] current = new double[this.rows][this.cols];
    private double[][] previous = new double[this.rows][this.cols];
    private double damping = 0.99;
    private int count = 0; // buat ngilangin tengahnya yang nyisa 1
    private AppPanel3 panel;

    public ripple(AppPanel3 panel) {
        this.panel = panel;
        for(int i = 0; i < this.rows; i ++) {
            for(int j = 0; j < this.rows; j ++) {
                this.current[i][j] = 0;
                this.previous[i][j] = 0;
            }
        }
    }

    public void start(int x, int y, Graphics2D g) {
        if(this.count == 0)this.previous[this.mid][this.mid] = 1.0; // gara2 ini setelah loop tengahnya jadi nyisa satu
        // System.out.println();
        // this.printValue(this.previous);
        for(int i = 1; i < this.rows - 1; i ++) {
            for(int j = 1; j < this.cols - 1; j ++) {
                this.current[i][j] = (
                    this.previous[i-1][j] + 
                    this.previous[i+1][j] +
                    this.previous[i][j-1] + 
                    this.previous[i][j+1]) / 2 -
                    this.current[i][j];
                this.current[i][j] = this.current[i][j]*this.damping;
                // System.out.println(i + "    " + this.current[i][j]);
            }
        }
        // System.out.println();
        // this.printValue(this.current);

        this.panel.testDraw(x, y, g, this.current);
        this.panel.repaint();
        this.count++;

        double[][] temp = this.current;
        this.current = this.previous;
        this.previous = temp;
        // this.resetCurrent();

        // System.out.println();
        // this.printValue(this.previous);
        // System.out.println();
        // this.printValue(this.current);
        // System.out.println("---------------------------");
        // System.out.println();
    }

    public void resetAll() {
        for(int i = 0; i < this.rows; i ++) {
            for(int j = 0; j < this.rows; j ++) {
                this.current[i][j] = 0;
                this.previous[i][j] = 0;
            }
        }
        this.count = 0;
    }

    //debug
    private void printValue(double[][] target) {
        int length = target.length;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j ++) {
                System.out.print(target[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public void resetCurrent() {
        for(int i = 0; i < this.rows; i ++) {
            for(int j = 0; j < this.rows; j ++) {
                this.current[i][j] = 0;
            }
        }
    }


    public double[][] getCurrent(){
        return this.current;
    }

    public double[][] getPrevious(){
        return this.previous;
    }

    public static int getValue(int i, int j, double[][] target) {
        return Math.abs(Math.round((float)target[i][j]));
    }
}