import javax.swing.*;

public class MyFrame extends JFrame {
    private MyPanel mp;

    public MyFrame(MyPanel mp) {
        super();

        this.mp = mp;
        JPanel panel = new JPanel();
        panel.add(this.mp);
        super.getContentPane().add(panel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main (String[] args) {
        new MyFrame(new MyPanel());
    }
}