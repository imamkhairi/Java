package swing_learn.tutorial15_sliders;

import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;

public class SliderDemo implements ChangeListener{

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JSlider slider;

    SliderDemo() {
        this.frame = new JFrame("Slider Demo");
        this.panel = new JPanel();
        this.label = new JLabel();
        this.slider = new JSlider(0, 100, 50);
        // 3 parameter, min, max, starting
        
        this.slider.setPreferredSize(new Dimension(400, 200));
        
        this.slider.setPaintTicks(true);
        this.slider.setMinorTickSpacing(10);
        
        this.slider.setPaintTrack(true);
        this.slider.setMajorTickSpacing(25);

        this.slider.setPaintLabels(true);
        this.slider.setFont(new Font("MV Boli", Font.PLAIN, 15));
        
        this.slider.setOrientation(SwingConstants.VERTICAL);
        // this.slider.setOrientation(SwingConstants.HORIZONTAL);
        
        this.label.setText("°C = " + slider.getValue());
        this.label.setFont(new Font("MV Boli", Font.PLAIN, 25));

        this.slider.addChangeListener(this); // ChangeListener itu akan triggered setiap kali ada perubahan

        this.panel.add(slider);
        this.panel.add(label);
        this.frame.add(panel);
        this.frame.setSize(420, 420);
        this.frame.setVisible(true);
    
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.label.setText("°C = " + slider.getValue());
    }
    
}
