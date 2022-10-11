package swing_learn.tutorial14_ComboBox;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.*;
import java.awt.*;

public class MyFrame extends JFrame implements ActionListener{
    private JComboBox comboBox;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        // String[] animals = {"dog","cat","bird"};
        Integer[] animals = {1,2,3}; // -> harus menggunakan wrapper class

        comboBox = new JComboBox(animals);
        comboBox.addActionListener(this);

        // comboBox.setEditable(true);
        // System.out.println(comboBox.getItemCount()); 
        // comboBox.addItem("horse");
        // comboBox.insertItemAt("pig", 0);
        // comboBox.setSelectedIndex(0); // kyk defaultnya index brp
        // comboBox.removeItem("cat");
        // comboBox.removeItemAt(0);
        // comboBox.removeAllItems();

        this.add(comboBox);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.comboBox) {
            System.out.println(this.comboBox.getSelectedItem()); // ini akan return datanya
            // System.out.println(this.comboBox.getSelectedIndex()); // ini akan return indexnya
        }
    }
    
}
