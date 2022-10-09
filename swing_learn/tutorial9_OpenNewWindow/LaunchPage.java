package swing_learn.tutorial9_OpenNewWindow;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener{
    private JFrame frame = new JFrame();
    private JButton myButton = new JButton("New Window");

    LaunchPage() {
        this.myButton.setBounds(100,160,200,40);
        this.myButton.setFocusable(false);
        this.myButton.addActionListener(this);

        this.frame.add(myButton);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(420,420);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.myButton) {
            frame.dispose(); //menutup frame yang sekarang
            NewWindow myWindow = new NewWindow();
        }
    }
}
