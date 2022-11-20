import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestApp3 extends JFrame{
    private TestApp3_Panel p;

    public TestApp3(TestApp3_Panel p) {
        super();

        this.p = p;

        JPanel basePanel = new JPanel();
        basePanel.add(this.p);

        this.getContentPane().add(basePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        // MyMatrix.printMatrix(MyMatrix.projection);
        // MyMatrix.printMatrix(MyMatrix.point);
        // MyMatrix.printMatrix(MyMatrix.matrixMul(MyMatrix.projection, MyMatrix.point));
        new TestApp3(new TestApp3_Panel());
    }
}
