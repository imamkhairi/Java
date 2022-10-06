import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppTest4 extends JFrame {
    private JButton button;
    private int count;

    public AppTest4() {
        super();

        this.count = 0;

        this.button = new JButton("Off");
        this.button.setFocusable(false);
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                count ++;
                if(count%2 == 1) button.setText("On");
                else button.setText("Off");
            }
        });

        this.add(this.button);

        this.setSize(500, 500);
        this.setLocation(10, 10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AppTest4();
    }

}