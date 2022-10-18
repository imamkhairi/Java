package swing_learn.tutorial16_progressbar;

import javax.swing.*;
import java.awt.*;


public class ProgressBarDemo {
    
    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar(0,500);
    // parameternya untuk min max

    ProgressBarDemo(){


        bar.setValue(0);
        bar.setBounds(0,0,420,50);
        bar.setStringPainted(true); // menambahkan persentase di atas progress bar nya, intinya agar ada string di atas bar nya
        bar.setFont(new Font("MV Boli", Font.BOLD, 25)); 
        bar.setForeground(Color.RED);
        bar.setBackground(Color.BLACK);

        frame.add(bar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();
    }

    public void fill() {
        int counter = 500;
        while(counter > 0) {
            bar.setValue(counter);

            // ini agar iterasi nya hanya terjadi tiap sekian detik gitu
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            counter -= 1;
        }
        bar.setString("Done!");
    }
}
