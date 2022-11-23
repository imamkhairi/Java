import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.*;

public class angleSlider extends JSlider{
    private JPanel panel;
    private JLabel textLabel;

    public angleSlider(String angle) {
        super();
        this.textLabel = new JLabel();
        this.textLabel.setText(angle);

        this.setPreferredSize(new Dimension(400,50));
        this.setPaintTicks(true);
        this.setValue(0);
        this.setMaximum(360);
        this.setMinorTickSpacing(15);
        this.setMajorTickSpacing(45);
        this.setPaintLabels(true);
        this.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
        this.setForeground(Color.GRAY);

        this.panel = new JPanel();
        panel.add(textLabel);
        panel.add(this);
    }
    
    public JPanel getSliderPanel() {
        return this.panel;
    }

    public double getAngle() {
        return (double)this.getValue();
    }
}
