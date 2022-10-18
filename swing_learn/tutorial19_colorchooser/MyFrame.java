
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame implements ActionListener{

    JButton button;
    JLabel label;
    
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Pick a Color");
        button.addActionListener(this);

        label = new JLabel();
        label.setBackground(Color.WHITE);
        label.setText("This is some text");
        label.setFont(new Font("MV Boli", Font.PLAIN, 100));
        label.setOpaque(true); // to display the background color

        this.add(button);
        this.add(label);

        this.pack();
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            JColorChooser colorChooser = new JColorChooser();

            Color color = JColorChooser.showDialog(null, "Pick a Color", Color.BLACK); // untuk memunculkan dialog

            //label.setForeground(color);
            label.setBackground(color);
        }
    }
    
}
