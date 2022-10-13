import javax.swing.*;
import java.awt.*;

public class ComplexFrame extends JFrame {

    private JLabel redLabel;
    private JLabel greenLabel;
    private JLabel blueLabel;
    private JLabel resutlLabel;

    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;

    private JButton buttonSubmit;
    private JButton buttonTest;

    private int redValue;
    private int greenValue;
    private int blueValue;


    ComplexFrame() {
        super();

        JPanel basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout(5,5));
        basePanel.setPreferredSize(new Dimension(420,500));
        // basePanel.setBackground(Color.CYAN);

        //RED
        this.redSlider = new JSlider(0, 255, 0);
        this.redSlider.setPreferredSize(new Dimension(130, 350));
        this.redSlider.setPaintTicks(true);
        this.redSlider.setMajorTickSpacing(85);
        this.redSlider.setPaintLabels(true);
        this.redSlider.setOrientation(SwingConstants.VERTICAL);
        this.redSlider.addChangeListener(e -> {
            this.redLabel.setText("R = " + this.redSlider.getValue());
            resutlLabel.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
        });

        this.redLabel = new JLabel();
        this.redLabel.setText("R = " + this.redSlider.getValue());
        
        JPanel redPanel = new JPanel();
        redPanel.setPreferredSize(new Dimension(130, 400));
        redPanel.setLayout(new FlowLayout());
        redPanel.add(redSlider);
        redPanel.add(redLabel);

        //GREEN
        this.greenSlider = new JSlider(0, 255, 0);
        this.greenSlider.setPreferredSize(new Dimension(130, 350));
        this.greenSlider.setPaintTicks(true);
        this.greenSlider.setMajorTickSpacing(85);
        this.greenSlider.setPaintLabels(true);
        this.greenSlider.setOrientation(SwingConstants.VERTICAL);
        this.greenSlider.addChangeListener(e -> {
            this.greenLabel.setText("G = " + this.greenSlider.getValue());
            resutlLabel.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
        });

        this.greenLabel = new JLabel();
        this.greenLabel.setText("G = " + this.greenSlider.getValue());
        
        JPanel greenPanel = new JPanel();
        greenPanel.setPreferredSize(new Dimension(130, 400));
        greenPanel.setLayout(new FlowLayout());
        greenPanel.add(greenSlider);
        greenPanel.add(greenLabel);

        //BLUE
        this.blueSlider = new JSlider(0, 255, 0);
        this.blueSlider.setPreferredSize(new Dimension(130, 350));
        this.blueSlider.setPaintTicks(true);
        this.blueSlider.setMajorTickSpacing(85);
        this.blueSlider.setPaintLabels(true);
        this.blueSlider.setOrientation(SwingConstants.VERTICAL);
        this.blueSlider.addChangeListener(e -> {
            this.blueLabel.setText("B = " + this.blueSlider.getValue());
            resutlLabel.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
        });

        this.blueLabel = new JLabel();
        this.blueLabel.setText("B = " + this.greenSlider.getValue());
        
        JPanel bluePanel = new JPanel();
        bluePanel.setPreferredSize(new Dimension(130, 400));
        bluePanel.setLayout(new FlowLayout());
        bluePanel.add(blueSlider);
        bluePanel.add(blueLabel);

        //RESULT
        this.buttonSubmit = new JButton("Sumbit");
        this.buttonSubmit.setPreferredSize(new Dimension(100, 50));
        this.buttonSubmit.setFocusable(false);
        this.buttonSubmit.addActionListener(e -> {
            System.out.println(
            "R = "+ this.redSlider.getValue() + 
            "\nG = " + this.greenSlider.getValue() +
            "\nB = " + this.blueSlider.getValue()
            );
            System.out.println("0x" + 
            Integer.toHexString(this.redSlider.getValue()) + 
            Integer.toHexString(this.greenSlider.getValue()) + 
            Integer.toHexString(this.blueSlider.getValue())
            );
        });

        // this.buttonTest = new JButton("Test");
        // this.buttonTest.setPreferredSize(new Dimension(100, 50));
        // this.buttonTest.setFocusable(false);
        // this.buttonTest.addActionListener(e -> {
        //     resutlLabel.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
        // });

        this.resutlLabel = new JLabel();
        resutlLabel.setPreferredSize(new Dimension(60, 90));
        resutlLabel.setBackground(Color.BLACK);
        resutlLabel.setOpaque(true);

        JPanel resultPanel = new JPanel();
        resultPanel.setPreferredSize(new Dimension(420, 100));
        resultPanel.setLayout(new FlowLayout());
        // resultPanel.add(buttonTest);
        resultPanel.add(resutlLabel);
        resultPanel.add(buttonSubmit);



        basePanel.add(redPanel, BorderLayout.WEST);
        basePanel.add(greenPanel, BorderLayout.CENTER);
        basePanel.add(bluePanel, BorderLayout.EAST);
        basePanel.add(resultPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Color Picker");
        this.getContentPane().add(basePanel);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new ComplexFrame();
    }
}