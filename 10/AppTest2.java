import javax.swing.*;

public class AppTest2 extends JFrame{
    private JButton button;

    public AppTest2() {
        super();
        this.button = new JButton("Button");
        super.getContentPane().add(this.button);
        //this.add(button);
    }
    
    public static void main(String[] args) {
        AppTest2 myFrame = new AppTest2();

        myFrame.setSize(500, 500);
        myFrame.setLocation(10,10);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
}