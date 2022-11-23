import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class TestApp2 extends JFrame implements ChangeListener{
    private JSlider slider;
    private JTextField textField;
    
    public TestApp2() {
        super();
        
        this.slider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
        this.slider.addChangeListener(this);
        this.slider.setPaintTicks(true);
        this.slider.setMajorTickSpacing(20);
        this.slider.setPaintLabels(true);
        this.slider.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
        this.slider.setForeground(Color.LIGHT_GRAY);

        this.textField = new JTextField(10);
        this.textField.setText("slider: " + this.slider.getValue());

        JPanel basePanel = new JPanel();
        basePanel.add(slider);
        basePanel.add(textField);

        this.getContentPane().add(basePanel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestApp2();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == this.slider) {
            int value = this.slider.getValue();
            this.textField.setText("slider: " + value);
        }
    }
}