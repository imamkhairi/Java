package swing_learn.tutorial22_DragandDrop;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
    DragPanel dragPanel = new DragPanel();
    
    MyFrame() {
        
        this.add(dragPanel);
        this.setTitle("Drag & Drop demo");
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
