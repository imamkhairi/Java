import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppTest4 extends JFrame {
    private JButton button;

    public AppTest4() {
        super();

        this.button = new JButton("Button1");
        this.button.setFocusable(false);
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                this.button.setText("clicked");
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