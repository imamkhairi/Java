import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestApp3 extends JFrame implements ChangeListener{
    private TestApp3_Panel p;
    private angleSlider xSlider;
    private angleSlider ySlider;
    private angleSlider zSlider;

    public TestApp3(TestApp3_Panel p) {
        super();
        
        this.p = p;
        this.xSlider = new angleSlider("X : ");
        this.xSlider.addChangeListener(this);
        this.ySlider = new angleSlider("Y : ");
        this.ySlider.addChangeListener(this);
        this.zSlider = new angleSlider("Z : ");
        this.zSlider.addChangeListener(this);

        JPanel basePanel = new JPanel();
        basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.PAGE_AXIS));
        basePanel.add(this.p);
        basePanel.add(this.xSlider.getSliderPanel());
        basePanel.add(this.ySlider.getSliderPanel());
        basePanel.add(this.zSlider.getSliderPanel());

        this.getContentPane().add(basePanel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new TestApp3(new TestApp3_Panel());
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == this.xSlider || e.getSource() == this.ySlider || e.getSource() == this.zSlider) {
            for(int i = 0; i < this.p.getPointsCount(); i++) {
                this.p.rotation(i, this.xSlider.getAngle(), this.ySlider.getAngle(), this.zSlider.getAngle());
                this.p.perspective2D(i);
            }
            this.p.repaint();
        }
    }
}

/* 
https://en.wikipedia.org/wiki/Transformation_matrix#Perspective_projection
https://stackoverflow.com/questions/21835430/how-to-set-size-of-a-jslider
https://en.wikipedia.org/wiki/Rotation_matrix
https://processing.github.io/processing-javadocs/core/processing/core/PVector.html
https://docs.oracle.com/javase/tutorial/2d/advanced/quality.html
https://docs.oracle.com/javase/7/docs/api/javax/swing/JSlider.html
*/
