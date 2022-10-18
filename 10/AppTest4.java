import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppTest4 extends JFrame implements ActionListener{
    private JButton button;
    private boolean on;

    public AppTest4() {
        super();

        this.on = false;

        this.button = new JButton("Off");
        this.button.setFocusable(false);
        this.button.addActionListener(
            // new ActionListener() {
            //     @Override
            //     public void actionPerformed(ActionEvent e){
            //         if(!on){
            //             on = true;
            //             button.setText("On");
            //         } else {
            //             on = false;
            //             button.setText("Off");
            //         }
            //     }
            // }
            this
        );

        // this.add(this.button);
        super.getContentPane().add(this.button);

        this.setSize(500, 500);
        this.setLocation(10, 10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AppTest4();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.button)
        {
            if(this.on) {
                this.on = false;
                this.button.setText("Off");
            } else {
                this.on = true;
                this.button.setText("On");
            }
        }
    }

}