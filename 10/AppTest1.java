import javax.swing.*;

public class AppTest1 extends JFrame {
    public AppTest1() {
        super();
    }
    public static void main(String[] args) {
        AppTest1 myFrame = new AppTest1();

        myFrame.setSize(500, 500);
        myFrame.setLocation(10, 20);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);      
    }
}