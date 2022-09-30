package swing_learn.tutorial4_buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener{
    // agar bisa menerima input maka perlu implements ActionListener
    // implements adalah keyword yang dibutuhkan agar bisa menggunakan interface

    JButton button;

    MyFrame() {
        button = new JButton();
        button.setBounds(200, 100, 100, 50);
        button.addActionListener(this); // menambahkan listener ke sebuah object

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(button);
    }

    // fungsi untuk mendeklarasi ketika ada action yang terdeteksi
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) { // ketika button diclick
            System.out.print("Ntol");
        }
    }
}
