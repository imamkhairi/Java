import java.io.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class TextEditor extends JFrame implements ActionListener{
    private JTextField textField;
    private JTextArea textArea;
    private JButton openButton;
    private JButton saveButton;

    public TextEditor() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.textField = new JTextField(26);
        
        this.textArea = new JTextArea(26,52);

        this.openButton = new JButton("Open File");
        this.openButton.addActionListener(this);

        this.saveButton = new JButton("Save File");
        this.saveButton.addActionListener(this);

        JPanel ioPanel = new JPanel();
        ioPanel.add(this.textField);
        ioPanel.add(this.openButton);
        ioPanel.add(this.saveButton);
        ioPanel.setPreferredSize(ioPanel.getPreferredSize());

        JPanel basePanel = new JPanel();
        basePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        basePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        basePanel.add(ioPanel, gbc);
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        basePanel.add(this.textArea, gbc);
        
        // JPanel basePanel = new JPanel();
        // basePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        // basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.PAGE_AXIS));
        // basePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        // basePanel.add(inputPanel);
        // basePanel.add(textArea);
        // basePanel.add(Box.createHorizontalGlue());

        this.getContentPane().add(basePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new TextEditor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.openButton) {
            System.out.println("Opening "  + this.textField.getText());
            this.openFile();
        }   
        if(e.getSource() == this.saveButton) {
            // System.out.println(this.textField.getText() + " saved");
            // System.out.println(this.textArea.getText());
            this.saveFile();
        }
    }

    private void openFile() {
        String fileName = this.textField.getText();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String buf;
            int line_count = 1;
            // String all = "";
            this.clearTextArea();
            while ((buf = br.readLine()) != null) {
                if(line_count == 1) {
                    this.textArea.append(buf);
                } else {
                    this.textArea.append("\n" + buf);
                }
                line_count ++;
            }
            // System.out.println(all);
            br.close();
            fr.close();
        }
        catch(IOException e) {
            System.out.println("file open error");
            System.exit(1);
        }
    }

    private void saveFile() {
        String fileName = this.textField.getText();
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println(this.textArea.getText());
            bw.write(this.textArea.getText());
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("file save error");
            System.exit(1);
        }
    }

    private void clearTextArea() {
        this.textArea.setText("");
    }
}