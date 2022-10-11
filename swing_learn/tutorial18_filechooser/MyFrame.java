package swing_learn.tutorial18_filechooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MyFrame extends JFrame implements ActionListener{
    
    private JButton button;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        button = new JButton("Select File");
        button.addActionListener(this);


        this.add(button);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.button) {

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File(".")); // ini buat set direktori apa yang akan dibuka pertama kali

            //int response = fileChooser.showOpenDialog(null); //select file to open
            int response = fileChooser.showSaveDialog(null); //select file to save

            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }

        }
    }
}
